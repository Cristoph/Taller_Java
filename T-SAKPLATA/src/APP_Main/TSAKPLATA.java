/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APP_Main;

import View.MainJFrame;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TSAKPLATA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // add test data

        // Load Main View ... Start
        
        //———–Look and Feel Handler————-
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());             
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.err.println("ERROR: Look and feel!");
        }
        //———–Look and Feel————- 
        
        MainJFrame mainView = new MainJFrame();
        mainView.getContentPane().setBackground(Color.WHITE);
        mainView.setTitle("Banco T-SAKPLATA");
               
        mainView.setVisible(true);
        

    }

}
