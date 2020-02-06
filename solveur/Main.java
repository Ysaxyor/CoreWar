package solveur;
import java.util.HashSet;
import solveur.pionts.*;
public class Main {
	public static void main(String[] args){

			//GENERATION
			Grille g1=new Grille(10,15); //choix de taille de la grille
			Bot b1 = new Bot(1,1,"Blue");
			Mirror mirrorBlue = new Mirror(1,8,"Blue",'h');
			Mirror mirrorRed = new Mirror(7,1,"Red",'h');
			Mirror mirrorRed2 = new Mirror(7,10,"Red",'t');
			Goal goal = new Goal(8,10,"blue");
			g1.addPiont(b1);
			g1.addPiont(mirrorBlue);
			g1.addPiont(mirrorRed);
			g1.addPiont(goal);
			g1.addPiont(mirrorRed2);
			State etat = new State(g1);
			etat.affiche();
			Move test = new Move(b1,"bas");
			etat.play(test).affiche();
/*
			Mirror mirrorBlue = new Mirror(1,8,"blue",'t',g1);

			Bot botBlue = new Bot(1,1,"blue",g1); //Création du bot et ajout automatique à une grille existante (position, couleur, grille)
			Goal goal = new Goal(8,10,"blue",g1);
		//	g1.afficher();

			//CREATION DES MOVES POSSIBLES
			Move goDroiteBlue = new Move(botBlue,"droite"); //On détermine le mouvement d'un bot, peut-être réutiliser pour un même robot avec une même direction
			//On pourra plus tard lister tout les move possibles
			Move goBasBlue = new Move(botBlue,"bas");
			Move goHautBlue = new Move(botBlue,"haut");
			Move goGaucheBlue = new Move(botBlue,"gauche");
*/
			//GENERATION DES ETATS ET TEST

	}
}
