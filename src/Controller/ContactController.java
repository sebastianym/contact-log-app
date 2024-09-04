/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Contact;
import View.Form;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebas
 */
public class ContactController implements ActionListener {
    // Attributes
    private Form view;
    private Contact contact;

    // Constructors
    public ContactController() {
    }

    public ContactController(Form view) {
        this.view = view;
        this.view.getjButton1().addActionListener(this);
    }

    // Method to run the application
    public void run() {
        this.view.setTitle("Application for contact registration");
        this.view.setLocationRelativeTo(null);
    }

    // Method to handle the action performed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.view.getjButton1()) {
            String firstName = this.view.getFirstName().getText();
            String lastName = this.view.getLastName().getText();
            String phoneNumber = this.view.getPhoneNumber().getText();
            String description = this.view.getDescription().getText();
            contact = new Contact(firstName, lastName, phoneNumber, description);
            Archive archive = new Archive(contact);
            try {
                archive.write();
                JOptionPane.showMessageDialog(null,
                        "The contact has been saved to the text file. Thank you for using the application!");
            } catch (IOException ex) {
                Logger.getLogger(ContactController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);
        }
    }

    // Getters and setters
    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

}
