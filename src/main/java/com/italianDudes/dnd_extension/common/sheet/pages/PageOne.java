package com.italianDudes.dnd_extension.common.sheet.pages;

import com.italianDudes.dnd_extension.DnD_Extension;
import com.italianDudes.dnd_extension.common.sheet.components.*;
import com.italianDudes.gvedk.common.DirectoryHandler;
import com.italianDudes.gvedk.common.exceptions.IO.directory.DirectoryNotFoundException;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    public static void writePageOne(PageOne pageOne, String sheetDirectoryPath) throws IOException {
        writePageOne(pageOne, new File(sheetDirectoryPath));
    }
    public static void writePageOne(PageOne pageOne, File sheetDirectory) throws IOException {

        if(!DirectoryHandler.directoryExist(sheetDirectory)){
            throw new DirectoryNotFoundException("directory "+sheetDirectory.getAbsolutePath()+" not found");
        }

        File pageOneDirectory = new File(sheetDirectory.getAbsolutePath()+"/"+ DnD_Extension.Defs.DIRNAME_PAGE_ONE);

        if(!DirectoryHandler.directoryExist(pageOneDirectory)){
            if(!pageOneDirectory.mkdir())
                throw new IOException("Can't create "+pageOneDirectory.getAbsolutePath()+" directory");
        }

        SheetHeader.writeSheetHeader(pageOne.sheetHeader, new File(pageOneDirectory.getAbsolutePath() + "/" + DnD_Extension.Defs.FILENAME_HEADER_SHEET));
        Stats.writeStats(pageOne.stats, new File(pageOneDirectory.getAbsolutePath()+"/"+ DnD_Extension.Defs.FILENAME_STATS));
        SavingThrows.writeSavingThrows(pageOne.savingThrows, new File(pageOneDirectory.getAbsolutePath()+"/"+ DnD_Extension.Defs.FILENAME_SAVING_THROWS));
        InspirationPoint.writeInspirationPoint(pageOne.inspirationPoint, new File(pageOneDirectory.getAbsolutePath()+"/"+ DnD_Extension.Defs.FILENAME_INSPIRATION_POINT));
        AbilityTree.writeAbilityTree(pageOne.abilityTree, new File(pageOneDirectory.getAbsolutePath()+"/"+ DnD_Extension.Defs.FILENAME_ABILITY_TREE));
        OtherCompetencesAndLanguages.writeOtherCompetencesAndLanguages(pageOne.otherCompetencesAndLanguages, new File(pageOneDirectory.getAbsolutePath()+"/"+ DnD_Extension.Defs.FILENAME_OTHER_PROFICIENCIES_AND_LANGUAGES));
        Vitals.writeVitals(pageOne.vitals, new File(pageOneDirectory.getAbsolutePath()+"/"+ DnD_Extension.Defs.FILENAME_VITALS));
        AttackAndSpells.writeAttackAndSpells(pageOne.attackAndSpells, new File(pageOneDirectory.getAbsolutePath()+"/"+ DnD_Extension.Defs.FILENAME_ATTACK_AND_SPELLS));
        Equipment.writeEquipment(pageOne.equipment, new File(pageOneDirectory.getAbsolutePath()+"/"+ DnD_Extension.Defs.FILENAME_EQUIPMENT));
        CharacterDescriptor.writeCharacterDescriptor(pageOne.characterDescriptor, new File(pageOneDirectory.getAbsolutePath()+"/"+ DnD_Extension.Defs.FILENAME_CHARACTER_DESCRIPTOR));
        FeaturesAndTraits.writeFeaturesAndTraits(pageOne.featuresAndTraits, new File(pageOneDirectory.getAbsolutePath()+"/"+ DnD_Extension.Defs.FILENAME_FEATURES_AND_TRAITS));

    }
    public static PageOne readPageOne(String sheetDirectoryPath) throws DirectoryNotFoundException, FileNotFoundException {
        return readPageOne(new File(sheetDirectoryPath));
    }
    public static PageOne readPageOne(File sheetDirectory) throws DirectoryNotFoundException, FileNotFoundException {

        File pageOneDirectory = new File(sheetDirectory+"/"+ DnD_Extension.Defs.DIRNAME_PAGE_ONE);

        if(!DirectoryHandler.directoryExist(pageOneDirectory))
            throw new DirectoryNotFoundException("directory "+pageOneDirectory.getAbsolutePath()+" not found");

        SheetHeader sheetHeader = SheetHeader.readSheetHeader(new File(pageOneDirectory + "/" + DnD_Extension.Defs.FILENAME_HEADER_SHEET));
        Stats stats = Stats.readStats(new File(pageOneDirectory + "/" + DnD_Extension.Defs.FILENAME_STATS));
        SavingThrows savingThrows = SavingThrows.readSavingThrows(stats, new File(pageOneDirectory + "/" + DnD_Extension.Defs.FILENAME_SAVING_THROWS));
        InspirationPoint inspirationPoint = InspirationPoint.readInspirationPoint(new File(pageOneDirectory + "/" + DnD_Extension.Defs.FILENAME_INSPIRATION_POINT));
        AbilityTree abilityTree = AbilityTree.readAbilityTree(new File(pageOneDirectory + "/" + DnD_Extension.Defs.FILENAME_ABILITY_TREE));
        OtherCompetencesAndLanguages otherCompetencesAndLanguages = OtherCompetencesAndLanguages.readOtherCompetencesAndLanguages(new File(pageOneDirectory + "/" + DnD_Extension.Defs.FILENAME_OTHER_PROFICIENCIES_AND_LANGUAGES));
        Vitals vitals = Vitals.readVitals(new File(pageOneDirectory + "/" + DnD_Extension.Defs.FILENAME_VITALS));
        AttackAndSpells attackAndSpells = AttackAndSpells.readAttackAndSpells(new File(pageOneDirectory + "/" + DnD_Extension.Defs.FILENAME_ATTACK_AND_SPELLS));
        Equipment equipment = Equipment.readEquipment(new File(pageOneDirectory + "/" + DnD_Extension.Defs.FILENAME_EQUIPMENT));
        CharacterDescriptor characterDescriptor = CharacterDescriptor.readCharacterDescriptor(new File(pageOneDirectory + "/" + DnD_Extension.Defs.FILENAME_CHARACTER_DESCRIPTOR));
        FeaturesAndTraits featuresAndTraits = FeaturesAndTraits.readFeaturesAndTraits(new File(pageOneDirectory + "/" + DnD_Extension.Defs.FILENAME_FEATURES_AND_TRAITS));

        return new PageOne(sheetHeader,stats,savingThrows,inspirationPoint,abilityTree,otherCompetencesAndLanguages,vitals,attackAndSpells,equipment,characterDescriptor,featuresAndTraits);

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
