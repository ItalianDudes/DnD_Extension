package com.italianDudes.dnd_extension.common.sheet.components;

import com.italianDudes.gvedk.common.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class CharacterDescriptor {

    //Attributes
    private final ArrayList<String> personalityAndTraitsList;
    private final ArrayList<String> idealsList;
    private final ArrayList<String> bondsList;
    private final ArrayList<String> flawsList;

    //Constructors
    public CharacterDescriptor(ArrayList<String> personalityAndTraitsList, ArrayList<String> idealsList, ArrayList<String> bondsList, ArrayList<String> flawsList){
        if(personalityAndTraitsList==null)
            this.personalityAndTraitsList = new ArrayList<>();
        else
            this.personalityAndTraitsList = personalityAndTraitsList;
        if(idealsList==null)
            this.idealsList = new ArrayList<>();
        else
            this.idealsList = idealsList;
        if(bondsList==null)
            this.bondsList = new ArrayList<>();
        else
            this.bondsList = bondsList;
        if(flawsList==null)
            this.flawsList = new ArrayList<>();
        else
            this.flawsList = flawsList;
    }
    public CharacterDescriptor(){
        this(null,null,null,null);
    }

    //Methods
    public String getPersonalityAndTrait(int index){
        return personalityAndTraitsList.get(index);
    }
    public boolean addPersonalityAndTrait(String personalityAndTrait){
        return personalityAndTraitsList.add(personalityAndTrait);
    }
    public String removePersonalityAndTrait(int index){
        return personalityAndTraitsList.remove(index);
    }
    public boolean removePersonalityAndTrait(String personalityAndTrait){
        return personalityAndTraitsList.remove(personalityAndTrait);
    }
    public int getPersonalityAndTraitsNumber(){
        return personalityAndTraitsList.size();
    }
    public String getIdeal(int index){
        return idealsList.get(index);
    }
    public boolean addIdeal(String ideal){
        return idealsList.add(ideal);
    }
    public String removeIdeal(int index){
        return idealsList.remove(index);
    }
    public boolean removeIdeal(String ideal){
        return idealsList.remove(ideal);
    }
    public int getIdealsNumber(){
        return idealsList.size();
    }
    public String getBond(int index){
        return bondsList.get(index);
    }
    public boolean addBond(String bond){
        return bondsList.add(bond);
    }
    public String removeBond(int index){
        return bondsList.remove(index);
    }
    public boolean removeBond(String bond){
        return bondsList.remove(bond);
    }
    public int getBondsNumber(){
        return bondsList.size();
    }
    public String getFlaw(int index){
        return flawsList.get(index);
    }
    public boolean addFlaw(String flaw){
        return flawsList.add(flaw);
    }
    public String removeFlaw(int index){
        return flawsList.remove(index);
    }
    public boolean removeFlaw(String flaw){
        return flawsList.remove(flaw);
    }
    public int getFlawsNumber(){
        return flawsList.size();
    }
    public static void writeCharacterDescriptor(CharacterDescriptor characterDescriptor, File destinationCharacterDescriptorFile) throws IOException {

        BufferedWriter outFile = new BufferedWriter(new FileWriter(destinationCharacterDescriptorFile));

        outFile.write(characterDescriptor.personalityAndTraitsList.size()+"\n");

        for(int i=0;i<characterDescriptor.personalityAndTraitsList.size();i++){
            outFile.write(characterDescriptor.personalityAndTraitsList.get(i)+"\n");
        }
        outFile.flush();

        outFile.write(characterDescriptor.idealsList.size()+"\n");

        for(int i=0;i<characterDescriptor.idealsList.size();i++){
            outFile.write(characterDescriptor.idealsList.get(i)+"\n");
        }
        outFile.flush();

        outFile.write(characterDescriptor.bondsList.size()+"\n");

        for(int i=0;i<characterDescriptor.bondsList.size();i++){
            outFile.write(characterDescriptor.bondsList.get(i)+"\n");
        }
        outFile.flush();

        outFile.write(characterDescriptor.flawsList.size()+"\n");

        for(int i=0;i<characterDescriptor.flawsList.size();i++){
            outFile.write(characterDescriptor.flawsList.get(i)+"\n");
        }
        outFile.flush();

        outFile.close();

    }
    public static CharacterDescriptor readCharacterDescriptor(File characterDescriptorFile){

        Scanner inFile;

        try{
            inFile = new Scanner(characterDescriptorFile);
        }catch (FileNotFoundException e){
            Logger.log(e);
            return new CharacterDescriptor();
        }

        ArrayList<String> personalityAndTraits = new ArrayList<>();
        ArrayList<String> ideals = new ArrayList<>();
        ArrayList<String> bonds = new ArrayList<>();
        ArrayList<String> flaws = new ArrayList<>();

        int numPersonalityAndTraits = Integer.parseInt(inFile.nextLine());

        for(int i=0;i<numPersonalityAndTraits;i++){
            personalityAndTraits.add(inFile.nextLine());
        }

        int numIdeals = Integer.parseInt(inFile.nextLine());

        for(int i=0;i<numIdeals;i++){
            ideals.add(inFile.nextLine());
        }

        int numBonds = Integer.parseInt(inFile.nextLine());

        for(int i=0;i<numBonds;i++){
            bonds.add(inFile.nextLine());
        }

        int numFlaws = Integer.parseInt(inFile.nextLine());

        for(int i=0;i<numFlaws;i++){
            flaws.add(inFile.nextLine());
        }

        inFile.close();

        return new CharacterDescriptor(personalityAndTraits, ideals, bonds, flaws);

    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof CharacterDescriptor))
            return false;
        CharacterDescriptor characterDescriptor = (CharacterDescriptor) obj;
        return characterDescriptor.personalityAndTraitsList.equals(this.personalityAndTraitsList) &&
                characterDescriptor.idealsList.equals(this.idealsList) &&
                characterDescriptor.bondsList.equals(this.bondsList) &&
                characterDescriptor.flawsList.equals(this.flawsList);
    }
    @Override
    public String toString() {
        return "Personality and Traits: "+ personalityAndTraitsList +"\n"+
                "Ideals: "+ idealsList +"\n"+
                "Bonds: "+ bondsList +"\n"+
                "Flaws: "+ flawsList;
    }
}
