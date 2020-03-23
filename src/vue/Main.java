package src.vue;

import src.modele.*;
import src.modele.pionts.*;


import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Object;


public class Main {
	public static void main(String[] args) {

		//GENERATION
			Grille grille=new Grille(10); //choix de taille de la grille

			//CREATION DES objets
			Bot botBlue = new Bot(1,1,"Blue");
			Bot botRed = new Bot (2,2,"Red");
			Bot botGreen = new Bot (5,5,"Green");
			Mirror redMirror = new Mirror(5,1,"Red",'h');
			//Mirror yellowMirror = new Mirror(1,24,"Yellow",'h');
			Mirror blueMirror = new Mirror(5,5,"Yellow",'t');
			//Mirror greenMirror = new Mirror(10,24,"Green",'t');
			Goal blueGoal = new Goal(1,6,"Blue");


			//ajout des objets à la grille
			grille.addPiont(botBlue);
			grille.addPiont(botRed);
			//grille.addPiont(botGreen);
			grille.addPiont(redMirror);
			//grille.addPiont(yellowMirror);
			grille.addPiont(blueMirror);
			//grille.addPiont(greenMirror);
			grille.addPiont(blueGoal);

			State jeu= new State(grille);

	new Vue(jeu);


	}
	
}
