package src.controller;

import src.modele.*;
import src.modele.ia.*;


import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Object;
import java.util.concurrent.TimeUnit;

public class BSolve extends JButton implements ActionListener{


	private State jeu;
	private int clc;
	private ArrayList<Node> listeEtats;

	public BSolve(State jeu){

		super("Solve");
		this.jeu = jeu;
		this.clc = 0;
		this.addActionListener(this);

	}


	public void actionPerformed(ActionEvent e){


	// Premier clique on déclare tout et initialise l'IA du jeu.
		if (clc == 0){
		Node noeud = new Node(jeu);
		GraphState g = new GraphState(noeud);
		IA ia = new IA(jeu);
		ArrayList<Node> na = ia.algo();
		this.listeEtats = na;
	}
		
		if (clc < listeEtats.size()){
		
		// Dans la logique j'aurai fais ca si ca fonctionnait.
			//this.jeu.getGrille().getEnsemblePiont().clear();
			//this.jeu.getGrille().setEnsemblePiont(this.listeEtats.get(clc).getValeur().getGrille().getEnsemblePiont());
			
			Grille new_grille = this.jeu.getGrille();
			new_grille.setEnsemblePiont(this.listeEtats.get(clc).getValeur().getGrille().getEnsemblePiont());
			this.jeu.setGrille(new_grille);
			this.listeEtats.get(clc).getValeur().affiche();
			}
		
		this.clc += 1;
			
		}
}
