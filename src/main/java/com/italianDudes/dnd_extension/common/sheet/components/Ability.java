package com.italianDudes.dnd_extension.common.sheet.components;

@SuppressWarnings("unused")
public class Ability {

    //Attributes
    public final Integer abilityPositionConstant;
    public final Integer rootStatPositionConstant;
    public int value;
    public boolean hasProficiency;
    public boolean hasMastery;

    //Constructors
    public Ability(Integer abilityPositionConstant, Integer rootStatPositionConstant, int value, boolean hasProficiency, boolean hasMastery){
        this.abilityPositionConstant = abilityPositionConstant;
        this.rootStatPositionConstant = rootStatPositionConstant;
        this.value = value;
        this.hasProficiency = hasProficiency;
        this.hasMastery = hasMastery;
    }
    public Ability(Integer abilityPositionConstant, Integer rootStatPositionConstant, int value){
        this(abilityPositionConstant,rootStatPositionConstant,value,false,false);
    }

    //Methods
    public Integer getAbilityPositionConstant() {
        return abilityPositionConstant;
    }
    public Integer getRootStatPositionConstant(){
        return rootStatPositionConstant;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public boolean hasProficiency() {
        return hasProficiency;
    }
    public void setProficiency(boolean hasProficiency) {
        this.hasProficiency = hasProficiency;
    }
    public boolean hasMastery() {
        return hasMastery;
    }
    public void setMastery(boolean hasMastery) {
        this.hasMastery = hasMastery;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Ability))
            return false;
        Ability ability = (Ability) obj;
        return ability.abilityPositionConstant.equals(this.abilityPositionConstant) && ability.rootStatPositionConstant.equals(this.rootStatPositionConstant) && ability.value==this.value;
    }
    @Override
    public String toString() {
        return "["+abilityPositionConstant+"] "+" - "+value+" ("+rootStatPositionConstant+")";
    }
}
