package maze.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import maze.logic.*;

/**
 * MazeGUI.java - Uma classe que agrupa as funcoes necessarias a criacao das toolbars e dos respectivos items de menu
 * 
 * @author Admin
 *
 * @see JFrame
 */

public class MazeGUI extends JFrame implements ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8333028801292213968L;
	MazePainel drawing;
    Jogo jogo_created;
    JMenuBar menubar;	
	
	JMenu jogo;
	
	JMenu ferr;
	
	JMenuItem novojogo;
	
	JMenuItem sair;
	
	JMenuItem opc;

    

    //==========================================================constructor
    public MazeGUI() {
    	jogo_created = new Jogo(10);
        drawing = new MazePainel(jogo_created);
        this.getContentPane().setLayout(new BorderLayout());
        JLabel instructions = new JLabel("<html><ul><li>Usa as setas para moveres o herói.</li></html>");
        this.getContentPane().add(instructions, BorderLayout.NORTH);
        this.getContentPane().add(drawing, BorderLayout.CENTER);
        
        // MENU DE JOGO
        menubar = new JMenuBar();	
		
		jogo = new JMenu("Jogo");
		
		ferr = new JMenu("Ferramentas");
		
		novojogo = new JMenuItem("Novo Jogo");
		
		sair = new JMenuItem("Sair");
		
		opc = new JMenuItem("Opções");
		
		jogo.add(novojogo);
		jogo.add(sair);
		
		ferr.add(opc);
		
		menubar.add(jogo);
		menubar.add(ferr);
		
		setJMenuBar(menubar);
		
		// NOVO JOGO
		novojogo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
            	
            	Control_NewGame();	
            }
        });
		
        //AVISO DE SAÍDA
		sair.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
		// OPCOES
		 
		drawing.setLayout(new BorderLayout());
		
		opc.addActionListener(new ActionListener() {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent event) {
			Opcoes opcoes = new Opcoes();
			opcoes.show();
		  }
		});

        setTitle("Opções");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ///////////////////////////////////
       	//////////////////////////////
        this.setTitle("Labirinto");
        this.pack();
               
        drawing.requestFocus();      // Give the panel focus.
    }
    
    public void Control_NewGame()
    {
    	
    	
    	
        this.getContentPane().removeAll();
        this.getContentPane().invalidate();
        jogo_created = new Jogo(10);
        drawing = new MazePainel(jogo_created);
        
        this.getContentPane().setLayout(new BorderLayout());
        JLabel instructions = new JLabel("<html><ul><li>Usa as setas para moveres o herói.</li></html>");
        
        this.getContentPane().add(instructions, BorderLayout.NORTH);
        
        
        // MENU DE JOGO
        menubar = new JMenuBar();	
		
		jogo = new JMenu("Jogo");
		
		ferr = new JMenu("Ferramentas");
		
		novojogo = new JMenuItem("Novo Jogo");
		
		sair = new JMenuItem("Sair");
		
		opc = new JMenuItem("Opções");
		
		jogo.add(novojogo);
		jogo.add(sair);
		
		ferr.add(opc);
		
		menubar.add(jogo);
		menubar.add(ferr);
		
		setJMenuBar(menubar);
		
		// NOVO JOGO
		novojogo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
            	
            	Control_NewGame();	
            }
        });
		
        //AVISO DE SAÍDA
		sair.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
		// OPCOES
		 
		drawing.setLayout(new BorderLayout());
		
		opc.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			Opcoes opcoes = new Opcoes();
			opcoes.show();
		  }
		});

        
		this.getContentPane().add(drawing, BorderLayout.CENTER);
       this.getContentPane().validate();
       this.pack();
               
        drawing.requestFocus();
        
        
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}