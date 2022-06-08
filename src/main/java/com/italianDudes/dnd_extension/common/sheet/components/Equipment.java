package com.italianDudes.dnd_extension.common.sheet.components;

import com.italianDudes.gvedk.common.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Equipment implements Serializable {

    //Attributes
    private final Money money;
    private final ArrayList<String> equipmentList;

    //Constructors
    public Equipment(Money money, ArrayList<String> equipmentList){
        if(money==null)
            this.money = new Money();
        else
            this.money = money;
        if(equipmentList==null)
            this.equipmentList = new ArrayList<>();
        else
            this.equipmentList = equipmentList;
    }
    public Equipment(){
        this(null,null);
    }

    //Methods
    public Money getMoney() {
        return money;
    }
    public ArrayList<String> getEquipmentList() {
        return equipmentList;
    }
    public String getEquipment(int index){
        return equipmentList.get(index);
    }
    public boolean addEquipmentPiece(String equipmentPiece){
        return equipmentList.add(equipmentPiece);
    }
    public String removeEquipmentPiece(int index){
        return equipmentList.remove(index);
    }
    public boolean removeEquipmentPiece(String equipmentPiece){
        return equipmentList.remove(equipmentPiece);
    }
    public int getEquipmentPiecesNumber(){
        return equipmentList.size();
    }
    public static void writeEquipment(Equipment equipment, File destinationEquipmentFile) throws IOException {

        BufferedWriter outFile = new BufferedWriter(new FileWriter(destinationEquipmentFile));

        outFile.write(equipment.money.getCC()+"\n");
        outFile.write(equipment.money.getSC()+"\n");
        outFile.write(equipment.money.getEC()+"\n");
        outFile.write(equipment.money.getGC()+"\n");
        outFile.write(equipment.money.getPC()+"\n");
        outFile.flush();

        outFile.write(equipment.equipmentList.size()+"\n");
        for(int i=0;i<equipment.equipmentList.size();i++){
            outFile.write(equipment.equipmentList.get(i)+"\n");
        }
        outFile.flush();

        outFile.close();

    }
    public static Equipment readEquipment(File equipmentFile){

        Scanner inFile;
        try{
            inFile = new Scanner(equipmentFile);
        }catch (FileNotFoundException e){
            Logger.log(e);
            return new Equipment();
        }

        Money money = new Money(Integer.parseInt(inFile.nextLine()),Integer.parseInt(inFile.nextLine()),Integer.parseInt(inFile.nextLine()),Integer.parseInt(inFile.nextLine()),Integer.parseInt(inFile.nextLine()));

        ArrayList<String> eqList = new ArrayList<>();

        int numEquipment = Integer.parseInt(inFile.nextLine());

        for(int i=0;i<numEquipment && inFile.hasNext();i++){
            eqList.add(inFile.nextLine());
        }

        inFile.close();

        return new Equipment(money,eqList);
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Equipment))
            return false;
        Equipment equipment = (Equipment) obj;
        return equipment.money.equals(this.money) && equipment.equipmentList.equals(this.equipmentList);
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(money).append("\n");
        for(int i = 0; i< equipmentList.size(); i++) {
            stringBuilder.append(equipmentList.get(i));
            if(i+1< equipmentList.size())
                stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
