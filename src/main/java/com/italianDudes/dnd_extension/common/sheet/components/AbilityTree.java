package com.italianDudes.dnd_extension.common.sheet.components;

import com.italianDudes.dnd_extension.DnD_Extension;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

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
