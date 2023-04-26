/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interfaz;

import Pojos.Measurement;
import Visualization.Graph;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Andrés de Pereda Cru
 */
public class DataPanel extends javax.swing.JPanel {

    /**
     * Creates new form ConnectPanel
     */
    

    private Principal frame;
    public DataPanel(Principal frame) {
        initComponents();
        this.frame = frame;
        this.panelIm.setBackground(Color.green);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelConnection = new javax.swing.JLabel();
        panelIm = new javax.swing.JPanel();
        globes = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        sendButton = new javax.swing.JButton();

        setBackground(java.awt.Color.white);

        labelConnection.setForeground(java.awt.Color.black);
        labelConnection.setText("Connection to Oculus:");

        javax.swing.GroupLayout panelImLayout = new javax.swing.GroupLayout(panelIm);
        panelIm.setLayout(panelImLayout);
        panelImLayout.setHorizontalGroup(
            panelImLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        panelImLayout.setVerticalGroup(
            panelImLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jLabel2.setForeground(java.awt.Color.black);
        jLabel2.setText("Number of globes:");

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(labelConnection)
                            .addGap(6, 6, 6)
                            .addComponent(panelIm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(123, 123, 123)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(globes, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelIm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelConnection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(127, 127, 127)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(globes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(sendButton)
                .addGap(62, 62, 62))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        // TODO add your handling code here:
        Measurement m = new Measurement();
        m.setNumberBalls(Integer.parseInt(this.globes.getText()));

        this.frame.getClient().sendData(m);
        
        String times = this.frame.getClient().listenForMessage();
        String ids = this.frame.getClient().listenForMessage();
        
        ArrayList<Float> t = m.convertStringIntoFloatArray(times);
        ArrayList<Float> i = m.convertStringIntoFloatArray(ids);
        
        System.out.println(t);
        System.out.println(i);
        
        m.setTimes(times);
        m.setIds(ids);
        
        Graph g = new Graph();
        g.createGraph(t, i);
    }//GEN-LAST:event_sendButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField globes;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelConnection;
    private javax.swing.JPanel panelIm;
    private javax.swing.JButton sendButton;
    // End of variables declaration//GEN-END:variables
}
