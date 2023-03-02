/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author andre
 */
public class ClientHandler implements Runnable {

    public static ArrayList<ClientHandler> clients = new ArrayList();
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.oos = new ObjectOutputStream(this.socket.getOutputStream());
            this.ois = new ObjectInputStream(this.socket.getInputStream());
            this.clients.add(this);
        } catch (Exception ex) {

        }
    }

    public void run() {
        while (this.socket.isConnected()) {
        }
    }
}
