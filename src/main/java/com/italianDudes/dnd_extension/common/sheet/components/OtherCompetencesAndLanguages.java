package com.italianDudes.dnd_extension.common.sheet.components;

import com.italianDudes.gvedk.common.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class OtherCompetencesAndLanguages {

    //Attributes
    private final ArrayList<String> armorsProficiencyList;
    private final ArrayList<String> weaponsProficiencyList;
    private final ArrayList<String> toolsProficiencyList;
    private final ArrayList<String> languagesProficiencyList;

    //Constructors
    public OtherCompetencesAndLanguages(ArrayList<String> armorsProficiencyList, ArrayList<String> weaponsProficiencyList, ArrayList<String> toolsProficiencyList, ArrayList<String> languagesProficiencyList){
        if(armorsProficiencyList==null)
            this.armorsProficiencyList = new ArrayList<>();
        else
            this.armorsProficiencyList = armorsProficiencyList;
        if(weaponsProficiencyList==null)
            this.weaponsProficiencyList = new ArrayList<>();
        else
            this.weaponsProficiencyList = weaponsProficiencyList;
        if(toolsProficiencyList==null)
            this.toolsProficiencyList = new ArrayList<>();
        else
            this.toolsProficiencyList = toolsProficiencyList;
        if(languagesProficiencyList==null)
            this.languagesProficiencyList = new ArrayList<>();
        else
            this.languagesProficiencyList = languagesProficiencyList;
    }
    public OtherCompetencesAndLanguages(){
        this(null,null,null,null);
    }

    //Methods
    public String getArmorType(int index){
        return armorsProficiencyList.get(index);
    }
    public boolean addArmorType(String armorType){
        return armorsProficiencyList.add(armorType);
    }
    public String removeArmorType(int index){
        return armorsProficiencyList.remove(index);
    }
    public boolean removeArmorType(String armorType){
        return armorsProficiencyList.remove(armorType);
    }
    public int getArmorsNumber(){
        return armorsProficiencyList.size();
    }
    public String getWeaponType(int index){
        return weaponsProficiencyList.get(index);
    }
    public boolean addWeaponType(String weaponType){
        return weaponsProficiencyList.add(weaponType);
    }
    public String removeWeaponType(int index){
        return weaponsProficiencyList.remove(index);
    }
    public boolean removeWeaponType(String weaponType){
        return weaponsProficiencyList.remove(weaponType);
    }
    public int getWeaponsNumber(){
        return weaponsProficiencyList.size();
    }
    public String getToolType(int index){
        return toolsProficiencyList.get(index);
    }
    public boolean addTool(String tool){
        return toolsProficiencyList.add(tool);
    }
    public String removeTool(int index){
        return toolsProficiencyList.remove(index);
    }
    public boolean removeTool(String tool){
        return toolsProficiencyList.remove(tool);
    }
    public int getToolsNumber(){
        return toolsProficiencyList.size();
    }
    public String getLanguage(int index){
        return languagesProficiencyList.get(index);
    }
    public boolean addLanguage(String language){
        return languagesProficiencyList.add(language);
    }
    public String removeLanguage(int index){
        return languagesProficiencyList.remove(index);
    }
    public boolean removeLanguage(String language){
        return languagesProficiencyList.remove(language);
    }
    public int getLanguagesNumber(){
        return languagesProficiencyList.size();
    }
    public static void writeOtherCompetencesAndLanguages(OtherCompetencesAndLanguages otherCompetencesAndLanguages, File destinationOtherCompetencesAndLanguagesFile) throws IOException {

        BufferedWriter outFile = new BufferedWriter(new FileWriter(destinationOtherCompetencesAndLanguagesFile));

        outFile.write(otherCompetencesAndLanguages.armorsProficiencyList.size()+"\n");
        for(int i=0;i< otherCompetencesAndLanguages.armorsProficiencyList.size();i++){
            outFile.write(otherCompetencesAndLanguages.armorsProficiencyList.get(i)+"\n");
        }
        outFile.flush();

        outFile.write(otherCompetencesAndLanguages.weaponsProficiencyList.size()+"\n");
        for(int i=0;i< otherCompetencesAndLanguages.weaponsProficiencyList.size();i++){
            outFile.write(otherCompetencesAndLanguages.weaponsProficiencyList.get(i)+"\n");
        }
        outFile.flush();

        outFile.write(otherCompetencesAndLanguages.toolsProficiencyList.size()+"\n");
        for(int i=0;i< otherCompetencesAndLanguages.toolsProficiencyList.size();i++){
            outFile.write(otherCompetencesAndLanguages.toolsProficiencyList.get(i)+"\n");
        }
        outFile.flush();

        outFile.write(otherCompetencesAndLanguages.languagesProficiencyList.size()+"\n");
        for(int i=0;i< otherCompetencesAndLanguages.languagesProficiencyList.size();i++){
            outFile.write(otherCompetencesAndLanguages.languagesProficiencyList.get(i)+"\n");
        }
        outFile.flush();

        outFile.close();

    }
    public static OtherCompetencesAndLanguages readOtherCompetencesAndLanguages(File otherCompetencesAndLanguagesFile){

        Scanner inFile;
        try{
            inFile = new Scanner(otherCompetencesAndLanguagesFile);
        }catch (FileNotFoundException e){
            Logger.log(e);
            return new OtherCompetencesAndLanguages();
        }

        ArrayList<String> armorsProficiencyList = new ArrayList<>();
        ArrayList<String> weaponsProficiencyList = new ArrayList<>();
        ArrayList<String> toolsProficiencyList = new ArrayList<>();
        ArrayList<String> languagesProficiencyList = new ArrayList<>();

        int armorsProficiencyNum = Integer.parseInt(inFile.nextLine());
        for(int i=0;i<armorsProficiencyNum;i++){
            armorsProficiencyList.add(inFile.nextLine());
        }

        int weaponsProficiencyNum = Integer.parseInt(inFile.nextLine());
        for(int i=0;i<weaponsProficiencyNum;i++){
            weaponsProficiencyList.add(inFile.nextLine());
        }

        int toolsProficiencyNum = Integer.parseInt(inFile.nextLine());
        for(int i=0;i<toolsProficiencyNum;i++){
            toolsProficiencyList.add(inFile.nextLine());
        }

        int languagesProficiencyNum = Integer.parseInt(inFile.nextLine());
        for(int i=0;i<languagesProficiencyNum;i++){
            languagesProficiencyList.add(inFile.nextLine());
        }

        inFile.close();

        return new OtherCompetencesAndLanguages(armorsProficiencyList,weaponsProficiencyList,toolsProficiencyList,languagesProficiencyList);

    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof OtherCompetencesAndLanguages))
            return false;
        OtherCompetencesAndLanguages otherCompetencesAndLanguages = (OtherCompetencesAndLanguages) obj;
        return otherCompetencesAndLanguages.armorsProficiencyList.equals(this.armorsProficiencyList) &&
                otherCompetencesAndLanguages.weaponsProficiencyList.equals(this.weaponsProficiencyList) &&
                otherCompetencesAndLanguages.toolsProficiencyList.equals(this.toolsProficiencyList) &&
                otherCompetencesAndLanguages.languagesProficiencyList.equals(this.languagesProficiencyList);
    }
    @Override
    public String toString() {
        return "Armors: "+armorsProficiencyList+"\n"+
                "Weapons: "+weaponsProficiencyList+"\n"+
                "Tools: "+toolsProficiencyList+"\n"+
                "Languages: "+languagesProficiencyList;
    }
}
