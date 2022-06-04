package com.italianDudes.dnd_extension.common.sheet.components;

public class Dice {

    //Attributes
    private final int numFaces;
    private String numDices;
    private String modifier;

    //Constructors
    public Dice(int numFaces, String numDices){
        this(numFaces,numDices,"0");
    }
    public Dice(int numFaces, String numDices, String modifier){
        this.numFaces = numFaces;
        this.numDices = numDices;
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
