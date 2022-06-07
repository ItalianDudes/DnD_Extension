package com.italianDudes.dnd_extension.common.sheet.components;

import com.italianDudes.gvedk.common.FormattedImage;
import com.italianDudes.gvedk.common.StringHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("unused")
public class CharacterSymbol {

    //Attributes
    private String symbolName;
    private FormattedImage symbolImage;

    //Constructors
    public CharacterSymbol(String symbolName, String symbolImagePath) throws IOException {
        this(symbolName, new File(symbolImagePath));
    }
    public CharacterSymbol(String symbolName, File symbolImagePointer) throws IOException {
        this(symbolName, new FormattedImage(ImageIO.read(symbolImagePointer), StringHandler.getFileExtension(symbolImagePointer)));
    }
    public CharacterSymbol(String symbolName, BufferedImage symbolImage, String symbolImageExtension){
        this(symbolName, new FormattedImage(symbolImage, symbolImageExtension));
    }
    public CharacterSymbol(){
        this.symbolName = "";
        this.symbolImage = null;
    }
    public CharacterSymbol(String symbolName, FormattedImage symbolImage){
        this.symbolImage = symbolImage;
        if(symbolName==null)
            this.symbolName = "";
        else
            this.symbolName = symbolName;
    }

    //Methods
    public String getSymbolName() {
        return symbolName;
    }
    public void setSymbolName(String symbolName) {
        this.symbolName = symbolName;
    }
    public FormattedImage getSymbolImage() {
        return symbolImage;
    }
    public void setSymbolImage(FormattedImage symbolImage) {
        this.symbolImage = symbolImage;
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof CharacterSymbol))
            return false;
        CharacterSymbol characterSymbol = (CharacterSymbol) obj;
        return characterSymbol.symbolName.equals(this.symbolName) && characterSymbol.symbolImage.equals(this.symbolImage);
    }
    @Override
    public String toString() {
        return "Symbol Name: "+symbolName+"\n"+
                "Symbol Image: "+symbolImage;
    }
}
