package com.italianDudes.dnd_extension.common.sheet.components;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class AttackAndSpells extends SheetComponent {

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
