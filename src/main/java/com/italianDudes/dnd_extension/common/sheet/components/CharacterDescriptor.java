package com.italianDudes.dnd_extension.common.sheet.components;

import java.util.ArrayList;

public class CharacterDescriptor {

    //Attributes
    private final ArrayList<String> personalityAndTraitsList;
    private final ArrayList<String> idealsList;
    private final ArrayList<String> bondsList;
    private final ArrayList<String> flawsList;

    //Constructors
    public CharacterDescriptor(ArrayList<String> personalityAndTraitsList, ArrayList<String> idealsList, ArrayList<String> bondsList, ArrayList<String> flawsList){
        if(personalityAndTraitsList == null)
            this.personalityAndTraitsList = new ArrayList<>();
        else
            this.personalityAndTraitsList = personalityAndTraitsList;
        if(idealsList == null)
            this.idealsList = new ArrayList<>();
        else
            this.idealsList = idealsList;
        if(bondsList == null)
            this.bondsList = new ArrayList<>();
        else
            this.bondsList = bondsList;
        if(flawsList == null)
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
