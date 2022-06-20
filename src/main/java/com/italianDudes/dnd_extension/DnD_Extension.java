package com.italianDudes.dnd_extension;

import com.italianDudes.gvedk.common.Extension;
import com.italianDudes.gvedk.common.State;
import com.italianDudes.gvedk.common.exceptions.IO.InsufficientPrivilegesException;

import javax.swing.*;
import java.io.File;

public class DnD_Extension extends Extension {

    //Constructors
    public DnD_Extension(File extensionDirectory) throws InsufficientPrivilegesException {
        super(extensionDirectory);
    }

    //Methods
    @Override
    public State start() {

        JFrame extFrame = new JFrame(Defs.EXTENSION_NAME);
            extFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            extFrame.setLocationRelativeTo(null);
            JPanel panel = new JPanel();
                JLabel label = new JLabel(super.getExtensionDirectory().getAbsolutePath());
                panel.add(label);
            extFrame.add(panel);
            extFrame.setVisible(true);

        return new State(0);
    }

    //Constants Class
    @SuppressWarnings("unused")
    public static final class Defs {

        //Miscellaneous
        public static final String EXTENSION_NAME = "D&D";

        //Directories
        public static final String USERS_DIR = "users/";

        //Stats
        public static final int NUM_STATS = 6;
            public static final Integer STRENGTH_POS = 0;
            public static final Integer DEXTERITY_POS = 1;
            public static final Integer CONSTITUTION_POS = 2;
            public static final Integer INTELLIGENCE_POS = 3;
            public static final Integer WISDOM_POS = 4;
            public static final Integer CHARISMA_POS = 5;

        public static final int NUM_ABILITIES = 18;
            //Position, Root Ability Position
            public static final int[] ABILITIES_ROOT_BY_POS = {1,4,3,0,5,3,4,5,3,4,3,4,5,5,3,1,1,4};
            public static final Integer ACROBATICS_POS = 0;
            public static final Integer ANIMAL_HANDLING_POS = 1;
            public static final Integer ARCANA_POS = 2;
            public static final Integer ATHLETICS_POS = 3;
            public static final Integer DECEPTION_POS = 4;
            public static final Integer HISTORY_POS = 5;
            public static final Integer INSIGHT_POS = 6;
            public static final Integer INTIMIDATION_POS = 7;
            public static final Integer INVESTIGATION_POS = 8;
            public static final Integer MEDICINE_POS = 9;
            public static final Integer NATURE_POS = 10;
            public static final Integer PERCEPTION_POS = 11;
            public static final Integer PERFORMANCE_POS = 12;
            public static final Integer PERSUASION_POS = 13;
            public static final Integer RELIGION_POS = 14;
            public static final Integer SLEIGHT_OF_HAND_POS = 15;
            public static final Integer STEALTH_POS = 16;
            public static final Integer SURVIVAL_POS = 17;

        public static final int NUM_TS_AGAINST_DEATH = 3;

        public static final int NUM_SPELL_REGIONS = 1+9;

        //Directory Sheet Constants
        public static final String DIRNAME_PAGE_ONE = "page_one/";
        public static final String DIRNAME_PAGE_TWO = "page_two/";
        public static final String DIRNAME_PAGE_THREE = "page_three/";

        //ID Bounds
        public static final int SHEET_ID_MIN = 100000000; //Inclusive
        public static final int SHEET_ID_MAX = 1000000000; //Exclusive

        //Filename Constants
        public static final String FILENAME_SHEET_ID = "sheetID.txt";
        public static final String FILENAME_HEADER_SHEET = "headerSheet.txt";
        public static final String FILENAME_STATS = "stats.txt";
        public static final String FILENAME_ABILITY_TREE = "abilityTree.txt";
        public static final String FILENAME_INSPIRATION_POINT = "inspirationPoint.txt";
        public static final String FILENAME_SAVING_THROWS = "savingThrows.txt";
        public static final String FILENAME_OTHER_PROFICIENCIES_AND_LANGUAGES = "otherProfsAndLangs.txt";
        public static final String FILENAME_VITALS = "vitals.txt";
        public static final String FILENAME_ATTACK_AND_SPELLS = "attackAndSpells.txt";
        public static final String FILENAME_EQUIPMENT = "equipment.txt";
        public static final String FILENAME_CHARACTER_DESCRIPTOR = "characterDescriptor.txt";
        public static final String FILENAME_FEATURES_AND_TRAITS = "featuresAndTraits.txt";
        public static final String FILENAME_CHARACTER_HEADER = "characterHeader.txt";
        public static final String FILENAME_CHARACTER_IMAGE_NO_EXT = "characterImage"; //No Extension
        public static final String FILENAME_ALLIES_AND_ORGANIZATIONS = "alliesAndOrganizations.txt";
        public static final String FILENAME_SYMBOL_NAME = "symbolName.txt";
        public static final String FILENAME_SYMBOL_IMAGE_NO_EXT = "symbolImage"; //No Extension
        public static final String FILENAME_CHARACTER_BACKSTORY = "characterBackstory.txt";
        public static final String FILENAME_TREASURE = "treasure.txt";
        public static final String FILENAME_SPELL_HEADER = "spellHeader.txt";
        public static final String FILENAME_GENERIC_SPELL_REGION = "_region.txt"; //Add <integer> before filename for the right region

    }

}
