/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;
import Model.Contact;
import javax.swing.JFileChooser;

/**
 *
 * @author Sebas
 */
public class Archive {

    // We define the attributes to write to the file
    private int index = 0;
    private Contact contact;

    // Constructor that accepts a Contact object
    public Archive(Contact contact) {
        this.contact = contact;
    }

    // Method that is responsible for writing to the file
    public void write() throws FileNotFoundException, IOException {
        // Allows us to select the location of our file
        JOptionPane.showMessageDialog(null,
                "A continuación seleccione el archivo txt en el que desea guardar la infomación");
        JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
        fc.showOpenDialog(fc);
        String archivo1 = fc.getSelectedFile().getAbsolutePath();
        // Exception handling when writing to file
        try (RandomAccessFile archivo = new RandomAccessFile(archivo1, "rw")) {

            if (archivo.length() != 0) {
                archivo.seek(archivo.length());
            }

            StringBuilder sb_firstName = new StringBuilder(contact.getFirstName());
            sb_firstName.setLength(25);
            archivo.writeChars(sb_firstName.toString());

            StringBuilder sb_lastName = new StringBuilder(contact.getLastName());
            sb_lastName.setLength(25);
            archivo.writeChars(sb_lastName.toString());

            StringBuilder sb_phoneNumber = new StringBuilder(contact.getPhoneNumber());
            sb_phoneNumber.setLength(20);
            archivo.writeChars(sb_phoneNumber.toString());

            StringBuffer sb_description = new StringBuffer(contact.getDescription());
            sb_description.setLength(25);
            archivo.writeChars(sb_description + "\r");
            index++;

            archivo.writeChars(" -------------------------------------------------- \r");

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not found: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "I/O error: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
