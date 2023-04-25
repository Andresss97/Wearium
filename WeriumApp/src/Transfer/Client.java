/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transfer;

import Pojos.Measurement;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author andre
 */
public class Client {
    private Socket socket;
    private DataInputStream ois;
    private DataOutputStream oos;
    
    public Client(Socket socket) {
        this.socket = socket;
        try {
            this.oos = new DataOutputStream(this.socket.getOutputStream());
            this.ois = new DataInputStream(this.socket.getInputStream());
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public String listenForMessage() {
        while(this.socket.isConnected()) {
            try {
                byte[] lenBytes = new byte[100000];
                Object ob = ois.read(lenBytes,0,100000);
                String val = new String(lenBytes,0,100000);
                
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
            this.oos.writeInt(m.getNumberBalls());            
            //value = this.listenForMessage();
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

    public DataInputStream getOis() {
        return ois;
    }

    public void setOis(DataInputStream ois) {
        this.ois = ois;
    }

    public DataOutputStream getOos() {
        return oos;
    }

    public void setOos(DataOutputStream oos) {
        this.oos = oos;
    }
    
    
}
