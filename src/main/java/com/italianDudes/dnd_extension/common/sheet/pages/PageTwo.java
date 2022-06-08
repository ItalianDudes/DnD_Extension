package com.italianDudes.dnd_extension.common.sheet.pages;

import com.italianDudes.dnd_extension.common.sheet.components.AlliesAndOrganization;
import com.italianDudes.dnd_extension.common.sheet.components.CharacterBackstory;
import com.italianDudes.dnd_extension.common.sheet.components.CharacterHeader;
import com.italianDudes.dnd_extension.common.sheet.components.Treasure;
import org.jetbrains.annotations.NotNull;

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
