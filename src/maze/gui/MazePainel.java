
package maze.gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import maze.logic.Jogo;
import maze.logic.Pecas;



/**
 * MazePainel.java - Uma classe que agrupa as funções necessarias a criacao do painel da parte gráfica do jogo
 * 
 * @author Admin
 *
 * @see JPanel
 */

class MazePainel extends JPanel implements KeyListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = -133329230889621951L;


	//===================================================== field variables
    String display = ""; // Initial string to display

    
    private Font biggerFont = new Font("sansserif", Font.PLAIN, 24);

    private Jogo jogoc;
    
    
    //========================================================= constructor
    public MazePainel(Jogo j) {
        this.setBackground(Color.white);
        this.setFont(biggerFont);
        this.setPreferredSize(new Dimension(300, 200));
        this.addKeyListener(this);  // This class has its own key listeners.
        this.setFocusable(true);  
        // Allow panel to get focus
        jogoc=j;
        

    }

    //======================================================= paintComponent
    public void paintComponent(Graphics g)
    {
    	int x,y;

    	x=20;
    	y=20;
    	super.paintComponent(g);
    	
    	
    	for(int i=0; i<jogoc.getLabirinto().length; i++)
    	{
    		for(int j=0; j<jogoc.getLabirinto().length; j++)
    		{
    			if(jogoc.getLabirinto()[i][j].isParede())
    			{
    				g.drawString("X", x, y);
    			}
    			else if(jogoc.getLabirinto()[i][j].isSaida())
    			{
    				//g.drawChars(Saida,j, 1, x, y);
    				g.drawString("S", x, y);
    			}
    			else if(i==jogoc.getHeroi().getX() && j==jogoc.getHeroi().getY())
    			{
    				//g.drawChars(Heroi,j, 1, x, y);
    				g.drawString("H", x, y);
    			}
    			else if(i==jogoc.getEspada().getX() && j==jogoc.getEspada().getY())
    			{
    				if(i==jogoc.getDragao().getX() && j==jogoc.getDragao().getY())
    				{
    					//g.drawChars(Esp_Dra,j, 1, x, y);
    					g.drawString("F", x, y);
    				}
    				else if(jogoc.getEspada().isVisivel())
    				{
    					g.drawString("E", x, y);
    				}
    			}
    			else if(i==jogoc.getDragao().getX() && j==jogoc.getDragao().getY())
    			{
    				if(jogoc.getDragao().isDormir())
    				{
    					g.drawString("d", x, y);
    				}
    				else
    				{
    					g.drawString("D", x, y);
    				}
    			}
    			
    			x+=20;
    		}
    		
    		y+=20;
    		x=20;
    	}
    }

    //==================================================== keyTyped listener
    /** This listener is called for character keys. */
    public void keyTyped(KeyEvent kevt) {
        //System.out.println("keyTyped");
        char c = kevt.getKeyChar();
        if (c == '\b') { // if this is a backspace
            if (display.length() > 0) {  // remove last character
                display = display.substring(0, display.length()-1);
            }
        } else {
            display += c;
        }
        this.repaint();
    }
    
    /** This listener is called for both character and non-character keys. */
    public void keyPressed(KeyEvent e) {
        
        if (e.isShiftDown()) {
            //speed = 10;
        } else {
            //speed = 2;
        }        
        
        //-- Process arrow "virtual" keys
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT :
            {
            	jogoc.moveHeroi(2);
            	jogoc.moveDragao();
            	break;
            }
            case KeyEvent.VK_RIGHT:
            	{
            		jogoc.moveHeroi(3);
            		jogoc.moveDragao();
            		break;
            	}
            case KeyEvent.VK_UP   :
            {
            	jogoc.moveHeroi(0);
            	jogoc.moveDragao();
        		break;
        	}
            case KeyEvent.VK_DOWN :
            {
            	jogoc.moveHeroi(1);
            	jogoc.moveDragao();
        		break;
        	}
        }
        
        //speed = 2;       // Restore speed to its default value
            
        this.repaint();  // Display the changes.
    }//endmethod keyPressed

    //------------------------------------------------- keyReleased listener
    public void keyReleased(KeyEvent ke) {}  // Ignore.
}//endclass MovingTextPanel