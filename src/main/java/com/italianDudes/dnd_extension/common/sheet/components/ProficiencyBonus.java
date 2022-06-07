package com.italianDudes.dnd_extension.common.sheet.components;

public class ProficiencyBonus extends SheetComponent{

    //Attributes
    private int proficiencyBonus;

    //Constructors
    public ProficiencyBonus(int proficiencyBonus){
        this.proficiencyBonus = proficiencyBonus;
    }

    //Methods
    public int getProficiencyBonusValue() {
        return proficiencyBonus;
    }
    public void setProficiencyBonus(int proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ProficiencyBonus))
            return false;
        ProficiencyBonus proficiencyBonus = (ProficiencyBonus) obj;
        return proficiencyBonus.proficiencyBonus==this.proficiencyBonus;
    }
    @Override
    public String toString() {
        return String.valueOf(proficiencyBonus);
    }
}
