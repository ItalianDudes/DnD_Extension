package com.italianDudes.dnd_extension.common.sheet.components;

import com.italianDudes.gvedk.common.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class AttackAndSpells {

    //Attributes
    private final ArrayList<AttackModel> attackModels;

    //Constructors
    public AttackAndSpells(){
        this(null);
    }
    public AttackAndSpells(ArrayList<AttackModel> attackModels){
        if(attackModels==null)
            this.attackModels = new ArrayList<>();
        else
            this.attackModels = attackModels;
    }

    //Methods
    public AttackModel getAttackModel(int index){
        return attackModels.get(index);
    }
    public boolean addAttackModel(AttackModel attackModel){
        return attackModels.add(attackModel);
    }
    public AttackModel removeAttackModel(int index){
        return attackModels.remove(index);
    }
    public boolean removeAttackModel(AttackModel attackModel){
        return attackModels.remove(attackModel);
    }
    public int getAttackModelNumber(){
        return attackModels.size();
    }
    public static void writeAttackAndSpells(AttackAndSpells  attackAndSpells, File destinationAttackAndSpellsFile) throws IOException {

        BufferedWriter outFile = new BufferedWriter(new FileWriter(destinationAttackAndSpellsFile));

        outFile.write(attackAndSpells.getAttackModelNumber()+"\n");
        outFile.flush();

        for(int i=0;i<attackAndSpells.attackModels.size();i++){
            outFile.write(attackAndSpells.attackModels.get(i).getAttackName()+"\n");
            outFile.write(attackAndSpells.attackModels.get(i).getAtkBonus()+"\n");
            outFile.write(attackAndSpells.attackModels.get(i).getDmgType()+"\n");
            outFile.flush();
        }

        outFile.close();

    }
    public static AttackAndSpells readAttackAndSpells(File attackAndSpellsFile){

        Scanner inFile;

        try {
            inFile = new Scanner(attackAndSpellsFile);
        }catch (FileNotFoundException e){
            Logger.log(e);
            return new AttackAndSpells();
        }

        int attacksNumber = Integer.parseInt(inFile.nextLine());

        if(attacksNumber<=0)
            return new AttackAndSpells();

        ArrayList<AttackModel> attacks = new ArrayList<>();

        AttackModel attackModel;

        int i;
        for(i=0;i<attacksNumber && inFile.hasNextInt();i++){
            attacks.add(new AttackModel(inFile.nextLine(), inFile.nextLine(), inFile.nextLine()));
        }

        inFile.close();

        return new AttackAndSpells(attacks);
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof AttackAndSpells))
            return false;
        AttackAndSpells attackAndSpells = (AttackAndSpells) obj;
        return this.attackModels.equals(attackAndSpells.attackModels);
    }
    @Override
    public String toString() {
        return attackModels.toString();
    }
}
