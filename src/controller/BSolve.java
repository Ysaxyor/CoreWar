package src.controller;

import src.modele.*;
import src.modele.ia.*;


import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class BSolve extends JButton implements ActionListener {


	private State jeu;
	private ArrayList<Node> listeEtats;

	public BSolve(State jeu) {

		super("Solve / Change State");
		this.jeu = jeu;
		this.addActionListener(this);

	}

	public State getJeu() {
		return jeu;
	}

	public ArrayList<Node> getListeEtats() {
		return listeEtats;
	}

	public void setJeu(State jeu) {
		this.jeu = jeu;
	}

	public void actionPerformed(ActionEvent e) {

		// Premier clique on déclare tout et initialise l'IA du jeu.
		Node noeud = new Node(jeu);
		GraphState g = new GraphState(noeud);
		IA ia = new IA(jeu);
		this.listeEtats = ia.aEtoile();
		for (int i=0; i<this.listeEtats.size();i++){
			System.out.println(this.listeEtats.size());
			this.listeEtats.get(i).getValeur().affiche();
		}
	}
}