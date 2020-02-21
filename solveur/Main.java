package solveur;
import java.util.*;
import solveur.pionts.*;
import solveur.ia.*;
public class Main {
	public static void main(String[] args){

			//GENERATION
			Grille grille=new Grille(20,20); //choix de taille de la grille

			//CREATION DES objets
			Bot botBlue = new Bot(1,1,"Blue");
			Bot botRed = new Bot (2,2,"Red");
			Bot botGreen = new Bot (5,5,"Green");
			Mirror redMirror = new Mirror(5,1,"Red",'h');
			Mirror yellowMirror = new Mirror(1,24,"Yellow",'h');
			Mirror blueMirror = new Mirror(5,5,"Blue",'t');
			Mirror greenMirror = new Mirror(10,24,"Green",'t');
			Goal blueGoal = new Goal(16,24,"Blue");


			//ajout des objets à la grille
			grille.addPiont(botBlue);
			//grille.addPiont(botRed);
			//grille.addPiont(botGreen);
			grille.addPiont(redMirror);
			grille.addPiont(yellowMirror);
			grille.addPiont(blueMirror);
			grille.addPiont(greenMirror);
			grille.addPiont(blueGoal);

			//CREATION DES MOVES POSSIBLES
			Move goDroiteBlue = new Move(botBlue,"droite"); //On détermine le mouvement d'un bot, peut-être réutiliser pour un même robot avec une même direction
			//On pourra plus tard lister tout les move possibles
			Move goBasBlue = new Move(botBlue,"bas");
			Move goHautBlue = new Move(botBlue,"haut");
			Move goGaucheBlue = new Move(botBlue,"gauche");
/*
			Move goBasRed = new Move(botRed,"bas");
			Move goHautRed = new Move(botRed,"haut");
*/
			//GENERATION DES ETATS ET TEST
			State etat = new State(grille);
			State etat2 = etat.play(goBasBlue);



			Node noeud1=new Node(etat);
			//System.out.println("Noeud Pere: "+noeud1);
			GraphState g = new GraphState(noeud1);
			//System.out.println(noeud1.getFils());
			IA t = new IA(etat);


			for(Node n: t.algo()){
				n.getValeur().affiche();
			}


	}
}
