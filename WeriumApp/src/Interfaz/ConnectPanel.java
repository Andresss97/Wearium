/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interfaz;

import Pojos.Patient;
import Pojos.Physiotherapist;
import Transfer.Client;
import Visualization.Graph;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.net.Socket;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Andrés de Pereda Cru
 */
public class ConnectPanel extends javax.swing.JPanel {

    /**
     * Creates new form ConnectPanel
     */
    

    private Principal frame;
    private Physiotherapist p;
    private Patient patient;
    
    private final DefaultListModel model;
    
    public ConnectPanel(Principal frame, Physiotherapist p) {
        initComponents();
        this.frame = frame;
        this.p = p;
        this.panelIm.setBackground(Color.red);
        this.model = new DefaultListModel();
        this.listPatients.setModel(model);
        this.updateList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        connectButton = new javax.swing.JButton();
        ip = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPatients = new javax.swing.JList<>();
        labelPatients = new javax.swing.JLabel();
        labelConnection = new javax.swing.JLabel();
        panelIm = new javax.swing.JPanel();
        registerPatient = new javax.swing.JButton();

        setBackground(java.awt.Color.white);

        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        jLabel1.setForeground(java.awt.Color.black);
        jLabel1.setText("IP:");

        listPatients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listPatientsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listPatients);

        labelPatients.setBackground(java.awt.Color.white);
        labelPatients.setForeground(java.awt.Color.black);
        labelPatients.setText("Select a patient:");

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

        registerPatient.setText("Register patient");
        registerPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPatientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(registerPatient)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelConnection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelPatients, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelIm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ip, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelIm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(labelConnection)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(registerPatient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPatients)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(connectButton)
                        .addGap(160, 160, 160))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        // TODO add your handling code here:
        if(this.patient == null) {
            return;
        }
        
        String ip = this.ip.getText();
        String welcomeMessage = "";
        Socket socket;
        try {
            socket = new Socket(ip,6000);
            Client client = new Client(socket);
            this.frame.setClient(client);
            welcomeMessage = this.frame.getClient().listenForMessage();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Wrong Ip address", "IP from server info", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, welcomeMessage, "Welcome", JOptionPane.INFORMATION_MESSAGE);

        this.frame.getContainer().removeAll();
        this.frame.getContainer().repaint();

        JPanel panel = new DataPanel(frame, this.patient, this.p);
        this.frame.getContainer().add(panel,BorderLayout.CENTER);
        panel.setVisible(true);
        this.frame.pack();
    }//GEN-LAST:event_connectButtonActionPerformed

    private void registerPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPatientActionPerformed
        // TODO add your handling code here:
        JPanel panel = new RegisterPatient(this.frame,this, this.p);
        this.frame.getContainer().removeAll();
        this.frame.getContainer().repaint();
        
        this.frame.getContainer().add(panel, BorderLayout.CENTER);
        panel.setVisible(true);
        this.frame.pack();
    }//GEN-LAST:event_registerPatientActionPerformed

    private void listPatientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listPatientsMouseClicked
        // TODO add your handling code here:
        int index = this.listPatients.locationToIndex(evt.getPoint());
        this.patient = (Patient) this.model.get(index);        
    }//GEN-LAST:event_listPatientsMouseClicked

    public int getId() {
        return this.p.getId();
    }
    
    public void updateList() {
        this.listPatients.removeAll();
        this.model.clear();
        
        if(this.p.getPatients().isEmpty()) {
            return;
        }
        
        this.model.addAll(this.p.getPatients());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectButton;
    private javax.swing.JTextField ip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelConnection;
    private javax.swing.JLabel labelPatients;
    private javax.swing.JList<String> listPatients;
    private javax.swing.JPanel panelIm;
    private javax.swing.JButton registerPatient;
    // End of variables declaration//GEN-END:variables
}
