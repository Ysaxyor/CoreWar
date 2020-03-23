package	src.vue;

import src.modele.*;
import src.controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PanelNord extends JPanel {

	private BSolve solve;
	private JButton menu;
	private PanelWest pw;
	private State jeu;

	public PanelNord(PanelWest pw, State jeu){

		this.pw=pw;
		this.jeu=jeu;
		this.setLayout(new FlowLayout(FlowLayout.CENTER,100,50));

		this.solve=new BSolve(this.jeu);
		this.menu= new JButton("Menu");

		this.add(solve);
		this.add(menu);
		this.menu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				PanelNord.this.pw.setMenu();
				PanelNord.this.pw.isMenu();
			}

		});

		this.setVisible(true);
	}


}
