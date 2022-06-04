package com.italianDudes.dnd_extension.common.sheet.components;

public class Stats {

    //Attributes
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private ProficiencyBonus proficiencyBonus;
    private int passiveWisdom;

    //Constructors
    public Stats(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, ProficiencyBonus proficiencyBonus){
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.proficiencyBonus = proficiencyBonus;
        this.passiveWisdom = 10+getDexterityMod();
    }

    //Stats Access Methods
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getDexterity() {
        return dexterity;
    }
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
        updatePassiveWisdom();
    }
    public int getConstitution() {
        return constitution;
    }
    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }
    public int getIntelligence() {
        return intelligence;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    public int getWisdom() {
        return wisdom;
    }
    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }
    public int getCharisma() {
        return charisma;
    }
    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
    public ProficiencyBonus getProficiencyBonus(){
        return proficiencyBonus;
    }
    public void setProficiencyBonus(ProficiencyBonus proficiencyBonus){
        this.proficiencyBonus = proficiencyBonus;
    }
    public void setProficiencyBonus(int proficiencyBonus){
        this.proficiencyBonus.setProficiencyBonus(proficiencyBonus);
    }
    public int getPassiveWisdom(){
        return passiveWisdom;
    }
    private void updatePassiveWisdom(){
        this.passiveWisdom = 10+getDexterityMod();
    }

    //Stats Modifier Access Methods
    public int getStrengthMod(){
        return Math.floorDiv((strength-10),2);
    }
    public int getDexterityMod(){
        return Math.floorDiv((dexterity-10),2);
    }
    public int getConstitutionMod(){
        return Math.floorDiv((constitution-10),2);
    }
    public int getIntelligenceMod(){
        return Math.floorDiv((intelligence-10),2);
    }
    public int getWisdomMod(){
        return Math.floorDiv((wisdom-10),2);
    }
    public int getCharismaMod(){
        return Math.floorDiv((charisma-10),2);
    }

    //Miscellaneous Methods
    public int getValueByPosition(Integer position){
        switch (position){
            case 0:
                return strength;
            case 1:
                return dexterity;
            case 2:
                return constitution;
            case 3:
                return intelligence;
            case 4:
                return wisdom;
            case 5:
                return charisma;
            default:
                throw new RuntimeException("Can't get stats value by position: invalid position");
        }
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Stats))
            return false;
        Stats stats = (Stats) obj;
        return stats.strength==this.strength &&
                stats.dexterity == this.dexterity &&
                stats.constitution == this.constitution &&
                stats.intelligence == this.intelligence &&
                stats.wisdom == this.wisdom &&
                stats.charisma == this.charisma &&
                stats.proficiencyBonus.equals(this.proficiencyBonus);
    }
    @Override
    public String toString() {
        return "Strength: "+strength+"\n"+
                "Dexterity: "+dexterity+"\n"+
                "Constitution: "+constitution+"\n"+
                "Intelligence: "+intelligence+"\n"+
                "Wisdom: "+wisdom+"\n"+
                "Charisma: "+charisma+"\n"+
                "Proficiency Bonus: "+proficiencyBonus+"\n"+
                "Passive Wisdom: "+passiveWisdom;
    }
}
