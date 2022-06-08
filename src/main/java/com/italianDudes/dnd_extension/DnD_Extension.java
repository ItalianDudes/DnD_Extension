package com.italianDudes.dnd_extension;

import com.italianDudes.dnd_extension.server.Server;
import com.italianDudes.gvedk.common.State;

public class DnD_Extension {

    public static State launch(String[] args){

        Server.runServer();

        System.out.println("Hello World!");
        return new State(0);

    }

    //Constants Class
    public static final class Defs {
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

        //Filename Constants
        public static final String FILENAME_HEADER_SHEET = DIRNAME_PAGE_ONE+"headerSheet.txt";
        public static final String FILENAME_STATS = DIRNAME_PAGE_ONE+"stats.txt";
        public static final String FILENAME_ABILITY_TREE = DIRNAME_PAGE_ONE+"abilityTree.txt";
        public static final String FILENAME_INSPIRATION_POINT = DIRNAME_PAGE_ONE+"inspirationPoint.txt";
        public static final String FILENAME_SAVING_THROWS = DIRNAME_PAGE_ONE+"savingThrows.txt";
        public static final String FILENAME_OTHER_PROFICIENCIES_AND_LANGUAGES = DIRNAME_PAGE_ONE+"otherProfsAndLangs.txt";
        public static final String FILENAME_VITALS = DIRNAME_PAGE_ONE+"vitals.txt";
        public static final String FILENAME_EQUIPMENT = DIRNAME_PAGE_ONE+"equipment.txt";
        public static final String FILENAME_CHARACTER_DESCRIPTOR = DIRNAME_PAGE_ONE+"characterDescriptor.txt";
        public static final String FILENAME_FEATURES_AND_TRAITS = DIRNAME_PAGE_ONE+"featuresAndTraits.txt";
        public static final String FILENAME_CHARACTER_HEADER = DIRNAME_PAGE_TWO+"characterHeader.txt";
        public static final String FILENAME_ALLIES_AND_ORGANIZATIONS = DIRNAME_PAGE_TWO+"alliesAndOrganizations.txt";
        public static final String FILENAME_CHARACTER_BACKSTORY = DIRNAME_PAGE_TWO+"characterBackstory.txt";
        public static final String FILENAME_TREASURE = DIRNAME_PAGE_TWO+"treasure.txt";
        public static final String FILENAME_SPELL_HEADER = DIRNAME_PAGE_THREE+"spellHeader.txt";
        public static final String FILENAME_GENERIC_SPELL_REGION = DIRNAME_PAGE_THREE+"_region.txt"; //Add <integer> before filename for the right region

    }

}
