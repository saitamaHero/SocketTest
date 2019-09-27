/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketsTest;

import connection.ServerSocket;



/**
 *
 * @author Dionicio
 */
public class MainServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = new ServerSocket();
        
        System.out.println("Iniciando el servidor");
        serverSocket.startServer();
    }
}
