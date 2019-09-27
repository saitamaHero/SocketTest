package connection;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dionicio
 */
public abstract class SocketConnection {
    private final int DEFAULT_PORT = 1234;
    private final String DEFAULT_HOST = "10.0.0.17";
    public enum Type {SERVER, CLIENT};
    private String host;
    private int port;

    private String message;
    private ServerSocket serverSocket;
    private Socket socket;
    private DataOutputStream serverOutput;
    private DataOutputStream clientOutput;
    private Type type;
    
    public SocketConnection(Type type) {
        this.port = DEFAULT_PORT;
        this.host = DEFAULT_HOST;
        this.type = type;
    }

    public SocketConnection(String host, int port, Type type) {
        this.host = host;
        this.port = port;
        this.type = type;
    }
    
    public void connect() throws IOException{
        if(Type.SERVER.equals(this.type)){
            this.serverSocket = new ServerSocket(port);
            this.socket = new Socket();
        }else if(Type.CLIENT.equals(this.type)){
            this.socket = new Socket(this.host, this.port);
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public DataOutputStream getServerOutput() {
        return serverOutput;
    }

    public void setServerOutput(DataOutputStream serverOutput) {
        this.serverOutput = serverOutput;
    }

    public DataOutputStream getClientOutput() {
        return clientOutput;
    }

    public void setClientOutput(DataOutputStream clientOutput) {
        this.clientOutput = clientOutput;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    
    
    
    
    
}
