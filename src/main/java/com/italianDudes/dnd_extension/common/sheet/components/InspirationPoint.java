package com.italianDudes.dnd_extension.common.sheet.components;

@SuppressWarnings("unused")
public class InspirationPoint extends SheetComponent {

    //Attributes
    private int inspirationPoints;

    //Constructors
    public InspirationPoint(int inspirationPoints){
        this.inspirationPoints = inspirationPoints;
    }
    public InspirationPoint(){
        this.inspirationPoints = 0;
    }

    //Methods
    public int getInspirationPoints() {
        return inspirationPoints;
    }
    public void setInspirationPoints(int inspirationPoints) {
        this.inspirationPoints = inspirationPoints;
    }
    public void addPoints(){
        inspirationPoints+=1;
    }
    public void removePoints(){
        if(inspirationPoints>0)
            inspirationPoints-=1;
    }
    public void addPoints(int points){
        if(inspirationPoints+points>=0)
            inspirationPoints+=points;
        else
            inspirationPoints=0;
    }
    public void removePoints(int points){
        if(inspirationPoints-points>=0)
            inspirationPoints-=points;
        else
            inspirationPoints=0;
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof InspirationPoint))
            return false;
        InspirationPoint inspirationPoint = (InspirationPoint) obj;
        return inspirationPoint.inspirationPoints == this.inspirationPoints;
    }
    @Override
    public String toString() {
        return String.valueOf(inspirationPoints);
    }
}
