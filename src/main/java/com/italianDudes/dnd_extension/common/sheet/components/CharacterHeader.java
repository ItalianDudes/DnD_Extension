package com.italianDudes.dnd_extension.common.sheet.components;

import com.italianDudes.gvedk.common.FormattedImage;
import com.italianDudes.gvedk.common.ImageHandler;
import com.italianDudes.gvedk.common.Logger;
import com.italianDudes.gvedk.common.StringHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

@SuppressWarnings("unused")
public class CharacterHeader {

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
        if(characterName==null)
            this.characterName = "";
        else
            this.characterName = characterName;
        if(age==null)
            this.age = "";
        else
            this.age = age;
        if(height==null)
            this.height = "";
        else
            this.height = height;
        if(weight==null)
            this.weight = "";
        else
            this.weight = weight;
        if(eyes==null)
            this.eyes = "";
        else
            this.eyes = eyes;
        if(hair==null)
            this.hair = "";
        else
            this.hair = hair;
        if(skin==null)
            this.skin = "";
        else
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
    public static void writeCharacterHeader(CharacterHeader characterHeader, File destinationCharacterHeaderFile, File destinationCharacterImageFile) throws IOException {

        BufferedWriter outFile = new BufferedWriter(new FileWriter(destinationCharacterHeaderFile));

        outFile.write(characterHeader.characterName+"\n");
        outFile.write(characterHeader.height+"\n");
        outFile.write(characterHeader.weight+"\n");
        outFile.write(characterHeader.eyes+"\n");
        outFile.write(characterHeader.hair+"\n");
        outFile.write(characterHeader.skin+"\n");

        outFile.flush();
        outFile.close();

        ImageHandler.writeImage(destinationCharacterImageFile,characterHeader.characterImage.getImage());

    }
    public static CharacterHeader readCharacterHeader(File characterHeaderFile, File characterImageFile) {

        String characterName = null;
        String age = null;
        String height = null;
        String weight = null;
        String eyes = null;
        String hair = null;
        String skin = null;

        Scanner inFile;
        try{
            inFile = new Scanner(characterHeaderFile);
            characterName = inFile.nextLine();
            age = inFile.nextLine();
            height = inFile.nextLine();
            weight = inFile.nextLine();
            eyes = inFile.nextLine();
            hair = inFile.nextLine();
            skin = inFile.nextLine();
            inFile.close();

        }catch (FileNotFoundException e){
            Logger.log(e);
        }

        FormattedImage characterImage = null;

        try {
            characterImage = new FormattedImage(ImageIO.read(characterImageFile), StringHandler.getFileExtension(characterImageFile));
        }catch (IOException e){
            Logger.log(e);
        }

        return new CharacterHeader(characterName, age, height, weight, eyes, hair, skin,characterImage);

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
