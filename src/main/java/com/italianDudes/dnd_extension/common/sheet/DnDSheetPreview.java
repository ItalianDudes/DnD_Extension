package com.italianDudes.dnd_extension.common.sheet;

import com.italianDudes.dnd_extension.common.sheet.components.SheetHeader;
import com.italianDudes.gvedk.common.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("unused")
public class DnDSheetPreview {

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
    public void sendPreview(Peer peer) {
        try {
            Serializer.sendObject(peer, sheetHeader);
        }catch (Exception e){
            Logger.log(e);
        }
        try {
            Serializer.sendImage(peer,characterImage);
        }catch (Exception e){
            Logger.log(e);
        }
    }
    public static DnDSheetPreview receivePreview(Peer peer){
        SheetHeader sheetHeader;
        FormattedImage characterImage;
        try{
            sheetHeader = (SheetHeader) Serializer.receiveObject(peer);
        }catch (Exception e) {
            Logger.log(e);
            sheetHeader = null;
        }
        try{
            characterImage = Serializer.receiveImage(peer);
        }catch (Exception e) {
            Logger.log(e);
            characterImage = null;
        }
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
