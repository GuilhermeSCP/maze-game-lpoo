package maze.gui;
import javax.swing.*;

/**
 * MazePrincipal.java - A classe que inclui a função main(), ou seja a que corre o jogo propriamente dito
 * 
 * @author Admin
 *
 * @see JFrame
 */
public class MazePrincipal extends JFrame
{
    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -6160589561625094120L;

	public static void main(String[] args) {
    	
    	
    	
        JFrame window = new MazeGUI();
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}