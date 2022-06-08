package com.italianDudes.dnd_extension.common.sheet.components;

import com.italianDudes.gvedk.common.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Treasure implements Serializable {

    //Attributes
    private final ArrayList<String> treasuresList;

    //Constructors
    public Treasure(ArrayList<String> treasuresList){
        if(treasuresList==null)
            this.treasuresList = new ArrayList<>();
        else
            this.treasuresList = treasuresList;
    }
    public Treasure(){
        this(null);
    }

    //Methods
    public String getTreasure(int index){
        return treasuresList.get(index);
    }
    public boolean addTreasure(String treasure){
        return treasuresList.add(treasure);
    }
    public String removeTreasure(int index){
        return treasuresList.remove(index);
    }
    public boolean removeTreasure(String treasure){
        return treasuresList.remove(treasure);
    }
    public int getTreasuresNumber(){
        return treasuresList.size();
    }
    public static void writeTreasure(Treasure treasure, File destinationTreasureFile) throws IOException {

        BufferedWriter outFile = new BufferedWriter(new FileWriter(destinationTreasureFile));

        outFile.write(treasure.treasuresList.size()+"\n");
        for(int i=0;i<treasure.treasuresList.size();i++){
            outFile.write(treasure.treasuresList.get(i)+"\n");
        }
        outFile.flush();
        outFile.close();

    }
    public static Treasure readTreasure(File treasureFile){

        Scanner inFile;
        try{
            inFile = new Scanner(treasureFile);
        }catch (FileNotFoundException e){
            Logger.log(e);
            return new Treasure();
        }

        ArrayList<String> treasures = new ArrayList<>();

        int numTreasures = Integer.parseInt(inFile.nextLine());
        for(int i=0;i<numTreasures;i++){
            treasures.add(inFile.nextLine());
        }

        inFile.close();

        return new Treasure(treasures);

    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Treasure))
            return false;
        return ((Treasure) obj).treasuresList.equals(this.treasuresList);
    }
    @Override
    public String toString() {
        return "Treasures: "+treasuresList;
    }
}
