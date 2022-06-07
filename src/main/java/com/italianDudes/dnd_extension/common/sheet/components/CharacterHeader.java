package com.italianDudes.dnd_extension.common.sheet.components;

import com.italianDudes.gvedk.common.FormattedImage;
import com.italianDudes.gvedk.common.StringHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("unused")
public class CharacterHeader extends SheetComponent{

    //Attributes
    private String characterName;
    private String age;
    private String height;
    private String weight;
    private String eyes;
    private String hair;
    private String skin;
    private transient FormattedImage characterImage;

    //Constructors
    public CharacterHeader(String characterName, String age, String height, String weight, String eyes, String hair, String skin, String characterImagePath) throws IOException {
        this(characterName, age, height, weight, eyes, hair, skin, new File(characterImagePath));
    }
    public CharacterHeader(String characterName, String age, String height, String weight, String eyes, String hair, String skin, File characterImagePointer) throws IOException {
        this(characterName, age, height, weight, eyes, hair, skin, new FormattedImage(ImageIO.read(characterImagePointer), StringHandler.getFileExtension(characterImagePointer)));
    }
    public CharacterHeader(String characterName, String age, String height, String weight, String eyes, String hair, String skin, BufferedImage characterImage, String imageExtension){
        this(characterName, age, height, weight, eyes, hair, skin, new FormattedImage(characterImage, imageExtension));
    }
    public CharacterHeader(String characterName, String age, String height, String weight, String eyes, String hair, String skin, FormattedImage characterImage){
        this.characterName = characterName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.eyes = eyes;
        this.hair = hair;
        this.skin = skin;
        this.characterImage = characterImage;
    }

    //Methods
    public String getCharacterName() {
        return characterName;
    }
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getHeight() {
        return height;
    }
    public void setHeight(String height) {
        this.height = height;
    }
    public String getWeight() {
        return weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public String getEyes() {
        return eyes;
    }
    public void setEyes(String eyes) {
        this.eyes = eyes;
    }
    public String getHair() {
        return hair;
    }
    public void setHair(String hair) {
        this.hair = hair;
    }
    public String getSkin() {
        return skin;
    }
    public void setSkin(String skin) {
        this.skin = skin;
    }
    public FormattedImage getCharacterImage() {
        return characterImage;
    }
    public void setCharacterImage(FormattedImage characterImage) {
        this.characterImage = characterImage;
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof CharacterHeader))
            return false;
        CharacterHeader characterHeader = (CharacterHeader) obj;
        return characterHeader.characterImage.equals(this.characterImage) &&
                characterHeader.skin.equals(this.skin) &&
                characterHeader.characterName.equals(this.characterName) &&
                characterHeader.hair.equals(this.hair) &&
                characterHeader.eyes.equals(this.eyes) &&
                characterHeader.height.equals(this.height) &&
                characterHeader.weight.equals(this.weight) &&
                characterHeader.age.equals(this.age);
    }
    @Override
    public String toString() {
        return "Character Name: "+characterName+"\n"+
                "Age: "+age+"\n"+
                "Height: "+height+"\n"+
                "Weight: "+weight+"\n"+
                "Eyes: "+eyes+"\n"+
                "Skin: "+skin+"\n"+
                "Hair: "+hair+"\n"+
                "Image: "+characterImage;
    }
}
