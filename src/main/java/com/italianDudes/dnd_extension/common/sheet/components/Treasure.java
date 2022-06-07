package com.italianDudes.dnd_extension.common.sheet.components;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Treasure extends SheetComponent{

    //Attributes
    private final ArrayList<String> treasuresList;

    //Constructors
    public Treasure(ArrayList<String> treasuresList){
        if(treasuresList==null)
            this.treasuresList = new ArrayList<>();
        else
            this.treasuresList = treasuresList;
    }
    public Treasure(){
        this(null);
    }

    //Methods
    public String getTreasure(int index){
        return treasuresList.get(index);
    }
    public boolean addTreasure(String treasure){
        return treasuresList.add(treasure);
    }
    public String removeTreasure(int index){
        return treasuresList.remove(index);
    }
    public boolean removeTreasure(String treasure){
        return treasuresList.remove(treasure);
    }
    public int getTreasuresNumber(){
        return treasuresList.size();
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Treasure))
            return false;
        return ((Treasure) obj).treasuresList.equals(this.treasuresList);
    }
    @Override
    public String toString() {
        return "Treasures: "+treasuresList;
    }
}
