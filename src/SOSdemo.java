import javax.swing.*;
import java.awt.*;

public class SOSdemo  {
    public static void main(String[] args) {
        int dimension = 0;
        String player1, player2;
        JFrame   frame = new JFrame("SOS game");
        SOS     game;
        SOSGUIPanel panel;

        Object[] sizes = { 4, 5, 6 };
        JComboBox comboBox = new JComboBox( sizes );
        JOptionPane.showMessageDialog(null, comboBox, "Board Size", JOptionPane.QUESTION_MESSAGE);
        int dimensionInput = (int) comboBox.getSelectedItem();
//
        player1 = JOptionPane.showInputDialog(frame , "Enter player 1 name" );
        player2 = JOptionPane.showInputDialog(frame, "Enter player 2 name" );
//
//        SOS sos = new SOS(5);
//        SOSCanvas canvas = new SOSCanvas(sos);
//        SOSGUIPanel panel = new SOSGUIPanel( sos, player1, player2);



        JLabel   lab = new JLabel("SOS game");

        // Program Code
        game   = new SOS(dimensionInput);
        panel  = new SOSGUIPanel( game, player1, player2);
        frame = new JFrame();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible( true);
    }
}
