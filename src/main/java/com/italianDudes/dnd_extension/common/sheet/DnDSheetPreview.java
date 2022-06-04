package com.italianDudes.dnd_extension.common.sheet;

import com.italianDudes.dnd_extension.common.sheet.components.HeaderScheda;
import com.italianDudes.gvedk.common.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DnDSheetPreview {

    //Attributes
    private final HeaderScheda headerScheda;
    private transient final FormattedImage characterImage;

    //Constructors
    public DnDSheetPreview(HeaderScheda headerScheda, File characterImage) {
        this.headerScheda = headerScheda;
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
    public DnDSheetPreview(HeaderScheda headerScheda, String characterImagePath){
        this(headerScheda,new File(characterImagePath));
    }
    public DnDSheetPreview(HeaderScheda headerScheda, FormattedImage characterImage){
        this.headerScheda = headerScheda;
        this.characterImage = characterImage;
    }

    //Methods
    public HeaderScheda getHeaderScheda(){
        return headerScheda;
    }
    public FormattedImage getCharacterImage(){
        return characterImage;
    }
    public void sendPreview(Peer peer) {
        try {
            Serializer.sendObject(peer, headerScheda);
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
        HeaderScheda headerScheda;
        FormattedImage characterImage;
        try{
            headerScheda = (HeaderScheda) Serializer.receiveObject(peer);
        }catch (Exception e) {
            Logger.log(e);
            headerScheda = null;
        }
        try{
            characterImage = Serializer.receiveImage(peer);
        }catch (Exception e) {
            Logger.log(e);
            characterImage = null;
        }
        return new DnDSheetPreview(headerScheda,characterImage);
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof DnDSheetPreview))
            return false;
        DnDSheetPreview dnDSheetPreview = (DnDSheetPreview) obj;
        return dnDSheetPreview.headerScheda.equals(this.headerScheda) && dnDSheetPreview.characterImage.equals(this.characterImage);
    }
    @Override
    public String toString() {
        return "Header Scheda: "+headerScheda+"\n"+
                "Formatted Image: "+characterImage;
    }
}
