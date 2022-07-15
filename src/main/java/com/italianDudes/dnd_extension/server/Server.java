package com.italianDudes.dnd_extension.server;

import com.italianDudes.gvedk.common.Logger;
import com.italianDudes.gvedk.common.State;

public final class Server {

    //Constructors
    private Server(){
        throw new UnsupportedOperationException("Can't instantiate this class!");
    }

    //Methods
    @SuppressWarnings("UnusedReturnValue")
    public static State runServer(){
        return runServer(null);
    }
    public static State runServer(String[] args){

        Logger.log("Hello World, I'm a server!");
        return new State(0);

    }

}
