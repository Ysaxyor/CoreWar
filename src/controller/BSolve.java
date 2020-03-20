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
			n.getValeur().refresh();
			//getValeur() = getState()
			//TODO
			//timer à mettre pour montrer chaque état car là le dernier écrasera le dernier ca revient à faire na[-1].refresh()
		}
		
		}


}
