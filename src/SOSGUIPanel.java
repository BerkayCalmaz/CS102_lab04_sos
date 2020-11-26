import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SOSGUIPanel extends JPanel {
    SOS sosRef;
    JPanel canvas;
    JLabel player1Name;
    JLabel player2Name;
    JRadioButton sButton;
    JRadioButton oButton;
    ButtonGroup group;
    String p1, p2;
    int p1Score;
    int p2Score;
    final int GRID_SIZE = 300;

    public SOSGUIPanel( SOS sos, String p1, String p2){
        sosRef = sos;
        this.p1 = p1;
        this.p2 = p2;
        this.setLayout( new FlowLayout() );
        canvas = new SOSCanvas(sosRef);
        add(canvas);
        MouseListener listener = new MyMouseListener();
        canvas.addMouseListener(listener);
        createComponents();
        setPreferredSize( new Dimension( 420, 450));
    }

    public void createComponents(){
        p1Score = sosRef.getPlayerScore1();
        p2Score= sosRef.getPlayerScore2();
        player1Name = new JLabel( p1 + ": " + p1Score );
        player2Name = new JLabel( p2 + ": " + p2Score );
        player1Name.setOpaque(true);
        player2Name.setOpaque(true);
        sButton = new JRadioButton( "S");
        oButton = new JRadioButton( "O");
        group = new ButtonGroup();

        group.add(sButton);
        group.add(oButton);

        this.add(player1Name);
        this.add(sButton);
        this.add(oButton);
        this.add(player2Name);

        //listeners


    }

    class MyMouseListener extends MouseAdapter
    {
        public void mousePressed(MouseEvent event) {
            Point point = event.getPoint();

            int row =  point.y / (( 300 / sosRef.getDimension()) + 1);
            int col =  point.x / (( 300 / sosRef.getDimension()) + 1);

            //set which letter is going to be played.
            if( sButton.isSelected()) {
                sosRef.play('s', row, col);
            }
            else{
                sosRef.play('o', row, col);
            }

            //update the scores
            p1Score = sosRef.getPlayerScore1();
            player1Name.setText(p1 + ": " + p1Score );
            p2Score = sosRef.getPlayerScore2();
            player2Name.setText(p2 + ": " + p2Score );

            //Change label colors according to turn
            if( sosRef.getTurn() == 1 ){
                player2Name.setBackground( null);
                player1Name.setBackground( Color.cyan);
            }
            else{
                player1Name.setBackground( null);
                player2Name.setBackground( Color.pink);
            }

            canvas.repaint();
            // check if the game is over
            if(sosRef.isGameOver()){
                if( p1Score == p2Score )
                    JOptionPane.showMessageDialog(canvas,"It's a draw!.");
                else if( p1Score > p2Score)
                    JOptionPane.showMessageDialog(canvas,( p1 + " is the winner!"));
                else
                    JOptionPane.showMessageDialog(canvas,( p2 + " is the winner!"));

            }
        }
    }

}

