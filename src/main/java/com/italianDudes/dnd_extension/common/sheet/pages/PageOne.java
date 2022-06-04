package com.italianDudes.dnd_extension.common.sheet.pages;

import com.italianDudes.dnd_extension.common.sheet.components.*;
import org.jetbrains.annotations.NotNull;

public class PageOne {

    //Attributes
    private final HeaderScheda headerScheda;
    private final Stats stats;
    private final SavingThrows savingThrows;
    private final InspirationPoint inspirationPoint;
    private final AbilityTree abilityTree;
    private final OtherCompetencesAndLanguages otherCompetencesAndLanguages;
    private final Vitals vitals;
    private final AttackAndSpells attackAndSpells;
    private final Equipment equipment;
    private final CharacterDescriptor characterDescriptor;
    private final FeaturesAndTraits featuresAndTraits;

    //Constructors
    public PageOne(@NotNull HeaderScheda headerScheda,@NotNull Stats stats, SavingThrows savingThrows, InspirationPoint inspirationPoint,
                   AbilityTree abilityTree, OtherCompetencesAndLanguages otherCompetencesAndLanguages,
                   @NotNull Vitals vitals, AttackAndSpells attackAndSpells, Equipment equipment, CharacterDescriptor characterDescriptor,
                   FeaturesAndTraits featuresAndTraits){
        this.headerScheda = headerScheda;
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
    public PageOne(@NotNull HeaderScheda headerScheda, @NotNull Stats stats, @NotNull Vitals vitals){
        this(headerScheda,stats,null,null,null,null,vitals,null,null,null,null);
    }

    //Methods
    public HeaderScheda getHeaderScheda() {
        return headerScheda;
    }
    public Stats getStats() {
        return stats;
    }
    public SavingThrows getSavingThrows() {
        return savingThrows;
    }
    public InspirationPoint getInspirationPoint() {
        return inspirationPoint;
    }
    public AbilityTree getAbilityTree() {
        return abilityTree;
    }
    public OtherCompetencesAndLanguages getOtherCompetencesAndLanguages() {
        return otherCompetencesAndLanguages;
    }
    public Vitals getVitals() {
        return vitals;
    }
    public AttackAndSpells getAttackAndSpells() {
        return attackAndSpells;
    }
    public Equipment getEquipment() {
        return equipment;
    }
    public CharacterDescriptor getCharacterDescriptor() {
        return characterDescriptor;
    }
    public FeaturesAndTraits getFeaturesAndTraits() {
        return featuresAndTraits;
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof PageOne))
            return false;
        PageOne pageOne = (PageOne) obj;
        return pageOne.headerScheda.equals(this.headerScheda) &&
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
        return "Header Scheda:\n"+headerScheda+"\n"+
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
