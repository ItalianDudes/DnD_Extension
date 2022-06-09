package com.italianDudes.dnd_extension.common.sheet.components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SpellList implements Serializable {

    //Attributes
    private final int spellRegionID;
    private final ArrayList<Spell> spellList;

    //Constructors
    public SpellList(int spellRegionID){
        this(spellRegionID,new ArrayList<>());
    }
    public SpellList(int spellRegionID, ArrayList<Spell> spellList){
        this.spellRegionID = spellRegionID;
        if(spellList==null)
            this.spellList = new ArrayList<>();
        else
            this.spellList = spellList;
    }

    //Methods
    public int getSpellRegionID(){
        return spellRegionID;
    }
    public Spell getSpell(int index){
        return spellList.get(index);
    }
    public boolean addSpell(Spell spell){
        return spellList.add(spell);
    }
    public Spell removeSpell(int index){
        return spellList.remove(index);
    }
    public boolean removeSpell(Spell spell){
        return spellList.remove(spell);
    }
    public int getSpellsNumber(){
        return spellList.size();
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof SpellList))
            return false;
        SpellList spellList = (SpellList) obj;
        return spellList.spellList.equals(this.spellList) && spellList.spellRegionID == this.spellRegionID;
    }
    @Override
    public String toString() {
        return "Spell Region ID: "+spellRegionID+"\n"+
                "Spell List: "+ Arrays.toString(spellList.toArray());
    }
}
