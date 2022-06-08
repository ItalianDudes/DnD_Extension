package com.italianDudes.dnd_extension.common.sheet.pages;

import com.italianDudes.dnd_extension.common.sheet.components.*;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@SuppressWarnings("unused")
public class PageOne implements Serializable {

    //Attributes
    private SheetHeader sheetHeader;
    private Stats stats;
    private SavingThrows savingThrows;
    private InspirationPoint inspirationPoint;
    private AbilityTree abilityTree;
    private OtherCompetencesAndLanguages otherCompetencesAndLanguages;
    private Vitals vitals;
    private AttackAndSpells attackAndSpells;
    private Equipment equipment;
    private CharacterDescriptor characterDescriptor;
    private FeaturesAndTraits featuresAndTraits;

    //Constructors
    public PageOne(@NotNull SheetHeader sheetHeader, @NotNull Stats stats, SavingThrows savingThrows, InspirationPoint inspirationPoint,
                   AbilityTree abilityTree, OtherCompetencesAndLanguages otherCompetencesAndLanguages,
                   @NotNull Vitals vitals, AttackAndSpells attackAndSpells, Equipment equipment, CharacterDescriptor characterDescriptor,
                   FeaturesAndTraits featuresAndTraits){
        this.sheetHeader = sheetHeader;
        this.stats = stats;
        if(savingThrows==null)
            this.savingThrows = new SavingThrows(this.stats);
        else
            this.savingThrows = savingThrows;
        if(inspirationPoint==null)
            this.inspirationPoint = new InspirationPoint();
        else
            this.inspirationPoint = inspirationPoint;
        if(abilityTree==null)
            this.abilityTree = new AbilityTree(this.stats);
        else
            this.abilityTree = abilityTree;
        if(otherCompetencesAndLanguages==null)
            this.otherCompetencesAndLanguages = new OtherCompetencesAndLanguages();
        else
            this.otherCompetencesAndLanguages = otherCompetencesAndLanguages;
        this.vitals = vitals;
        if(attackAndSpells==null)
            this.attackAndSpells = new AttackAndSpells();
        else
            this.attackAndSpells = attackAndSpells;
        if(equipment==null)
            this.equipment = new Equipment();
        else
            this.equipment = equipment;
        if(characterDescriptor==null)
            this.characterDescriptor = new CharacterDescriptor();
        else
            this.characterDescriptor = characterDescriptor;
        if(featuresAndTraits==null)
            this.featuresAndTraits = new FeaturesAndTraits();
        else
            this.featuresAndTraits = featuresAndTraits;
    }
    public PageOne(@NotNull SheetHeader sheetHeader, @NotNull Stats stats, @NotNull Vitals vitals){
        this(sheetHeader,stats,null,null,null,null,vitals,null,null,null,null);
    }

    //Methods
    public SheetHeader getSheetHeader() {
        return sheetHeader;
    }
    public void setSheetHeader(SheetHeader sheetHeader) {
        this.sheetHeader = sheetHeader;
    }
    public Stats getStats() {
        return stats;
    }
    public void setStats(Stats stats) {
        this.stats = stats;
    }
    public SavingThrows getSavingThrows() {
        return savingThrows;
    }
    public void setSavingThrows(SavingThrows savingThrows) {
        this.savingThrows = savingThrows;
    }
    public InspirationPoint getInspirationPoint() {
        return inspirationPoint;
    }
    public void setInspirationPoint(InspirationPoint inspirationPoint) {
        this.inspirationPoint = inspirationPoint;
    }
    public AbilityTree getAbilityTree() {
        return abilityTree;
    }
    public void setAbilityTree(AbilityTree abilityTree) {
        this.abilityTree = abilityTree;
    }
    public OtherCompetencesAndLanguages getOtherCompetencesAndLanguages() {
        return otherCompetencesAndLanguages;
    }
    public void setOtherCompetencesAndLanguages(OtherCompetencesAndLanguages otherCompetencesAndLanguages) {
        this.otherCompetencesAndLanguages = otherCompetencesAndLanguages;
    }
    public Vitals getVitals() {
        return vitals;
    }
    public void setVitals(Vitals vitals) {
        this.vitals = vitals;
    }
    public AttackAndSpells getAttackAndSpells() {
        return attackAndSpells;
    }
    public void setAttackAndSpells(AttackAndSpells attackAndSpells) {
        this.attackAndSpells = attackAndSpells;
    }
    public Equipment getEquipment() {
        return equipment;
    }
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
    public CharacterDescriptor getCharacterDescriptor() {
        return characterDescriptor;
    }
    public void setCharacterDescriptor(CharacterDescriptor characterDescriptor) {
        this.characterDescriptor = characterDescriptor;
    }
    public FeaturesAndTraits getFeaturesAndTraits() {
        return featuresAndTraits;
    }
    public void setFeaturesAndTraits(FeaturesAndTraits featuresAndTraits) {
        this.featuresAndTraits = featuresAndTraits;
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof PageOne))
            return false;
        PageOne pageOne = (PageOne) obj;
        return pageOne.sheetHeader.equals(this.sheetHeader) &&
                pageOne.stats.equals(this.stats) &&
                pageOne.savingThrows.equals(this.savingThrows) &&
                pageOne.inspirationPoint.equals(this.inspirationPoint) &&
                pageOne.abilityTree.equals(this.abilityTree) &&
                pageOne.otherCompetencesAndLanguages.equals(this.otherCompetencesAndLanguages) &&
                pageOne.vitals.equals(this.vitals) &&
                pageOne.attackAndSpells.equals(this.attackAndSpells) &&
                pageOne.equipment.equals(this.equipment) &&
                pageOne.characterDescriptor.equals(this.characterDescriptor) &&
                pageOne.featuresAndTraits.equals(this.featuresAndTraits);
    }
    @Override
    public String toString() {
        return "Sheet Header:\n"+ sheetHeader +"\n"+
                "Stats:\n"+stats+"\n"+
                "Saving Throws:\n"+savingThrows+"\n"+
                "Inspiration Points:\n"+inspirationPoint+"\n"+
                "Ability Tree:\n"+abilityTree+"\n"+
                "Other Competences and Languages:\n"+otherCompetencesAndLanguages+"\n"+
                "Vitals:\n"+vitals+"\n"+
                "Attack And Spells:\n"+attackAndSpells+"\n"+
                "Equipment:\n"+equipment+"\n"+
                "Character Descriptor:\n"+characterDescriptor+"\n"+
                "Features and Traits:\n"+featuresAndTraits;
    }
}
