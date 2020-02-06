package solveur;
import java.util.HashSet;
import solveur.pionts.*;
public class Main {
	public static void main(String[] args){

			//GENERATION
			Grille grille=new Grille(18,26); //choix de taille de la grille

			//CREATION DES objets
			Bot botBlue = new Bot(1,1,"Blue");
			Mirror redMirror = new Mirror(5,1,"Red",'h');
			Mirror blueMirror = new Mirror(5,5,"Blue",'t');

			//ajout des objets à la grille
			grille.addPiont(botBlue);
			grille.addPiont(redMirror);
			grille.addPiont(blueMirror);

			//CREATION DES MOVES POSSIBLES
			Move goDroiteBlue = new Move(botBlue,"droite"); //On détermine le mouvement d'un bot, peut-être réutiliser pour un même robot avec une même direction
			//On pourra plus tard lister tout les move possibles
			Move goBasBlue = new Move(botBlue,"bas");
			Move goHautBlue = new Move(botBlue,"haut");
			Move goGaucheBlue = new Move(botBlue,"gauche");

			//GENERATION DES ETATS ET TEST
			State etat = new State(grille);
			etat.affiche();
			State etat2 = etat.play(goBasBlue);
			etat2.affiche();
	}
}
