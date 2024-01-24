package main.java.it.unibo.exceptions.fakenetwork.api;

public class NetworkException extends IOException{
    
    public NetworkException(){
        super("Network error: no response");
    }

    public NetworkException(final String message){
        super("Network error while sending message: " + Objects.requireNonNull(message));
    }
}
