package com.italianDudes.dnd_extension.common.sheet.pages;

import com.italianDudes.dnd_extension.DnD_Extension;
import com.italianDudes.dnd_extension.common.sheet.components.AlliesAndOrganization;
import com.italianDudes.dnd_extension.common.sheet.components.CharacterBackstory;
import com.italianDudes.dnd_extension.common.sheet.components.CharacterHeader;
import com.italianDudes.dnd_extension.common.sheet.components.Treasure;
import com.italianDudes.gvedk.common.DirectoryHandler;
import com.italianDudes.gvedk.common.FileHandler;
import com.italianDudes.gvedk.common.exceptions.IO.directory.DirectoryNotFoundException;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

@SuppressWarnings("unused")
public class PageTwo implements Serializable {

    //Attributes
    private CharacterHeader characterHeader;
    private AlliesAndOrganization alliesAndOrganizations;
    private CharacterBackstory characterBackstory;
    private Treasure treasure;

    //Constructors
    public PageTwo(@NotNull CharacterHeader characterHeader, AlliesAndOrganization alliesAndOrganizations, CharacterBackstory characterBackstory, Treasure treasure){
        this.characterHeader = characterHeader;
        if(alliesAndOrganizations==null)
            this.alliesAndOrganizations = new AlliesAndOrganization();
        else
            this.alliesAndOrganizations = alliesAndOrganizations;
        if(characterBackstory==null)
            this.characterBackstory = new CharacterBackstory();
        else
            this.characterBackstory = characterBackstory;
        if(treasure==null)
            this.treasure = new Treasure();
        else
            this.treasure = treasure;
    }
    public PageTwo(@NotNull CharacterHeader characterHeader){
        this(characterHeader,null,null,null);
    }

    //Methods
    public CharacterHeader getCharacterHeader() {
        return characterHeader;
    }
    public void setCharacterHeader(CharacterHeader characterHeader) {
        this.characterHeader = characterHeader;
    }
    public AlliesAndOrganization getAlliesAndOrganizations() {
        return alliesAndOrganizations;
    }
    public void setAlliesAndOrganizations(AlliesAndOrganization alliesAndOrganizations) {
        this.alliesAndOrganizations = alliesAndOrganizations;
    }
    public CharacterBackstory getCharacterBackstory() {
        return characterBackstory;
    }
    public void setCharacterBackstory(CharacterBackstory characterBackstory) {
        this.characterBackstory = characterBackstory;
    }
    public Treasure getTreasure() {
        return treasure;
    }
    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }
    public static void writePageTwo(PageTwo pageTwo, String sheetDirectoryPath) throws IOException {
        writePageTwo(pageTwo, new File(sheetDirectoryPath));
    }
    public static void writePageTwo(PageTwo pageTwo, File sheetDirectory) throws IOException {

        if(!DirectoryHandler.directoryExist(sheetDirectory)){
            throw new DirectoryNotFoundException("directory "+sheetDirectory.getAbsolutePath()+" not found");
        }

        File pageTwoDirectory = new File(sheetDirectory.getAbsolutePath()+"/"+ DnD_Extension.Defs.DIRNAME_PAGE_TWO);

        if(!DirectoryHandler.directoryExist(pageTwoDirectory)){
            if(!pageTwoDirectory.mkdir())
                throw new IOException("Can't create "+pageTwoDirectory.getAbsolutePath()+" directory");
        }

        CharacterHeader.writeCharacterHeader(
                pageTwo.characterHeader,
                new File(pageTwoDirectory.getAbsoluteFile()+"/"+ DnD_Extension.Defs.FILENAME_CHARACTER_HEADER),
                new File(pageTwoDirectory.getAbsolutePath()+"/"+ DnD_Extension.Defs.FILENAME_CHARACTER_IMAGE_NO_EXT+"."+pageTwo.characterHeader.getCharacterImage().getFormatName())
        );

        AlliesAndOrganization.writeAlliesAndOrganizations(
                pageTwo.alliesAndOrganizations,new File(pageTwoDirectory.getAbsolutePath()+"/"+DnD_Extension.Defs.FILENAME_ALLIES_AND_ORGANIZATIONS),
                new File(pageTwoDirectory.getAbsolutePath()+"/"+DnD_Extension.Defs.FILENAME_SYMBOL_NAME),
                new File(pageTwoDirectory.getAbsolutePath()+"/"+DnD_Extension.Defs.FILENAME_SYMBOL_IMAGE_NO_EXT+"."+pageTwo.alliesAndOrganizations.getCharacterSymbol().getSymbolImage().getFormatName())
        );

        CharacterBackstory.writeCharacterBackstory(pageTwo.characterBackstory,new File(pageTwoDirectory.getAbsolutePath()+"/"+ DnD_Extension.Defs.FILENAME_CHARACTER_BACKSTORY));

        Treasure.writeTreasure(pageTwo.treasure, new File(pageTwoDirectory.getAbsolutePath()+"/"+ DnD_Extension.Defs.FILENAME_TREASURE));

    }
    public static PageTwo readPageTwo(String sheetDirectoryPath) throws DirectoryNotFoundException {
        return readPageTwo(new File(sheetDirectoryPath));
    }
    public static PageTwo readPageTwo(File sheetDirectory) throws DirectoryNotFoundException {

        File pageTwoDirectory = new File(sheetDirectory.getAbsolutePath()+"/"+ DnD_Extension.Defs.DIRNAME_PAGE_TWO);

        if(!DirectoryHandler.directoryExist(pageTwoDirectory))
            throw new DirectoryNotFoundException("directory "+pageTwoDirectory.getAbsolutePath()+" not found");

        File characterImageFile = FileHandler.findFilesWithName(pageTwoDirectory, DnD_Extension.Defs.FILENAME_CHARACTER_IMAGE_NO_EXT)[0];
        CharacterHeader characterHeader = CharacterHeader.readCharacterHeader(
                new File(pageTwoDirectory.getAbsolutePath()+"/"+DnD_Extension.Defs.FILENAME_CHARACTER_HEADER),
                characterImageFile);

        File symbolImageFile = FileHandler.findFilesWithName(pageTwoDirectory, DnD_Extension.Defs.FILENAME_SYMBOL_IMAGE_NO_EXT)[0];
        AlliesAndOrganization alliesAndOrganizations = AlliesAndOrganization.readAlliesAndOrganizations(
                new File(pageTwoDirectory.getAbsolutePath()+"/"+DnD_Extension.Defs.FILENAME_ALLIES_AND_ORGANIZATIONS),
                new File(pageTwoDirectory.getAbsolutePath()+"/"+DnD_Extension.Defs.FILENAME_SYMBOL_NAME),
                symbolImageFile
        );

        CharacterBackstory characterBackstory = CharacterBackstory.readCharacterBackstory(pageTwoDirectory.getAbsolutePath()+"/"+DnD_Extension.Defs.FILENAME_CHARACTER_BACKSTORY);
        Treasure treasure = Treasure.readTreasure(pageTwoDirectory.getAbsolutePath()+"/"+DnD_Extension.Defs.FILENAME_TREASURE);

        return new PageTwo(characterHeader,alliesAndOrganizations,characterBackstory,treasure);

    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof PageTwo))
            return false;
        PageTwo pageTwo = (PageTwo) obj;
        return pageTwo.treasure.equals(this.treasure) &&
                pageTwo.alliesAndOrganizations.equals(this.alliesAndOrganizations) &&
                pageTwo.characterHeader.equals(this.characterHeader) &&
                pageTwo.characterBackstory.equals(this.characterBackstory);
    }
    @Override
    public String toString() {
        return "Character Header:\n"+characterHeader+"\n"+
                "Character Backstory:\n"+characterBackstory+"\n"+
                "Allies & Organizations:\n"+ alliesAndOrganizations +"\n"+
                "Treasure:"+treasure;
    }
}
