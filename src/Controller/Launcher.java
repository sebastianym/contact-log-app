/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

import View.Form;

/**
 *
 * @author Sebas
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // We instantiate our view and controller
        Form view = new Form();
        ContactController control = new ContactController(view);
        control.run();
        // We make the view visible
        view.setVisible(true);
    }

}
