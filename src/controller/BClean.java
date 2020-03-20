package src.controller;

import src.modele.*;


import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Object;

public class BClean extends JButton implements ActionListener{

	private State jeu;

	public BClean(State jeu){

		super("Clean");
		this.jeu=jeu;
		this.addActionListener(this);

	}


	public void actionPerformed(ActionEvent e){

		
		System.out.print(this.jeu.getGrille().getEnsemblePiont());
		this.jeu.clean();
		
		}


}