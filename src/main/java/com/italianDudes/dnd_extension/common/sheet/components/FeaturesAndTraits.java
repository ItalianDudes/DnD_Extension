package com.italianDudes.dnd_extension.common.sheet.components;

import com.italianDudes.gvedk.common.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class FeaturesAndTraits implements Serializable {

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
    public static void writeFeaturesAndTraits(FeaturesAndTraits featuresAndTraits, File destinationFeaturesAndTraitsFile) throws IOException {

        BufferedWriter outFile = new BufferedWriter(new FileWriter(destinationFeaturesAndTraitsFile));

        outFile.write(featuresAndTraits.featuresAndTraitsList.size()+"\n");
        for(int i=0;i<featuresAndTraits.featuresAndTraitsList.size();i++){
            outFile.write(featuresAndTraits.featuresAndTraitsList.get(i)+"\n");
        }

        outFile.close();

    }
    public static FeaturesAndTraits readFeaturesAndTraits(File featuresAndTraitsFile){

        Scanner inFile;
        try{
            inFile = new Scanner(featuresAndTraitsFile);
        }catch (FileNotFoundException e){
            Logger.log(e);
            return new FeaturesAndTraits();
        }

        ArrayList<String> featuresAndTraits = new ArrayList<>();

        int numFeaturesAndTraits = Integer.parseInt(inFile.nextLine());

        for(int i=0;i<numFeaturesAndTraits;i++){
            featuresAndTraits.add(inFile.nextLine());
        }

        inFile.close();

        return new FeaturesAndTraits(featuresAndTraits);

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
