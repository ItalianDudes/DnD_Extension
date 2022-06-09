package com.italianDudes.dnd_extension.common.sheet.components;

import com.italianDudes.gvedk.common.Logger;

import java.io.*;
import java.util.Scanner;

@SuppressWarnings("unused")
public class CharacterBackstory implements Serializable {

    //Attributes
    private String backstory;

    //Constructors
    public CharacterBackstory(){
        this.backstory = "";
    }
    public CharacterBackstory(String backstory){
        this.backstory = backstory;
    }
    public CharacterBackstory(File backstoryFilePointer) {
        Scanner inFile = null;
        boolean fileNotFound = false;
        try {
            inFile = new Scanner(backstoryFilePointer);
        }catch (FileNotFoundException e){
            Logger.log(e);
            this.backstory = "";
            fileNotFound = true;
        }

        if(!fileNotFound) {
            StringBuilder stringBuilder = new StringBuilder();

            while (inFile.hasNext()) {
                stringBuilder.append(inFile.nextLine()).append("\n");
            }
            inFile.close();
            this.backstory = stringBuilder.toString();
        }
    }

    //Methods
    public String getBackstory() {
        return backstory;
    }
    public void setBackstory(String backstory) {
        this.backstory = backstory;
    }
    public static void writeCharacterBackstory(CharacterBackstory characterBackstory, File destinationCharacterBackstoryFile) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destinationCharacterBackstoryFile));

        bufferedWriter.write(characterBackstory.backstory);

        bufferedWriter.flush();
        bufferedWriter.close();

    }
    public static CharacterBackstory readCharacterBackstory(String characterBackstoryPath) {
        return readCharacterBackstory(new File(characterBackstoryPath));
    }
    public static CharacterBackstory readCharacterBackstory(File characterBackstoryFile){

        Scanner inFile;
        try {
            inFile = new Scanner(characterBackstoryFile);
        }catch (FileNotFoundException e){
            Logger.log(e);
            return new CharacterBackstory();
        }
        StringBuilder stringBuilder = new StringBuilder();

        while(inFile.hasNext()){
            stringBuilder.append(inFile.nextLine()).append("\n");
        }
        inFile.close();
        return new CharacterBackstory(stringBuilder.toString());
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof CharacterBackstory))
            return false;
        return ((CharacterBackstory) obj).backstory.equals(this.backstory);
    }
    @Override
    public String toString() {
        return backstory;
    }
}
