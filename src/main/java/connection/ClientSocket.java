/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dionicio
 */
public class ClientSocket extends SocketConnection{

    public ClientSocket() {
        super(Type.CLIENT);
    }
    
    public void startClient(){
        try {
            connect();
            
            Socket socket = getSocket();
            DataOutputStream serverStream = new DataOutputStream(socket.getOutputStream());
            
            
            for (int i = 0; i < 2; i++) {
                serverStream.writeUTF("Este es el mensaje #"+(i+1) + "\n");
            }
            
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
