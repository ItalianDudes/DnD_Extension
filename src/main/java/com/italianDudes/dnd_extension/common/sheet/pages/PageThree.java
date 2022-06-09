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
    public static void writePageThree(PageThree pageThree, String sheetDirectoryPath) throws IOException {
        writePageThree(pageThree, new File(sheetDirectoryPath));
    }
    public static void writePageThree(PageThree pageThree, File sheetDirectory) throws IOException {

        if(!DirectoryHandler.directoryExist(sheetDirectory)){
            throw new DirectoryNotFoundException("directory "+sheetDirectory.getAbsolutePath()+" not found");
        }

        File pageThreeDirectory = new File(sheetDirectory.getAbsolutePath()+"/"+ DnD_Extension.Defs.DIRNAME_PAGE_THREE);

        if(!DirectoryHandler.directoryExist(pageThreeDirectory)){
            if(!pageThreeDirectory.mkdir())
                throw new IOException("Can't create "+pageThreeDirectory.getAbsolutePath()+" directory");
        }

        SpellHeader.writeSpellHeader(pageThree.spellHeader, pageThreeDirectory.getAbsolutePath()+"/"+DnD_Extension.Defs.FILENAME_SPELL_HEADER);

        for(int i=0;i< DnD_Extension.Defs.NUM_SPELL_REGIONS;i++){
            SpellRegion.writeSpellRegion(pageThree.spellRegions[i], pageThreeDirectory.getAbsolutePath()+"/"+i+DnD_Extension.Defs.FILENAME_GENERIC_SPELL_REGION);
        }
    }
    public static PageThree readPageThree(String sheetDirectoryPath) throws DirectoryNotFoundException {
        return readPageThree(new File(sheetDirectoryPath));
    }
    public static PageThree readPageThree(File sheetDirectory) throws DirectoryNotFoundException {

        File pageThreeDirectory = new File(sheetDirectory+"/"+ DnD_Extension.Defs.DIRNAME_PAGE_THREE);

        if(!DirectoryHandler.directoryExist(pageThreeDirectory))
            throw new DirectoryNotFoundException("directory "+pageThreeDirectory.getAbsolutePath()+" not found");

        SpellHeader spellHeader = SpellHeader.readSpellHeader(pageThreeDirectory.getAbsolutePath()+"/"+DnD_Extension.Defs.FILENAME_SPELL_HEADER);
        SpellRegion[] spellRegions = new SpellRegion[DnD_Extension.Defs.NUM_SPELL_REGIONS];

        for(int i=0;i< DnD_Extension.Defs.NUM_SPELL_REGIONS;i++){
            spellRegions[i] = SpellRegion.readSpellRegion(i,pageThreeDirectory.getAbsolutePath()+"/"+i+DnD_Extension.Defs.FILENAME_GENERIC_SPELL_REGION);
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
