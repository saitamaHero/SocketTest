/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dionicio
 */
public class ServerSocket extends SocketConnection{

    public ServerSocket() {
        super(Type.SERVER);
    }
    
    public void startServer(){
        try {
            this.connect();
            
            System.out.println("Esperando...");
            
            java.net.ServerSocket serverSocket = getServerSocket();
            
            setSocket(serverSocket.accept());
            
            System.out.println("Cliente en línea");
            
            DataOutputStream clientOutput = new DataOutputStream(getSocket().getOutputStream());
            
            clientOutput.writeUTF("Peticion recibida y aceptada");
            
            BufferedReader input = new BufferedReader(new InputStreamReader(getSocket().getInputStream()));
            
            String message = "";
            
            System.out.println(getSocket().getInetAddress().getCanonicalHostName());
            
            while((message = input.readLine()) != null){
                System.out.println(message);
            }
            
            System.out.println("Fin de la conexión");
            
            serverSocket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ServerSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
