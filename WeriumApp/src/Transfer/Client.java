/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transfer;

import Pojos.Measurement;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author andre
 */
public class Client {
    private Socket socket;
    private InputStream ois;
    private OutputStream oos;
    
    public Client(Socket socket) {
        this.socket = socket;
        try {
            this.oos = this.socket.getOutputStream();
            this.ois = this.socket.getInputStream();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public String listenForMessage() {
        while(this.socket.isConnected()) {
            try {
                byte[] lenBytes = new byte[100];
                Object ob = ois.read(lenBytes,0,100);
                String val = new String(lenBytes,0,100);
                
                return val;
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        return "val";
    }
    
    public String sendData(Measurement m) {
        String value =  "";
        try {
            String balls = String.valueOf(m.getNumberBalls());
            String trials = String.valueOf(m.getTrials());
            String radius = String.valueOf(m.getRadius());
            
            this.oos.write(m.getNumberBalls());
            //this.oos.write(trials.getBytes());
            
            value = this.listenForMessage();
        }
        catch(Exception ex) {
            return "error";
        }
        
        return value; 
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public InputStream getOis() {
        return ois;
    }

    public void setOis(InputStream ois) {
        this.ois = ois;
    }

    public OutputStream getOos() {
        return oos;
    }

    public void setOos(OutputStream oos) {
        this.oos = oos;
    }
    
    
}
