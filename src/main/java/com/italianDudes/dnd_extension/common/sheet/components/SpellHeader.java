package com.italianDudes.dnd_extension.common.sheet.components;

import com.italianDudes.gvedk.common.Logger;

import java.io.*;
import java.util.Scanner;

@SuppressWarnings("unused")
public class SpellHeader implements Serializable {

    //Attributes
    private String spellCastingClass;
    private String spellCastingAbility;
    private String spellSaveDC;
    private String spellAttackBonus;

    //Constructors
    public SpellHeader(String spellCastingClass, String spellCastingAbility, String spellSaveDC, String spellAttackBonus) {
        if (spellCastingClass == null)
            this.spellCastingClass = "";
        else
            this.spellCastingClass = spellCastingClass;
        if (spellCastingAbility == null)
            this.spellCastingAbility = "";
        else
            this.spellCastingAbility = spellCastingAbility;
        if (spellSaveDC == null)
            this.spellSaveDC = "";
        else
            this.spellSaveDC = spellSaveDC;
        if (spellAttackBonus == null)
            this.spellAttackBonus = "";
        else
            this.spellAttackBonus = spellAttackBonus;
    }

    public SpellHeader() {
        this(null, null, null, null);
    }

    //Methods
    public String getSpellCastingClass() {
        return spellCastingClass;
    }

    public void setSpellCastingClass(String spellCastingClass) {
        this.spellCastingClass = spellCastingClass;
    }

    public String getSpellCastingAbility() {
        return spellCastingAbility;
    }

    public void setSpellCastingAbility(String spellCastingAbility) {
        this.spellCastingAbility = spellCastingAbility;
    }

    public String getSpellSaveDC() {
        return spellSaveDC;
    }

    public void setSpellSaveDC(String spellSaveDC) {
        this.spellSaveDC = spellSaveDC;
    }

    public String getSpellAttackBonus() {
        return spellAttackBonus;
    }

    public void setSpellAttackBonus(String spellAttackBonus) {
        this.spellAttackBonus = spellAttackBonus;
    }
    public static void writeSpellHeader(SpellHeader spellHeader, String destinationSpellHeaderPath) throws IOException {
        writeSpellHeader(spellHeader, new File(destinationSpellHeaderPath));
    }
    public static void writeSpellHeader(SpellHeader spellHeader, File destinationSpellHeaderFile) throws IOException {

        BufferedWriter outFile = new BufferedWriter(new FileWriter(destinationSpellHeaderFile));

        outFile.write(spellHeader.spellCastingClass+"\n");
        outFile.write(spellHeader.spellCastingAbility+"\n");
        outFile.write(spellHeader.spellSaveDC+"\n");
        outFile.write(spellHeader.spellAttackBonus+"\n");

        outFile.flush();
        outFile.close();

    }
    public static SpellHeader readSpellHeader(String spellHeaderPath){
        return readSpellHeader(new File(spellHeaderPath));
    }
    public static SpellHeader readSpellHeader(File spellHeaderFile){

        Scanner inFile;
        try{
            inFile = new Scanner(spellHeaderFile);
        }catch (FileNotFoundException e){
            Logger.log(e);
            return new SpellHeader();
        }

        String spellCastingClass = inFile.nextLine();
        String spellCastingAbility = inFile.nextLine();
        String spellSaveDC = inFile.nextLine();
        String spellAttackBonus = inFile.nextLine();

        inFile.close();
        return new SpellHeader(spellCastingClass,spellCastingAbility,spellSaveDC,spellAttackBonus);

    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof SpellHeader))
            return false;
        SpellHeader spellHeader = (SpellHeader) obj;
        return spellHeader.spellCastingClass.equals(this.spellCastingClass) &&
                spellHeader.spellCastingAbility.equals(this.spellCastingAbility) &&
                spellHeader.spellAttackBonus.equals(this.spellAttackBonus) &&
                spellHeader.spellSaveDC.equals(this.spellSaveDC);
    }
    @Override
    public String toString() {
        return "Spell Casting Class: "+spellCastingClass+"\n"+
                "Spell Casting Ability: "+spellCastingAbility+"\n"+
                "Spell Attack Bonus: "+spellAttackBonus+"\n"+
                "Spell Save DC: "+spellSaveDC;
    }
}
