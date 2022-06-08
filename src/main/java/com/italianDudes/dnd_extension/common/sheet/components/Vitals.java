package com.italianDudes.dnd_extension.common.sheet.components;

import com.italianDudes.dnd_extension.DnD_Extension;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Vitals implements Serializable {

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
    public static void writeVitals(Vitals vitals, File destinationVitalsFile) throws IOException {

        BufferedWriter outFile = new BufferedWriter(new FileWriter(destinationVitalsFile));

        outFile.write(vitals.AC+"\n");
        outFile.write(vitals.initiative+"\n");
        outFile.write(vitals.speed+"\n");
        outFile.write(vitals.maxHP+"\n");
        outFile.write(vitals.actualHP+"\n");
        outFile.write(vitals.tempHP+"\n");
        outFile.flush();
        outFile.write(vitals.maxLifeDice.getNumDices()+"\n");
        outFile.write(vitals.maxLifeDice.getNumFaces()+"\n");
        outFile.write(vitals.maxLifeDice.getModifier()+"\n");
        outFile.flush();
        outFile.write(vitals.actualLifeDice.getNumDices()+"\n");
        outFile.write(vitals.actualLifeDice.getNumFaces()+"\n");
        outFile.write(vitals.actualLifeDice.getModifier()+"\n");
        outFile.flush();
        for(int i=0;i< vitals.successfulTSAgainstDeath.length;i++){
            outFile.write(vitals.successfulTSAgainstDeath[i]+"\n");
        }
        outFile.flush();
        for(int i=0;i< vitals.failedTSAgainstDeath.length;i++){
            outFile.write(vitals.failedTSAgainstDeath[i]+"\n");
        }

        outFile.flush();
        outFile.close();

    }
    public static Vitals readVitals(File vitalsFile) throws FileNotFoundException {

        Scanner inFile = new Scanner(vitalsFile);

        int AC = Integer.parseInt(inFile.nextLine());
        int initiative = Integer.parseInt(inFile.nextLine());
        String speed = inFile.nextLine();
        String maxHP = inFile.nextLine();
        String actualHP = inFile.nextLine();
        String tempHP = inFile.nextLine();

        Dice maxLifeDice = new Dice(inFile.nextLine(),Integer.parseInt(inFile.nextLine()),inFile.nextLine());
        Dice actualLifeDice = new Dice(inFile.nextLine(),Integer.parseInt(inFile.nextLine()),inFile.nextLine());

        boolean[] successfulTSAgainstDeath = new boolean[DnD_Extension.Defs.NUM_TS_AGAINST_DEATH];
        boolean[] failedTSAgainstDeath = new boolean[DnD_Extension.Defs.NUM_TS_AGAINST_DEATH];

        for(int i=0;i< DnD_Extension.Defs.NUM_TS_AGAINST_DEATH;i++)
            successfulTSAgainstDeath[i] = Boolean.parseBoolean(inFile.nextLine());
        for(int i=0;i< DnD_Extension.Defs.NUM_TS_AGAINST_DEATH;i++)
            failedTSAgainstDeath[i] = Boolean.parseBoolean(inFile.nextLine());

        inFile.close();
        return new Vitals(AC,initiative,speed,maxHP,actualHP,tempHP,maxLifeDice,actualLifeDice,successfulTSAgainstDeath,failedTSAgainstDeath);

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
