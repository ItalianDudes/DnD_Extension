package com.italianDudes.dnd_extension.common.sheet.components;

import java.io.Serializable;

@SuppressWarnings("unused")
public class Dice implements Serializable {

    //Attributes
    private final int numFaces;
    private String numDices;
    private String modifier;

    //Constructors
    public Dice(String numDices, int numFaces){
        this(numDices,numFaces,"0");
    }
    public Dice(String numDices, int numFaces, String modifier){
        this.numDices = numDices;
        this.numFaces = numFaces;
        this.modifier = modifier;
    }

    //Methods
    public int getNumFaces() {
        return numFaces;
    }
    public String getNumDices() {
        return numDices;
    }
    public void setNumDices(String numDices) {
        if(numDices==null || numDices.equals(""))
            this.numDices = "0";
        else
            this.numDices = numDices;
    }
    public String getModifier(){
        return modifier;
    }
    public void setModifier(String modifier){
        if(modifier==null || modifier.equals(""))
            this.modifier = "0";
        else
            this.modifier = modifier;
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Dice))
            return false;
        Dice dice = (Dice) obj;
        return dice.numDices.equals(this.numDices) && dice.numFaces == this.numFaces && dice.modifier.equals(this.modifier);
    }

    @Override
    public String toString() {
        if(modifier==null || modifier.equals("") || modifier.equals("0"))
            return numDices+"d"+numFaces;
        else
            return numDices+"d"+numFaces+" + "+modifier;
    }
}
