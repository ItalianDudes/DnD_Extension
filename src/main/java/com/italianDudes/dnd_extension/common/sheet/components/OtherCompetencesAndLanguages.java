package com.italianDudes.dnd_extension.common.sheet.components;

import java.util.ArrayList;

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
