package com.italianDudes.dnd_extension.common.sheet.components;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Spell implements Serializable {

    //Attributes
    private String spellName;
    private final ArrayList<SpellComponent> spellComponents;
    private final int spellRegionID;

    //Constructors
    public Spell(String spellName){
        this(spellName,null,0);
    }
    public Spell(String spellName, int spellRegionID){
        this(spellName,null,spellRegionID);
    }
    public Spell(String spellName, ArrayList<SpellComponent> spellComponents){
        this(spellName,spellComponents,0);
    }
    public Spell(String spellName, ArrayList<SpellComponent> spellComponents, int spellRegionID){
        if(spellName==null)
            this.spellName = "";
        else
            this.spellName = spellName;
        if(spellComponents==null)
            this.spellComponents = new ArrayList<>();
        else
            this.spellComponents = spellComponents;
        this.spellRegionID = spellRegionID;
    }

    //Methods
    public SpellComponent getSpellComponent(int index){
        return spellComponents.get(index);
    }
    public boolean addSpellComponent(SpellComponent spellComponent){
        return spellComponents.add(spellComponent);
    }
    public SpellComponent removeSpellComponent(int index){
        return spellComponents.remove(index);
    }
    public boolean removeSpellComponent(SpellComponent spellComponent){
        return spellComponents.remove(spellComponent);
    }
    public int getSpellComponentsNumber(){
        return spellComponents.size();
    }
    public String getSpellName() {
        return spellName;
    }
    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }
    public int getSpellRegionID() {
        return spellRegionID;
    }
    public static void writeSpell(Spell spell, BufferedWriter outFile) throws IOException {

        outFile.write(spell.spellComponents.size()+"\n");

        for (SpellComponent spellComponent : spell.spellComponents) {
            outFile.write(spellComponent.getComponentName() + "\n");
            outFile.write(spellComponent.getAmount() + "\n");
            outFile.write(spellComponent.getDescription() + "\n");
        }
        outFile.flush();

    }
    public static Spell readSpell(int spellRegionID, Scanner inFile){

        String spellName = inFile.nextLine();

        int numComponents = Integer.parseInt(inFile.nextLine());

        ArrayList<SpellComponent> components = new ArrayList<>();

        for(int i=0;i<numComponents;i++){
            components.add(new SpellComponent(inFile.nextLine(),inFile.nextLine(),inFile.nextLine()));
        }

        return new Spell(spellName,components,spellRegionID);

    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Spell))
            return false;
        Spell spell = (Spell) obj;
        return spell.spellComponents.equals(this.spellComponents) &&
                spell.spellName.equals(this.spellName) &&
                spell.spellRegionID == this.spellRegionID;
    }
    @Override
    public String toString() {
        return "Spell Name: "+spellName+"\n"+
                "Spell Level: "+spellRegionID+"\n"+
                "Spell Components: "+ Arrays.toString(spellComponents.toArray());

    }
}
