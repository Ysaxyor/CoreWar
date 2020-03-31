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

		super("Solve / Change State");
		this.jeu = jeu;
		this.addActionListener(this);

	}

	public State getJeu() {
		return jeu;
	}

	public HashMap<Integer,State> getListeEtats() {
		HashMap<Integer,State> ensemble = new HashMap<>();
		int cmpt=1;
		for (Node n: listeEtats){
			ensemble.put(cmpt,n.getValeur());
			cmpt+=1;
		}
		return ensemble;
	}

	public void setJeu(State jeu) {
		this.jeu = jeu;
	}

	public void actionPerformed(ActionEvent e) {

		// Premier clique on déclare tout et initialise l'IA du jeu.
		Node noeud = new Node(jeu);
		IA ia = new IA(jeu);
		this.listeEtats = ia.aEtoile();
		}
	}
