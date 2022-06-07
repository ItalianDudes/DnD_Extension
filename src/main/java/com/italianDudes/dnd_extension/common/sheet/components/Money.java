package com.italianDudes.dnd_extension.common.sheet.components;

@SuppressWarnings("unused")
public class Money {

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
    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public int getSc() {
        return sc;
    }

    public void setSc(int sc) {
        this.sc = sc;
    }

    public int getEc() {
        return ec;
    }

    public void setEc(int ec) {
        this.ec = ec;
    }

    public int getGc() {
        return gc;
    }

    public void setGc(int gc) {
        this.gc = gc;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
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
