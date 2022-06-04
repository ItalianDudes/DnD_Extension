package com.italianDudes.dnd_extension.common.sheet.components;

import com.italianDudes.dnd_extension.DnD_Extension;

import java.util.Arrays;

public class SavingThrows {

    //Attributes
    private final Stats stats;
    private final boolean[] competenceGrid;

    //Constructors
    public SavingThrows(Stats stats){
        this(stats,null);
    }
    public SavingThrows(Stats stats, boolean[] competenceGrid){
        this.stats = stats;
        if(competenceGrid!=null) {
            this.competenceGrid = new boolean[DnD_Extension.Defs.NUM_STATS];
            for (int i = 0; i < DnD_Extension.Defs.NUM_STATS; i++) {
                try {
                    this.competenceGrid[i] = competenceGrid[i];
                } catch (Exception e) {
                    this.competenceGrid[i] = false;
                }
            }
        }else {
            this.competenceGrid = new boolean[DnD_Extension.Defs.NUM_STATS];
            for(int i = 0; i < DnD_Extension.Defs.NUM_STATS; i++){
                this.competenceGrid[i] = false;
            }
        }
    }

    //Methods
    public int getStrengthSavingThrow(){
        return competenceGrid[DnD_Extension.Defs.STRENGTH_POS]? stats.getStrengthMod()+ stats.getProficiencyBonus().getProficiencyBonusValue(): stats.getStrengthMod();
    }
    public int getDexteritySavingThrow(){
        return competenceGrid[DnD_Extension.Defs.DEXTERITY_POS]? stats.getDexterityMod()+ stats.getProficiencyBonus().getProficiencyBonusValue(): stats.getDexterityMod();
    }
    public int getConstitutionSavingThrow(){
        return competenceGrid[DnD_Extension.Defs.CONSTITUTION_POS]? stats.getConstitutionMod()+ stats.getProficiencyBonus().getProficiencyBonusValue(): stats.getConstitutionMod();
    }
    public int getIntelligenceSavingThrow(){
        return competenceGrid[DnD_Extension.Defs.INTELLIGENCE_POS]? stats.getIntelligenceMod()+ stats.getProficiencyBonus().getProficiencyBonusValue(): stats.getIntelligenceMod();
    }
    public int getWisdomSavingThrow(){
        return competenceGrid[DnD_Extension.Defs.WISDOM_POS]? stats.getWisdomMod()+ stats.getProficiencyBonus().getProficiencyBonusValue(): stats.getWisdomMod();
    }
    public int getCharismaSavingThrow(){
        return competenceGrid[DnD_Extension.Defs.CHARISMA_POS]? stats.getCharismaMod()+ stats.getProficiencyBonus().getProficiencyBonusValue(): stats.getCharismaMod();
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof SavingThrows))
            return false;
        SavingThrows savingThrows = (SavingThrows) obj;
        return Arrays.equals(savingThrows.competenceGrid, this.competenceGrid);
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i< DnD_Extension.Defs.NUM_STATS;i++){
            stringBuilder.append("[").append(i).append("]: ").append(competenceGrid[i]);
            if(i+1 < DnD_Extension.Defs.NUM_STATS)
                stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
