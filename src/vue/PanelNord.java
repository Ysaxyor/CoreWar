package	src.vue;

import src.modele.*;
import src.controleur.*;
import javax.swing.*;
import java.awt.*;


public class PanelNord extends JPanel {

	private PanelWest pw;

	public PanelNord(PanelWest pw, State jeu){

		this.pw=pw;
		this.setLayout(new FlowLayout(FlowLayout.CENTER,100,50));

		BSolve solve = new BSolve(jeu);
		JButton menu = new JButton("Menu");

		this.add(new PSolve(solve));
		this.add(menu);
		menu.addActionListener(e -> {
			PanelNord.this.pw.setMenu();
			PanelNord.this.pw.isMenu();
		});

		this.setVisible(true);
	}


}
