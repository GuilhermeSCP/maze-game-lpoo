package maze.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Opcoes.java - Uma classe que agrupa as funções necessarias a criacao do menu opcoes e suas funcionalidades
 * 
 * @author Admin
 *
 * @see JFrame
 */

public class Opcoes extends JFrame implements ActionListener {
	 
	public Opcoes(){
		iniciar();
	}

	public void iniciar(){
		final JLabel statusbar;
	    final JSpinner drags;
	    final JSpinner tam;
	    
		JPanel panel = new JPanel();
        statusbar = new JLabel("0");

        statusbar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

        panel.setLayout(null);

        int d=1;
        int n=10;

        SpinnerModel dragoes = new SpinnerNumberModel(1,d-1,d+2,1);
        SpinnerModel lab = new SpinnerNumberModel(10,n,n+20,1);

        drags = new JSpinner(dragoes);
        drags.setEditor(new JSpinner.NumberEditor(drags, "#"));
        tam = new JSpinner(lab);
        tam.setEditor(new JSpinner.NumberEditor(tam, "#"));

        drags.setBounds(190, 30, 80, 25);
        tam.setBounds(190, 60, 80, 25);

        panel.add(drags);
        panel.add(tam);
        
        // CHECKBOX
        JCheckBox chk = new JCheckBox("Dragão pode adormecer", false);
        chk.setBounds(110, 90, 170, 25);
        chk.addActionListener(this);
        add(chk);
        
        JLabel ndragoes;
        ndragoes = new JLabel("Número de dragões no jogo: ");
        ndragoes.setBounds(20, 30, 200, 25);
        panel.add(ndragoes);
        
        JLabel nlab;
        nlab = new JLabel("Número de linhas do labirinto: ");
        nlab.setBounds(20, 60, 200, 25);
        panel.add(nlab);
        
        JButton ok;
        ok = new JButton("OK");
        ok.setBounds(80, 120, 70, 30);
        ok.addActionListener(new OKButton());
        panel.add(ok);
        
        JButton cancel;
        cancel = new JButton("Cancelar");
        cancel.setBounds(160, 120, 100, 30);
        cancel.addActionListener(new CancelButton());
        panel.add(cancel);
        
        add(panel);
        
        setTitle("Opções");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
     
	}
        // LISTENER DA CHECKBOX
        public void actionPerformed(ActionEvent e) {

            JCheckBox source = (JCheckBox) e.getSource();
            boolean state = source.isSelected();

            /*if (state) {
                this.setTitle("JCheckbox example");
                
            } else {
                this.setTitle("");
            }*/
    }
}

/**
 * OKButton.java - Uma classe que guarda as opcoes do botão OK
 * 
 * @author Admin
 *
 * @see JFrame
 */


class OKButton implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        JButton o = (JButton) e.getSource();
        String label = o.getText();
        //statusbar.setText(" " + label + " button clicked");
    }
}

/**
 * CancelButton.java - Uma classe que guarda as opcoes do botão Cancel
 * 
 * @author Admin
 *
 * @see JFrame
 */

class CancelButton implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        JButton o = (JButton) e.getSource();
        String label = o.getText();
        //statusbar.setText(" " + label + " button clicked");
    }
}

