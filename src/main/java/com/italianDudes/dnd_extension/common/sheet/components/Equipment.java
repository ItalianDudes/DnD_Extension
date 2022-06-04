package com.italianDudes.dnd_extension.common.sheet.components;

import java.util.ArrayList;

public class Equipment {

    //Attributes
    private final Money money;
    private final ArrayList<String> equipmentList;

    //Constructors
    public Equipment(Money money, ArrayList<String> equipmentList){
        this.money = money;
        this.equipmentList = equipmentList;
    }
    public Equipment(){
        this.money = new Money();
        this.equipmentList = new ArrayList<>();
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
