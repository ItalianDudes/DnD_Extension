package com.italianDudes.dnd_extension.common.sheet;

import com.italianDudes.dnd_extension.common.sheet.pages.PageOne;
import com.italianDudes.dnd_extension.common.sheet.pages.PageThree;
import com.italianDudes.dnd_extension.common.sheet.pages.PageTwo;
import com.italianDudes.gvedk.common.*;
import com.italianDudes.gvedk.common.exceptions.socketIO.OutputStreamWriteException;
import com.italianDudes.gvedk.common.exceptions.socketIO.SpecializedStreamInstancingException;
import com.italianDudes.gvedk.common.exceptions.socketIO.ValidatingStreamException;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.NotSerializableException;

public class DnD_Sheet extends Sheet {

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
    @Override
    public Sheet readSheet(String s) {
        //TODO: readSheet()
        return null;
    }
    @Override
    public void writeSheet(String s) {
        //TODO: writeSheet()
    }
    @Override
    public Sheet receiveSheet(Peer peer) {
        try {
            return (Sheet) Serializer.receiveObject(peer);
        }catch (IOException | ClassNotFoundException e){
            Logger.log(e);
            return null;
        }
    }
    @Override
    public void sendSheet(Peer peer) {
        try {
            Serializer.sendObject(peer,this);
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
