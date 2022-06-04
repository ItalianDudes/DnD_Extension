package com.italianDudes.dnd_extension;

import com.italianDudes.dnd_extension.common.sheet.components.Ability;
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
    }

}
