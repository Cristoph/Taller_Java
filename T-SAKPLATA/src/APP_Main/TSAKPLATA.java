package APP_Main;

import Data.DBFake;
import View.MainJFrame;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TSAKPLATA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //———–Look and Feel Handler————-
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.err.println("ERROR: Look and feel!");
        }
        //———–Look and Feel————-
        //para presentar con data limpia
        DBFake.truncate_table();

        MainJFrame mainView = new MainJFrame(); // whith data
        mainView.getContentPane().setBackground(Color.WHITE);
        mainView.setLocationRelativeTo(null);
        mainView.setTitle("Banco T-SAKPLATA");
        mainView.setVisible(true);

    }

}
