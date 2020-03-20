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
	private Node noeud;
	private GraphState g;
	private IA ia;

	public BSolve(State jeu){

		super("Solve");
		noeud = new Node(jeu);
		g = new GraphState(noeud);
		ia = new IA(jeu);
		this.addActionListener(this);

	}


	public void actionPerformed(ActionEvent e){

		ArrayList<Node> na = ia.algo();

		for(Node n: na){
			n.getValeur().wait(2000);
			System.out.println(n);
			n.getValeur().refresh();
			//getValeur() = getState()

			//TODO affiche des états entre chaque wait du timer
			//TOFIX l'ia qui bug souvent avec les multiples générations (duplications de robots) ou desfois la génération est infini
		}
		
		}


}
