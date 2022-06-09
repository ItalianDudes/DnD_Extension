package com.italianDudes.dnd_extension.common.sheet.components;

import com.italianDudes.gvedk.common.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class SpellRegion implements Serializable {

    //Attributes
    private final int spellRegionID;
    private String numSpells;
    private String actualSpells;
    private SpellList spellList;

    //Constructors
    public SpellRegion(int spellRegionID){
        this(spellRegionID,null,null,null);
    }
    public SpellRegion(int spellRegionID, String numSpells){
        this(spellRegionID,numSpells,numSpells,null);
    }
    public SpellRegion(int spellRegionID, String numSpells, SpellList spellList){
        this(spellRegionID,numSpells,numSpells,spellList);
    }
    public SpellRegion(int spellRegionID, SpellList spellList){
        this(spellRegionID,null,null,spellList);
    }
    public SpellRegion(int spellRegionID, String numSpells, String actualSpells, SpellList spellList){
        this.spellRegionID = spellRegionID;
        if(numSpells==null)
            this.numSpells = "";
        else
            this.numSpells = numSpells;
        if(actualSpells==null)
            this.actualSpells = "";
        else
            this.actualSpells = actualSpells;
        if(spellList==null)
            this.spellList = new SpellList(spellRegionID);
        else
            this.spellList = spellList;
    }

    //Methods
    public int getSpellRegionID() {
        return spellRegionID;
    }
    public String getNumSpells() {
        return numSpells;
    }
    public void setNumSpells(String numSpells) {
        this.numSpells = numSpells;
    }
    public String getActualSpells() {
        return actualSpells;
    }
    public void setActualSpells(String actualSpells) {
        this.actualSpells = actualSpells;
    }
    public SpellList getSpellList() {
        return spellList;
    }
    public void setSpellList(SpellList spellList) {
        this.spellList = spellList;
    }
    public static void writeSpellRegion(SpellRegion spellRegion, String destinationSpellRegionPath) throws IOException {
        writeSpellRegion(spellRegion,new File(destinationSpellRegionPath));
    }
    public static void writeSpellRegion(SpellRegion spellRegion, File destinationSpellRegionFile) throws IOException {

        BufferedWriter outFile = new BufferedWriter(new FileWriter(destinationSpellRegionFile));

        outFile.write(spellRegion.numSpells+"\n");
        outFile.write(spellRegion.actualSpells+"\n");

        outFile.write(spellRegion.spellList.getSpellsNumber()+"\n");

        for(int i=0;i<spellRegion.spellList.getSpellsNumber();i++){
            Spell.writeSpell(spellRegion.spellList.getSpell(i),outFile);
        }

        outFile.flush();
        outFile.close();

    }
    public static SpellRegion readSpellRegion(int spellRegionID, String spellRegionPath){
        return readSpellRegion(spellRegionID,new File(spellRegionPath));
    }
    public static SpellRegion readSpellRegion(int spellRegionID, File spellRegionFile){

        Scanner inFile;
        try{
            inFile = new Scanner(spellRegionFile);
        }catch (FileNotFoundException e){
            Logger.log(e);
            return new SpellRegion(spellRegionID);
        }

        String numSpellsAvailable = inFile.nextLine();
        String actualSpellsAvailable = inFile.nextLine();

        int numSpells = Integer.parseInt(inFile.nextLine());

        ArrayList<Spell> spellsList = new ArrayList<>();

        for(int i=0;i<numSpells;i++){
            spellsList.add(Spell.readSpell(spellRegionID,inFile));
        }

        SpellList spellsListBlock = new SpellList(spellRegionID,spellsList);


        inFile.close();
        return new SpellRegion(spellRegionID,numSpellsAvailable,actualSpellsAvailable,spellsListBlock);

    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof SpellRegion))
            return false;
        SpellRegion spellRegion = (SpellRegion) obj;
        return spellRegion.spellList.equals(this.spellList) &&
                spellRegion.numSpells.equals(this.numSpells) &&
                spellRegion.actualSpells.equals(this.actualSpells) &&
                spellRegion.spellRegionID == this.spellRegionID;
    }
    @Override
    public String toString() {
        return "Spell Region ID: "+spellRegionID+"\n"+
                "Actual Spells/Max Spells"+actualSpells+"/"+numSpells+"\n"+
                "Spell List:\n"+spellList;
    }
}
