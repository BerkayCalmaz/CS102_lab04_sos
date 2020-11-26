import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.Image;

public class SOSCanvas extends JPanel {
    SOS sosRef;

    public SOSCanvas(SOS ref){
        sosRef = ref;
        setPreferredSize( new Dimension( 400,400));
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent( g );

        // Variables.
        final int GRID_SIZE = 300; //Length of the grid
        int size;
        String[] content;
        int gridCount;
        int contentCount;

        size = sosRef.getDimension(); //game
        content = new String[size * size ];
        contentCount = 0; //x

        //setting the font
        Font font = new Font("Verdana", Font.BOLD, 17);
        g.setFont(font);

        //filling a string array to create our grid.
        for(int i = 0; i < size; i++){
            for (int k = 0; k < size; k++){
                content[contentCount] = String.valueOf(sosRef.getCellContents(k, i));
                contentCount++;
            }
        }

        gridCount = 0;
        // draws rectangles and writes the content of it in the rectangles row by row
        // gridSize / size gives the x or y length of a rectangle
        for( int x = 50; x <= GRID_SIZE; x += ( GRID_SIZE / size ) ){
            for( int y = 50; y <= GRID_SIZE; y+= ( GRID_SIZE / size ) ) {

                //making color black for grids
                g.setColor(Color.black);
                g.drawRect(x, y, ( GRID_SIZE / size ), GRID_SIZE / size);

                //making color magenta for S's and O's
                g.setColor(Color.MAGENTA);

                //Check if the content is appropriate so that there are no dots.
                if( content[gridCount].equals( "s") || content[gridCount].equals( "o")) {
                    g.drawString((content[gridCount]), x + (GRID_SIZE / size) / 2 ,
                            y + ((GRID_SIZE / size) / 2));
                }
                gridCount++;
            }
        }
    }

}
