package com.italianDudes.dnd_extension;

import com.italianDudes.dnd_extension.common.sheet.DnD_Sheet;
import com.italianDudes.gvedk.common.ImageHandler;
import com.italianDudes.gvedk.common.Logger;
import com.italianDudes.gvedk.common.Peer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TesterB {

    public static void main(String[] args) throws IOException {

        Logger.init();

        ServerSocket serverSocket = new ServerSocket(45800);

        Socket socket = serverSocket.accept();

        Peer peer = new Peer(socket);

        DnD_Sheet sheet = DnD_Sheet.receiveSheet(peer);

        socket.close();

        System.out.println(sheet);

        serverSocket.close();

        ImageHandler.writeImage("img/new.png",sheet.getPageTwo().getCharacterHeader().getCharacterImage().getImage());

        Logger.close();

    }

}
