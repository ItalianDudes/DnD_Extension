package com.italianDudes.dnd_extension.common.sheet.components;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SuppressWarnings("unused")
public class CharacterBackstory extends SheetComponent{

    //Attributes
    private String backstory;

    //Constructors
    public CharacterBackstory(){
        this.backstory = "";
    }
    public CharacterBackstory(String backstory){
        this.backstory = backstory;
    }
    public CharacterBackstory(File backstoryFilePointer) throws FileNotFoundException {
        Scanner inFile = new Scanner(backstoryFilePointer);
        StringBuilder stringBuilder = new StringBuilder();

        while(inFile.hasNext()){
            stringBuilder.append(inFile.nextLine()).append("\n");
        }
        inFile.close();
        this.backstory = stringBuilder.toString();
    }

    //Methods
    public String getBackstory() {
        return backstory;
    }
    public void setBackstory(String backstory) {
        this.backstory = backstory;
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
