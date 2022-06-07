package com.italianDudes.dnd_extension.common.sheet.components;

import java.io.File;

@SuppressWarnings("unused")
public abstract class SheetComponent {

    //Methods
    public SheetComponent readComponent(String sourcePath){
        return readComponent(new File(sourcePath));
    }
    public abstract SheetComponent readComponent(File sourceFile);
    public void writeComponent(String destinationPath){
        writeComponent(new File(destinationPath));
    }
    public abstract void writeComponent(File destination);

}
