package com.italianDudes.dnd_extension.common.sheet.components;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class AlliesAndOrganization extends SheetComponent {

    //Attributes
    private final ArrayList<String> allies;
    private final ArrayList<String> organizations;
    private CharacterSymbol characterSymbol;

    //Constructors
    public AlliesAndOrganization(CharacterSymbol characterSymbol){
        this(null, null, characterSymbol);
    }
    public AlliesAndOrganization(ArrayList<String> allies, ArrayList<String> organizations, CharacterSymbol characterSymbol){
        if(allies==null)
            this.allies = new ArrayList<>();
        else
            this.allies = allies;
        if(organizations==null)
            this.organizations = new ArrayList<>();
        else
            this.organizations = organizations;
        this.characterSymbol = characterSymbol;
    }
    public AlliesAndOrganization(){
        this(null,null,null);
    }

    //Methods
    public String getAlly(int index){
        return allies.get(index);
    }
    public boolean addAlly(String ally){
        return allies.add(ally);
    }
    public String removeAlly(int index){
        return allies.remove(index);
    }
    public boolean removeAlly(String ally){
        return allies.remove(ally);
    }
    public int getAlliesNumber(){
        return allies.size();
    }
    public String getOrganization(int index){
        return organizations.get(index);
    }
    public boolean addOrganization(String organization){
        return organizations.add(organization);
    }
    public String removeOrganization(int index){
        return organizations.remove(index);
    }
    public boolean removeOrganization(String organization){
        return organizations.remove(organization);
    }
    public int getOrganizationsNumber(){
        return organizations.size();
    }
    public CharacterSymbol getCharacterSymbol() {
        return characterSymbol;
    }
    public void setCharacterSymbol(CharacterSymbol characterSymbol) {
        this.characterSymbol = characterSymbol;
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof AlliesAndOrganization))
            return false;
        AlliesAndOrganization alliesAndOrganization = (AlliesAndOrganization) obj;
        return alliesAndOrganization.organizations.equals(this.organizations) &&
                alliesAndOrganization.allies.equals(this.allies) &&
                alliesAndOrganization.characterSymbol.equals(this.characterSymbol);
    }
    @Override
    public String toString() {
        return "Allies:\n"+allies+"\n"+
                "Organizations:\n"+organizations+"\n"+
                "Character Symbol: "+characterSymbol;
    }
}
