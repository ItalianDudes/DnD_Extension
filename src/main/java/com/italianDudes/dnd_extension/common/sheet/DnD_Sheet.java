package com.italianDudes.dnd_extension.common.sheet;

import com.italianDudes.dnd_extension.common.sheet.pages.PageOne;
import com.italianDudes.dnd_extension.common.sheet.pages.PageThree;
import com.italianDudes.dnd_extension.common.sheet.pages.PageTwo;
import com.italianDudes.gvedk.common.*;
import com.italianDudes.gvedk.common.exceptions.IO.directory.DirectoryNotFoundException;
import com.italianDudes.gvedk.common.exceptions.IO.socket.OutputStreamWriteException;
import com.italianDudes.gvedk.common.exceptions.IO.socket.SpecializedStreamInstancingException;
import com.italianDudes.gvedk.common.exceptions.IO.socket.ValidatingStreamException;
import org.jetbrains.annotations.NotNull;

import java.io.*;

@SuppressWarnings("unused")
public class DnD_Sheet extends Sheet implements Serializable {

    //Attributes
    private final PageOne pageOne;
    private final PageTwo pageTwo;
    private final PageThree pageThree;

    //Constructors
    public DnD_Sheet(@NotNull Credential credential, @NotNull PageOne pageOne, @NotNull PageTwo pageTwo, @NotNull PageThree pageThree){
        super(credential);
        this.pageOne = pageOne;
        this.pageTwo = pageTwo;
        this.pageThree = pageThree;
    }

    //Methods
    public PageOne getPageOne(){
        return pageOne;
    }
    public PageTwo getPageTwo(){
        return pageTwo;
    }
    public PageThree getPageThree(){
        return pageThree;
    }
    public static DnD_Sheet readSheet(Credential credential, String sheetDirectory) throws DirectoryNotFoundException, FileNotFoundException {
        return new DnD_Sheet(
                credential,
                PageOne.readPageOne(sheetDirectory),
                PageTwo.readPageTwo(sheetDirectory),
                PageThree.readPageThree(sheetDirectory)
        );
    }
    public static void writeSheet(DnD_Sheet sheet, String sheetDirectoryPath) throws IOException {
        writeSheet(sheet, new File(sheetDirectoryPath));
    }
    public static void writeSheet(DnD_Sheet sheet, File sheetDirectory) throws IOException {

        if(!DirectoryHandler.directoryExist(sheetDirectory))
            throw new DirectoryNotFoundException("directory "+sheetDirectory.getAbsolutePath()+" not found");

        PageOne.writePageOne(sheet.pageOne, sheetDirectory);
        PageTwo.writePageTwo(sheet.pageTwo, sheetDirectory);
        PageThree.writePageThree(sheet.pageThree, sheetDirectory);

    }
    public static DnD_Sheet receiveSheet(Peer peer) {
        try {
            DnD_Sheet sheet = (DnD_Sheet) Serializer.receiveObject(peer);
            boolean waitForCharacterImage = Serializer.receiveBoolean(peer);
            if(waitForCharacterImage) {
                sheet.pageTwo.getCharacterHeader().setCharacterImage(Serializer.receiveImage(peer));
            }
            boolean waitForSymbolImage = Serializer.receiveBoolean(peer);
            if(waitForSymbolImage) {
                sheet.pageTwo.getAlliesAndOrganizations().getCharacterSymbol().setSymbolImage(Serializer.receiveImage(peer));
            }
            return sheet;
        }catch (IOException | ClassNotFoundException e){
            Logger.log(e);
            return null;
        }
    }
    public static void sendSheet(Peer peer, DnD_Sheet sheet) {
        try {
            Serializer.sendObject(peer,sheet);
            try {
                if (sheet.pageTwo.getCharacterHeader().getCharacterImage().getImage() != null) {
                    Serializer.sendBoolean(peer, true);
                    Serializer.sendImage(peer, sheet.pageTwo.getCharacterHeader().getCharacterImage());
                } else {
                    System.out.println(false);
                    Serializer.sendBoolean(peer, false);
                }
            }catch (NullPointerException nullPointerException){
                Logger.log(nullPointerException);
                System.out.println(false);
                Serializer.sendBoolean(peer,false);
            }

            try {
                if (sheet.pageTwo.getAlliesAndOrganizations().getCharacterSymbol().getSymbolImage().getImage() != null) {
                    Serializer.sendBoolean(peer, true);
                    Serializer.sendImage(peer, sheet.pageTwo.getCharacterHeader().getCharacterImage());
                } else {
                    System.out.println(false);
                    Serializer.sendBoolean(peer, false);
                }
            }catch (NullPointerException nullPointerException){
                Logger.log(nullPointerException);
                System.out.println(false);
                Serializer.sendBoolean(peer,false);
            }

        } catch (OutputStreamWriteException | SpecializedStreamInstancingException | ValidatingStreamException |
                 NotSerializableException e) {
            Logger.log(e);
        }
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof DnD_Sheet))
            return false;
        DnD_Sheet dnD_sheet = (DnD_Sheet) obj;
        return dnD_sheet.pageOne.equals(this.pageOne) && dnD_sheet.pageTwo.equals(this.pageTwo) && dnD_sheet.pageThree.equals(this.pageThree);
    }
    @Override
    public String toString() {
        return "PAGE ONE:\n"+pageOne+"\n"+"PAGE TWO:\n"+pageTwo+"\n"+"PAGE THREE:\n"+pageThree;
    }
}
