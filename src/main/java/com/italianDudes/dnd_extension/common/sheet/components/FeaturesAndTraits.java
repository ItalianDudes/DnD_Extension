package com.italianDudes.dnd_extension.common.sheet.components;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class FeaturesAndTraits extends SheetComponent{

    //Attributes
    private final ArrayList<String> featuresAndTraitsList;

    //Constructors
    public FeaturesAndTraits(ArrayList<String> featuresAndTraitsList){
        if(featuresAndTraitsList ==null)
            this.featuresAndTraitsList = new ArrayList<>();
        else
            this.featuresAndTraitsList = featuresAndTraitsList;
    }
    public FeaturesAndTraits(){
        this(null);
    }

    //Methods
    public String getFeatureAndTrait(int index){
        return featuresAndTraitsList.get(index);
    }
    public boolean addFeatureAndTrait(String featureAndTrait){
        return featuresAndTraitsList.add(featureAndTrait);
    }
    public String removeFeatureAndTrait(int index){
        return featuresAndTraitsList.remove(index);
    }
    public boolean removeFeatureAndTrait(String featureAndTrait){
        return featuresAndTraitsList.remove(featureAndTrait);
    }
    public int getFeaturesAndTraitsNumber(){
        return featuresAndTraitsList.size();
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof FeaturesAndTraits))
            return false;
        FeaturesAndTraits featuresAndTraits = (FeaturesAndTraits) obj;
        return featuresAndTraits.featuresAndTraitsList.equals(this.featuresAndTraitsList);
    }
    @Override
    public String toString() {
        return "Features and Traits: "+ featuresAndTraitsList;
    }
}
