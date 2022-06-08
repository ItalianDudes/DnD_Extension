package com.italianDudes.dnd_extension.common.sheet.components;

import java.io.Serializable;

@SuppressWarnings("unused")
public class Money implements Serializable {

    //Attributes
    private int cc;
    private int sc;
    private int ec;
    private int gc;
    private int pc;

    //Constructors
    public Money(int cc, int sc, int ec, int gc, int pc) {
        this.cc = cc;
        this.sc = sc;
        this.ec = ec;
        this.gc = gc;
        this.pc = pc;
    }
    public Money() {
        this(0, 0, 0, 0, 0);
    }

    //Methods
    public int getCC() {
        return cc;
    }
    public void setCC(int cc) {
        this.cc = cc;
    }
    public int getSC() {
        return sc;
    }
    public void setSC(int sc) {
        this.sc = sc;
    }
    public int getEC() {
        return ec;
    }
    public void setEC(int ec) {
        this.ec = ec;
    }
    public int getGC() {
        return gc;
    }
    public void setGC(int gc) {
        this.gc = gc;
    }
    public int getPC() {
        return pc;
    }
    public void setPC(int pc) {
        this.pc = pc;
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Money))
            return false;
        Money money = (Money) obj;
        return money.cc == this.cc && money.sc == this.sc && money.ec == this.ec && money.gc == this.gc && money.pc == this.pc;
    }
    @Override
    public String toString() {
        return "Copper Coins: "+cc+"\n"+
                "Silver Coins: "+sc+"\n"+
                "Electrum Coins: "+ec+"\n"+
                "Gold Coins: "+gc+"\n"+
                "Platinum Coins: "+pc;
    }
}
