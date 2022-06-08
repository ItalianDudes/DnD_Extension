package com.italianDudes.dnd_extension.common.sheet.components;

import java.io.Serializable;

@SuppressWarnings("unused")
public class AttackModel implements Serializable {

    //Attributes
    private String attackName;
    private String atkBonus;
    private String dmgType;

    //Constructors
    public AttackModel(String attackName, String atkBonus, String dmgType){
        this.attackName = attackName;
        this.atkBonus = atkBonus;
        this.dmgType = dmgType;
    }

    //Methods
    public String getAttackName() {
        return attackName;
    }
    public void setAttackName(String attackName) {
        this.attackName = attackName;
    }
    public String getAtkBonus() {
        return atkBonus;
    }
    public void setAtkBonus(String atkBonus) {
        this.atkBonus = atkBonus;
    }
    public String getDmgType() {
        return dmgType;
    }
    public void setDmgType(String dmgType) {
        this.dmgType = dmgType;
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof AttackModel))
            return false;
        AttackModel attackModel = (AttackModel) obj;
        return attackModel.attackName.equals(this.attackName) && attackModel.dmgType.equals(this.dmgType) && attackModel.atkBonus.equals(this.atkBonus);
    }
    @Override
    public String toString() {
        return "Attack Name: "+ attackName +"\n"+"Attack Bonus: "+atkBonus+"\n"+"Damage Type: "+dmgType;
    }
}
