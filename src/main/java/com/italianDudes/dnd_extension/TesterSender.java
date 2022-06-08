package com.italianDudes.dnd_extension;

import com.italianDudes.dnd_extension.common.sheet.DnD_Sheet;
import com.italianDudes.dnd_extension.common.sheet.components.*;
import com.italianDudes.dnd_extension.common.sheet.pages.PageOne;
import com.italianDudes.dnd_extension.common.sheet.pages.PageTwo;
import com.italianDudes.gvedk.common.Credential;
import com.italianDudes.gvedk.common.Logger;
import com.italianDudes.gvedk.common.Peer;

import java.io.IOException;
import java.net.Socket;

public class TesterSender {

    public static void main(String[] args) throws IOException {

        Logger.init();

        Stats stats = new Stats(12,12,12,15,13,11,new ProficiencyBonus(2));
        DnD_Sheet sheet = new DnD_Sheet(new Credential("alessio","1234"),new PageOne(
                new SheetHeader("Hacker6329","Programmatore",17,"Umano","Boh","Neutrale-Neutrale","alessio",0),
                stats,new Vitals(stats,"9m","100","100",new Dice("2",5,"1"),new Dice("2",5,"1")))
        , new PageTwo(new CharacterHeader("Hacker6329","17","1.73m","80Kg","Marroni","Castani","Chiara","img/alessio.png")),null);

        Socket socket = new Socket("127.0.0.1",45800);

        Peer peer = new Peer(socket,null);

        sheet.sendSheet(peer);

        socket.close();

        Logger.close();

    }
}
