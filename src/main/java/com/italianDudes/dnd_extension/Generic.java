package com.italianDudes.dnd_extension;

import java.io.File;

public class Generic {

    public static void main(String[] args) {

        File f = new File("img/");

        System.out.println(f.getAbsolutePath());

    }
}
