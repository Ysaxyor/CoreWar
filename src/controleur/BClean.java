package src.controleur;

import src.modele.*;
import javax.swing.*;
import java.awt.event.*;

public class BClean extends JButton implements ActionListener{

	private State jeu;

	public BClean(State jeu){
		super("Clean");
		this.jeu=jeu;
		this.addActionListener(this);

	}

	/***
	 * Lorsque l'action est effectuée, on appelle la methode clean() du jeu en attribut.
	 */
	public void actionPerformed(ActionEvent e){
		this.jeu.clean();
		}
}