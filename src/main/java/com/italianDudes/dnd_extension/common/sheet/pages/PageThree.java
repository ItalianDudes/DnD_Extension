package com.italianDudes.dnd_extension.common.sheet.pages;

import com.italianDudes.dnd_extension.DnD_Extension;
import com.italianDudes.dnd_extension.common.sheet.components.SpellHeader;
import com.italianDudes.dnd_extension.common.sheet.components.SpellRegion;
import com.italianDudes.gvedk.common.DirectoryHandler;
import com.italianDudes.gvedk.common.exceptions.IO.directory.DirectoryNotFoundException;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

@SuppressWarnings("unused")
public class PageThree implements Serializable {

    //Attributes
    private SpellHeader spellHeader;
    private SpellRegion[] spellRegions;

    //Constructors
    public PageThree(SpellHeader spellHeader){
        this(spellHeader,null);
    }
    public PageThree(SpellRegion[] spellRegions){
        this(null,spellRegions);
    }
    public PageThree(){
        this(null,null);
    }
    public PageThree(SpellHeader spellHeader, SpellRegion[] spellRegion){
        if(spellHeader==null)
            this.spellHeader = new SpellHeader();
        else
            this.spellHeader = spellHeader;
        if(spellRegion==null){
            this.spellRegions = new SpellRegion[DnD_Extension.Defs.NUM_SPELL_REGIONS];
            for(int i=0;i< DnD_Extension.Defs.NUM_SPELL_REGIONS;i++){
                this.spellRegions[i] = new SpellRegion(i);
            }
        }else{
            this.spellRegions = spellRegion;
        }
    }

    //Methods
    public SpellHeader getSpellHeader() {
        return spellHeader;
    }
    public void setSpellHeader(SpellHeader spellHeader) {
        this.spellHeader = spellHeader;
    }
    public SpellRegion[] getSpellRegions() {
        return spellRegions;
    }
    public void setSpellRegions(SpellRegion[] spellRegions) {
        this.spellRegions = spellRegions;
    }
    public static void writePageThree(PageThree pageThree, File pageThreeDirectory) throws IOException {

        if(!DirectoryHandler.directoryExist(pageThreeDirectory))
            throw new DirectoryNotFoundException("directory "+pageThreeDirectory.getAbsolutePath()+" not found");

        SpellHeader.writeSpellHeader(pageThree.spellHeader, DnD_Extension.Defs.FILENAME_SPELL_HEADER);

        for(int i=0;i< DnD_Extension.Defs.NUM_SPELL_REGIONS;i++){
            SpellRegion.writeSpellRegion(pageThree.spellRegions[i], i+DnD_Extension.Defs.FILENAME_GENERIC_SPELL_REGION);
        }
    }
    public static PageThree readPageThree(File pageThreeDirectory){

        if(!DirectoryHandler.directoryExist(pageThreeDirectory))
            return new PageThree();

        SpellHeader spellHeader = SpellHeader.readSpellHeader(DnD_Extension.Defs.FILENAME_SPELL_HEADER);
        SpellRegion[] spellRegions = new SpellRegion[DnD_Extension.Defs.NUM_SPELL_REGIONS];

        for(int i=0;i< DnD_Extension.Defs.NUM_SPELL_REGIONS;i++){
            spellRegions[i] = SpellRegion.readSpellRegion(i, i+DnD_Extension.Defs.FILENAME_GENERIC_SPELL_REGION);
        }

        return new PageThree(spellHeader,spellRegions);

    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof PageThree))
            return false;
        PageThree pageThree = (PageThree) obj;
        return Arrays.equals(pageThree.spellRegions,this.spellRegions) &&
                pageThree.spellHeader.equals(this.spellHeader);
    }
    @Override
    public String toString() {
        return "Spell Header: "+spellHeader+"\n"+
                "Spell Regions: "+Arrays.toString(spellRegions);
    }
}
