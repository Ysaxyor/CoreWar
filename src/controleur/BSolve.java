package src.controleur;

import src.modele.*;
import src.modele.ia.*;


import javax.swing.*;
import java.util.*;
import java.awt.event.*;
public class BSolve extends JButton implements ActionListener {


	private State jeu;
	private ArrayList<Node> listeEtats;

	public BSolve(State jeu) {

		super("Solve");
		this.jeu = jeu;
		this.addActionListener(this);
		this.listeEtats=null;

	}

	public State getJeu() {
		return jeu;
	}

	public ArrayList<Node> getListeEtats() {
		return listeEtats;
	}
	public void setJeu(State jeu) {
		this.jeu=jeu;
	}

	public void actionPerformed(ActionEvent e) {

		// Premier clique on déclare tout et initialise l'IA du jeu
		if (listeEtats!=null){
			listeEtats.clear();
			PSolve.first=true;
		}
		Node noeud = new Node(new State(this.jeu.getGrille()));
		IA ia = new IA(jeu);
		this.listeEtats = ia.aEtoile();
		}
	}
