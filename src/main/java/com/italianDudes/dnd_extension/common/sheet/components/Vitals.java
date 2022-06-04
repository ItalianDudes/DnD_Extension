package com.italianDudes.dnd_extension.common.sheet.components;

import com.italianDudes.dnd_extension.DnD_Extension;
import com.italianDudes.dnd_extension.common.sheet.DnD_Sheet;

import java.util.Arrays;

public class Vitals {

    //Attributes
    private int AC;
    private int initiative;
    private String speed;
    private String maxHP;
    private String actualHP;
    private String tempHP;
    private Dice maxLifeDice;
    private Dice actualLifeDice;
    private boolean[] successfulTSAgainstDeath;
    private boolean[] failedTSAgainstDeath;

    //Constructors
    public Vitals(Stats stats, String speed, String maxHP, String actualHP, Dice maxLifeDice, Dice actualLifeDice){
        this(10+stats.getDexterityMod(), stats.getDexterityMod(),speed,maxHP,actualHP,null,maxLifeDice,actualLifeDice,initFalseArray(),initFalseArray());
    }
    public Vitals(Stats stats, String speed, String maxHP, String actualHP, String tempHP, Dice maxLifeDice, Dice actualLifeDice){
        this(10+stats.getDexterityMod(), stats.getDexterityMod(),speed,maxHP,actualHP,tempHP,maxLifeDice,actualLifeDice, initFalseArray(),initFalseArray());
    }
    public Vitals(int AC, int initiative, String speed, String maxHP, String actualHP, String tempHP, Dice maxLifeDice, Dice actualLifeDice, boolean[] successfulTSAgainstDeath, boolean[] failedTSAgainstDeath){
        this.AC = AC;
        this.initiative = initiative;
        this.speed = speed;
        this.maxHP = maxHP;
        this.actualHP = actualHP;
        this.tempHP = tempHP;
        this.maxLifeDice = maxLifeDice;
        this.actualLifeDice = actualLifeDice;
        this.successfulTSAgainstDeath = successfulTSAgainstDeath;
        this.failedTSAgainstDeath = failedTSAgainstDeath;
    }

    //Methods
    private static boolean[] initFalseArray(){
        return new boolean[DnD_Extension.Defs.NUM_TS_AGAINST_DEATH];
    }
    public int getAC() {
        return AC;
    }
    public void setAC(int AC) {
        this.AC = AC;
    }
    public int getInitiative() {
        return initiative;
    }
    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }
    public String getSpeed() {
        return speed;
    }
    public void setSpeed(String speed) {
        this.speed = speed;
    }
    public String getMaxHP() {
        return maxHP;
    }
    public void setMaxHP(String maxHP) {
        this.maxHP = maxHP;
    }
    public String getActualHP() {
        return actualHP;
    }
    public void setActualHP(String actualHP) {
        this.actualHP = actualHP;
    }
    public String getTempHP() {
        return tempHP;
    }
    public void setTempHP(String tempHP) {
        this.tempHP = tempHP;
    }
    public Dice getMaxLifeDice() {
        return maxLifeDice;
    }
    public void setMaxLifeDice(Dice maxLifeDice) {
        this.maxLifeDice = maxLifeDice;
    }
    public Dice getActualLifeDice() {
        return actualLifeDice;
    }
    public void setActualLifeDice(Dice actualLifeDice) {
        this.actualLifeDice = actualLifeDice;
    }
    public boolean[] getSuccessfulTSAgainstDeath(){
        return successfulTSAgainstDeath;
    }
    public boolean[] getFailedTSAgainstDeath(){
        return failedTSAgainstDeath;
    }
    public void setSuccessfulTSAgainstDeath(boolean[] successfulTSAgainstDeath){
        this.successfulTSAgainstDeath = successfulTSAgainstDeath;
    }
    public void setFailedTSAgainstDeath(boolean[] failedTSAgainstDeath){
        this.failedTSAgainstDeath = failedTSAgainstDeath;
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Vitals))
            return false;
        Vitals vitals = (Vitals) obj;
        return vitals.AC == this.AC &&
                vitals.initiative == this.initiative &&
                vitals.actualLifeDice.equals(this.actualLifeDice) &&
                vitals.maxLifeDice.equals(this.maxLifeDice) &&
                vitals.speed.equals(this.speed) &&
                vitals.maxHP.equals(this.maxHP) &&
                vitals.tempHP.equals(this.tempHP) &&
                vitals.actualHP.equals(this.actualHP) &&
                Arrays.equals(vitals.successfulTSAgainstDeath, this.successfulTSAgainstDeath) &&
                Arrays.equals(vitals.failedTSAgainstDeath, this.failedTSAgainstDeath);
    }
    @Override
    public String toString() {
        return "Armor Class: "+AC+"\n"+
                "Initiative: "+initiative+"\n"+
                "Speed: "+speed+"\n"+
                "Max HP: "+maxHP+"\n"+
                "Actual HP: "+actualHP+"\n"+
                "Temp HP: "+tempHP+"\n"+
                "Max Life Dice: "+maxLifeDice+"\n"+
                "Actual Life Dice: "+actualLifeDice+"\n"+
                "Successful TS Against Death: "+ Arrays.toString(successfulTSAgainstDeath) +"\n"+
                "Failed TS Against Death: " + Arrays.toString(failedTSAgainstDeath);
    }
}
