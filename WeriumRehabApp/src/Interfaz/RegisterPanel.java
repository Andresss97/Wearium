/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interfaz;

import Creacion.Conector;
import Pojos.Patient;
import Pojos.Patient.GENDER;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author andre
 */
public class RegisterPanel extends javax.swing.JPanel {

    /**
     * Creates new form RegisterPanel
     */
    private Conector con;
    private JDialog dialog;
    public RegisterPanel(JDialog dialog) {
        initComponents();
        this.con = con;
        this.dialog = dialog;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderGroup = new javax.swing.ButtonGroup();
        labelName = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        labelSurname = new javax.swing.JLabel();
        surname = new javax.swing.JTextField();
        labelAge = new javax.swing.JLabel();
        age = new javax.swing.JComboBox<>();
        labelGender = new javax.swing.JLabel();
        maleButton = new javax.swing.JRadioButton();
        femaleButton = new javax.swing.JRadioButton();
        Register = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(500, 400));

        labelName.setBackground(java.awt.Color.white);
        labelName.setForeground(java.awt.Color.black);
        labelName.setText("Name:");

        name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameFocusLost(evt);
            }
        });

        labelSurname.setBackground(java.awt.Color.white);
        labelSurname.setForeground(java.awt.Color.black);
        labelSurname.setText("Surname:");

        labelAge.setBackground(java.awt.Color.white);
        labelAge.setForeground(java.awt.Color.black);
        labelAge.setText("Age:");

        age.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100" }));

        labelGender.setBackground(java.awt.Color.white);
        labelGender.setForeground(java.awt.Color.black);
        labelGender.setText("Gender:");

        genderGroup.add(maleButton);
        maleButton.setForeground(java.awt.Color.black);
        maleButton.setText("Male");

        femaleButton.setBackground(java.awt.Color.white);
        genderGroup.add(femaleButton);
        femaleButton.setForeground(java.awt.Color.black);
        femaleButton.setText("Female");

        Register.setText("Register");
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelGender)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSurname)
                            .addComponent(labelName)
                            .addComponent(labelAge))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(name)
                                .addComponent(age, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Register)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(maleButton)
                                    .addGap(12, 12, 12)
                                    .addComponent(femaleButton))))))
                .addGap(149, 149, 149))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelName)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSurname)
                    .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAge)
                    .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelGender)
                    .addComponent(maleButton)
                    .addComponent(femaleButton))
                .addGap(18, 18, 18)
                .addComponent(Register)
                .addContainerGap(106, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
        // TODO add your handling code here:

        Patient patient = new Patient();
        patient.setName(this.name.getText());
        patient.setSurname(this.surname.getText());
        Object object = this.age.getSelectedItem();
        String value = (String) object;
        int v = Integer.parseInt(value);
        patient.setAge(v);
        
        if(this.maleButton.isSelected()) {
            patient.setGender(GENDER.MALE);
        }
        else if(this.femaleButton.isSelected()) {
            patient.setGender(GENDER.FEMALE);
        }

        JOptionPane.showMessageDialog(this, "Register done");
        this.dialog.dispose();
    }//GEN-LAST:event_RegisterActionPerformed
    
    
    private void nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFocusGained

    private void nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_nameFocusLost
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Register;
    private javax.swing.JComboBox<String> age;
    private javax.swing.JRadioButton femaleButton;
    private javax.swing.ButtonGroup genderGroup;
    private javax.swing.JLabel labelAge;
    private javax.swing.JLabel labelGender;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelSurname;
    private javax.swing.JRadioButton maleButton;
    private javax.swing.JTextField name;
    private javax.swing.JTextField surname;
    // End of variables declaration//GEN-END:variables
}
