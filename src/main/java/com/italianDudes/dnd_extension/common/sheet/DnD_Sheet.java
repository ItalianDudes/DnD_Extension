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
import java.io.Serializable;

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
    @Override
    public Sheet readSheet(String s) {
        //TODO: readSheet()
        return null;
    }
    @Override
    public void writeSheet(String s) {
        //TODO: writeSheet()
    }
    public static DnD_Sheet receiveSheet(Peer peer) {
        try {
            DnD_Sheet sheet = (DnD_Sheet) Serializer.receiveObject(peer);
            FormattedImage characterImage = null;
            FormattedImage symbolImage = null;
            boolean waitForCharacterImage = Serializer.receiveBoolean(peer);
            if(waitForCharacterImage) {
                characterImage = Serializer.receiveImage(peer);
            }
            boolean waitForSymbolImage = Serializer.receiveBoolean(peer);
            if(waitForSymbolImage) {
                symbolImage = Serializer.receiveImage(peer);
            }
            sheet.pageTwo.getCharacterHeader().setCharacterImage(characterImage);
            sheet.pageTwo.getAlliesAndOrganizations().getCharacterSymbol().setSymbolImage(symbolImage);
            return sheet;
        }catch (IOException | ClassNotFoundException e){
            Logger.log(e);
            return null;
        }
    }
    @Override
    public void sendSheet(Peer peer) {
        try {
            Serializer.sendObject(peer,this);
            if(pageTwo.getCharacterHeader().getCharacterImage().getImage()!=null) {
                Serializer.sendBoolean(peer,true);
                Serializer.sendImage(peer, pageTwo.getCharacterHeader().getCharacterImage());
            }else{
                Serializer.sendBoolean(peer,false);
            }
            if(pageTwo.getAlliesAndOrganizations().getCharacterSymbol().getSymbolImage().getImage()!=null) {
                Serializer.sendBoolean(peer,true);
                Serializer.sendImage(peer, pageTwo.getAlliesAndOrganizations().getCharacterSymbol().getSymbolImage());
            }else{
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
