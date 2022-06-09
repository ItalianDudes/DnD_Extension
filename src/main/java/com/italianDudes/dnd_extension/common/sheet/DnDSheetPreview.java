package com.italianDudes.dnd_extension.common.sheet;

import com.italianDudes.dnd_extension.DnD_Extension;
import com.italianDudes.dnd_extension.common.sheet.components.SheetHeader;
import com.italianDudes.gvedk.common.*;
import com.italianDudes.gvedk.common.exceptions.IO.directory.DirectoryNotFoundException;
import com.italianDudes.gvedk.common.exceptions.IO.socket.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

@SuppressWarnings("unused")
public class DnDSheetPreview implements Serializable {

    //Attributes
    private final SheetHeader sheetHeader;
    private transient final FormattedImage characterImage;

    //Constructors
    public DnDSheetPreview(SheetHeader sheetHeader, File characterImage) {
        this.sheetHeader = sheetHeader;
        String formatName = ImageHandler.getImageExtension(characterImage.getAbsolutePath());
        BufferedImage temp;
        try {
            temp = ImageIO.read(characterImage);
        }catch (IOException e){
            Logger.log(e);
            temp = null;
        }
        this.characterImage = new FormattedImage(temp,formatName);
    }
    public DnDSheetPreview(SheetHeader sheetHeader, String characterImagePath){
        this(sheetHeader,new File(characterImagePath));
    }
    public DnDSheetPreview(SheetHeader sheetHeader, FormattedImage characterImage){
        this.sheetHeader = sheetHeader;
        this.characterImage = characterImage;
    }

    //Methods
    public SheetHeader getHeaderScheda(){
        return sheetHeader;
    }
    public FormattedImage getCharacterImage(){
        return characterImage;
    }
    public static DnDSheetPreview readPreview(File sheetDirectory) throws IOException {

        File pageOneDirectory = new File(sheetDirectory.getAbsolutePath()+"/"+ DnD_Extension.Defs.DIRNAME_PAGE_ONE);
        File pageTwoDirectory = new File(sheetDirectory.getAbsolutePath()+"/"+ DnD_Extension.Defs.DIRNAME_PAGE_TWO);

        if(!DirectoryHandler.directoryExist(pageOneDirectory))
            throw new DirectoryNotFoundException("directory "+pageOneDirectory.getAbsolutePath()+" not found");

        if(!DirectoryHandler.directoryExist(pageTwoDirectory))
            throw new DirectoryNotFoundException("directory "+pageTwoDirectory.getAbsolutePath()+" not found");

        File characterImageFile = FileHandler.findFilesWithName(pageTwoDirectory, DnD_Extension.Defs.FILENAME_CHARACTER_IMAGE_NO_EXT)[0];
            String imageExt = FileHandler.getFileExtension(characterImageFile);

        SheetHeader sheetHeader = SheetHeader.readSheetHeader(new File(pageOneDirectory.getAbsoluteFile()+"/"+ DnD_Extension.Defs.FILENAME_HEADER_SHEET));
        FormattedImage characterImage = new FormattedImage(ImageHandler.readImage(characterImageFile),imageExt);

        return new DnDSheetPreview(sheetHeader,characterImage);

    }
    public static void sendPreview(Peer peer, DnDSheetPreview sheetPreview) throws OutputStreamWriteException, SpecializedStreamInstancingException, ValidatingStreamException {
        try {
            Serializer.sendObject(peer, sheetPreview.sheetHeader);
        }catch (Exception e){
            Logger.log(e);
        }
        if(sheetPreview.characterImage.getImage()!=null){
            Serializer.sendBoolean(peer,true);
            Serializer.sendImage(peer,sheetPreview.characterImage);
        }else{
            Serializer.sendBoolean(peer,false);
        }
    }
    public static DnDSheetPreview receivePreview(Peer peer) throws SpecializedStreamInstancingException, InputStreamReadException, ValidatingStreamException, CorruptedImageException, ClassNotFoundException {
        SheetHeader sheetHeader;
        FormattedImage characterImage = null;
            sheetHeader = (SheetHeader) Serializer.receiveObject(peer);
        boolean waitForImage = Serializer.receiveBoolean(peer);
        if(waitForImage)
            characterImage = Serializer.receiveImage(peer);
        return new DnDSheetPreview(sheetHeader,characterImage);
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof DnDSheetPreview))
            return false;
        DnDSheetPreview dnDSheetPreview = (DnDSheetPreview) obj;
        return dnDSheetPreview.sheetHeader.equals(this.sheetHeader) && dnDSheetPreview.characterImage.equals(this.characterImage);
    }
    @Override
    public String toString() {
        return "Header Scheda: "+ sheetHeader +"\n"+
                "Formatted Image: "+characterImage;
    }
}
