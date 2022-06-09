package com.italianDudes.dnd_extension.common.sheet.components;

import com.italianDudes.gvedk.common.*;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class AlliesAndOrganization implements Serializable {

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
        if(characterSymbol==null)
            this.characterSymbol = new CharacterSymbol();
        else
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
    public static AlliesAndOrganization readAlliesAndOrganizations(File alliesAndOrganizationsSourceFile, File symbolNameFile, File symbolImageFile){

        Scanner inFile;
        ArrayList<String> allies = null, organizations = null;

        try {
            inFile = new Scanner(alliesAndOrganizationsSourceFile);
            int numAllies = Integer.parseInt(inFile.nextLine());

            if(numAllies>0){
                allies = new ArrayList<>();
                for(int i=0;i<numAllies;i++){
                    allies.add(inFile.nextLine());
                }
            }

            int numOrganizations = Integer.parseInt(inFile.nextLine());

            if(numOrganizations>0){
                organizations = new ArrayList<>();
                for(int i=0;i<numOrganizations;i++){
                    organizations.add(inFile.nextLine());
                }
            }

            inFile.close();
        }catch (FileNotFoundException e){
            Logger.log(e);
        }

        String symbolName = null;

        try {
            inFile = new Scanner(symbolNameFile);
            symbolName = inFile.nextLine();
            inFile.close();
        }catch (FileNotFoundException e){
            Logger.log(e);
        }

        FormattedImage symbolImage = null;

        try {
            symbolImage = new FormattedImage(ImageIO.read(symbolImageFile), FileHandler.getFileExtension(symbolImageFile));
        }catch (IOException e){
            Logger.log(e);
        }

        return new AlliesAndOrganization(allies,organizations,new CharacterSymbol(symbolName,symbolImage));
    }
    public static void writeAlliesAndOrganizations(AlliesAndOrganization alliesAndOrganization, File destinationAlliesAndOrganizationsFile, File destinationSymbolNameFile, File destinationSymbolImageFile) throws IOException {

        BufferedWriter outFile = new BufferedWriter(new FileWriter(destinationAlliesAndOrganizationsFile));

        outFile.write(alliesAndOrganization.allies.size()+"\n");
        if(alliesAndOrganization.allies.size()>0){
            for(int i=0;i<alliesAndOrganization.allies.size();i++){
                outFile.write(alliesAndOrganization.allies.get(i)+"\n");
            }
        }
        outFile.flush();

        outFile.write(alliesAndOrganization.organizations.size()+"\n");
        if(alliesAndOrganization.organizations.size()>0){
            for(int i=0;i<alliesAndOrganization.organizations.size();i++){
                outFile.write(alliesAndOrganization.organizations.get(i)+"\n");
            }
        }
        outFile.flush();
        outFile.close();

        outFile = new BufferedWriter(new FileWriter(destinationSymbolNameFile));
        outFile.write(alliesAndOrganization.characterSymbol.getSymbolName()+"\n");
        outFile.flush();
        outFile.close();

        ImageHandler.writeImage(destinationSymbolImageFile,alliesAndOrganization.characterSymbol.getSymbolImage().getImage());

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
