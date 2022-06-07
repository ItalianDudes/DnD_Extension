package com.italianDudes.dnd_extension.common.sheet.components;

import com.italianDudes.dnd_extension.DnD_Extension;
import com.italianDudes.gvedk.common.Logger;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("unused")
public class AbilityTree {

    //Attributes
    private final Ability[] abilities;

    //Constructors
    public AbilityTree(@NotNull Stats stats){
        this(stats, null);
    }
    public AbilityTree(@NotNull Stats stats, Ability[] abilities){
        if(abilities!=null){
            this.abilities = new Ability[DnD_Extension.Defs.NUM_ABILITIES];
            for(int i=0; i< DnD_Extension.Defs.NUM_ABILITIES;i++){
                try {
                    this.abilities[i] = abilities[i];
                }catch (Exception e){
                    this.abilities[i] = new Ability(i, DnD_Extension.Defs.ABILITIES_ROOT_BY_POS[i],stats.getValueByPosition(DnD_Extension.Defs.ABILITIES_ROOT_BY_POS[i]));
                }
            }
        }else {
            this.abilities = new Ability[DnD_Extension.Defs.NUM_ABILITIES];
            for(int i=0;i< DnD_Extension.Defs.NUM_ABILITIES;i++){
                this.abilities[i] = new Ability(i, DnD_Extension.Defs.ABILITIES_ROOT_BY_POS[i],stats.getValueByPosition(DnD_Extension.Defs.ABILITIES_ROOT_BY_POS[i]));
            }
        }
    }

    //Methods
    public Ability[] getAbilityTree() {
        return abilities;
    }
    public Ability getAbilityByPosition(int pos){
        return abilities[pos];
    }
    public void setAbilityToPosition(int pos, @NotNull Ability ability){
        abilities[pos] = ability;
    }
    public static Ability[] readAbilityTree(File sourceFile){
        Scanner inFile;
        try {
            inFile = new Scanner(sourceFile);
        }catch (FileNotFoundException e){
            Logger.log(e);
            return null;
        }
        Ability[] abilities = new Ability[DnD_Extension.Defs.NUM_ABILITIES];
        int i;
        for(i=0;i< DnD_Extension.Defs.NUM_ABILITIES && inFile.hasNext();i++){
            if(inFile.hasNextInt()) {
                abilities[i] = new Ability(i, DnD_Extension.Defs.ABILITIES_ROOT_BY_POS[i], Integer.parseInt(inFile.nextLine()));
                if (inFile.hasNextBoolean()) {
                    abilities[i].setProficiency(Boolean.parseBoolean(inFile.nextLine()));
                    if (inFile.hasNextBoolean()) {
                        abilities[i].setMastery(Boolean.parseBoolean(inFile.nextLine()));
                    }
                }
            }else{
                inFile.nextLine();
            }
        }
        inFile.close();

        if(i< DnD_Extension.Defs.NUM_ABILITIES){
            Logger.log("Invalid AbilityTree file: invalid content found");
            return null;
        }
        boolean foundNull = false;
        for(i=0;i< DnD_Extension.Defs.NUM_ABILITIES && !foundNull;i++){
            if(abilities[i]==null)
                foundNull=true;
        }
        if(foundNull){
            Logger.log("Invalid AbilityTree file: expected more values");
            return null;
        }

        return abilities;
    }
    public static void writeAbilityTree(File destination, AbilityTree abilityTree) throws IOException {

        BufferedWriter outFile = new BufferedWriter(new FileWriter(destination));

        Ability[] abilities = abilityTree.abilities;

        for (Ability ability : abilities) {
            outFile.write(ability.value+"\n");
            if (ability.hasProficiency) {
                outFile.write(true+"\n");
                if (ability.hasMastery)
                    outFile.write(true+"\n");
            }
            outFile.flush();
        }

        outFile.close();
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof AbilityTree))
            return false;
        AbilityTree abilityTree = (AbilityTree) obj;
        return Arrays.equals(abilities,abilityTree.abilities);
    }
    @Override
    public String toString() {
        return Arrays.toString(abilities);
    }
}
