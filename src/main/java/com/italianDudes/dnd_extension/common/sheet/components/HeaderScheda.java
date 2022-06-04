package com.italianDudes.dnd_extension.common.sheet.components;

public class HeaderScheda {

    //Attributes
    private String characterName;
    private String className;
    private int level;
    private String race;
    private String background;
    private String alignment;
    private String playerName;
    private int exp;

    //Constructors
    public HeaderScheda(String characterName, String className, int level, String race, String background,
                        String alignment, String playerName, int exp){
        this.characterName = characterName;
        this.className = className;
        this.level = level;
        this.race = race;
        this.background = background;
        this.alignment = alignment;
        this.playerName = playerName;
        this.exp = exp;
    }

    //Methods
    public String getCharacterName() {
        return characterName;
    }
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public String getRace() {
        return race;
    }
    public void setRace(String race) {
        this.race = race;
    }
    public String getBackground() {
        return background;
    }
    public void setBackground(String background) {
        this.background = background;
    }
    public String getAlignment() {
        return alignment;
    }
    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof HeaderScheda))
            return false;
        HeaderScheda headerScheda = (HeaderScheda) obj;
        return headerScheda.exp==this.exp &&
                headerScheda.level==this.level &&
                headerScheda.playerName.equals(this.playerName) &&
                headerScheda.className.equals(this.className) &&
                headerScheda.race.equals(this.race) &&
                headerScheda.alignment.equals(this.alignment) &&
                headerScheda.background.equals(this.background);
    }
    @Override
    public String toString() {
        return "Character Name: "+characterName+"\n"+
                "Class&Level: "+className+"-"+level+"\n"+
                "Race: "+race+"\n"+
                "Background: "+background+"\n"+
                "Alignment: "+alignment+"\n"+
                "Player Name: "+playerName+"\n"+
                "Experience Point: "+exp;
    }
}
