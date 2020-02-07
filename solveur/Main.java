package solveur;
import java.util.HashSet;
import java.util.HashMap;
import solveur.pionts.*;
public class Main {
	public static void main(String[] args){

			//GENERATION
			Grille grille=new Grille(18,26); //choix de taille de la grille

			//CREATION DES objets
			Bot botBlue = new Bot(1,1,"Blue");
			Bot botRed = new Bot (2,2,"Red");
			Mirror redMirror = new Mirror(5,1,"Red",'h');
			Mirror blueMirror = new Mirror(5,5,"Blue",'t');
			Mirror greenMirror = new Mirror(10,24,"Green",'t');
			Goal blueGoal = new Goal(16,24,"Blue");


			//ajout des objets à la grille
			grille.addPiont(botBlue);
			grille.addPiont(botRed);
			grille.addPiont(redMirror);
			grille.addPiont(blueMirror);
			grille.addPiont(greenMirror);
			grille.addPiont(blueGoal);

			//CREATION DES MOVES POSSIBLES
			Move goDroiteBlue = new Move(botBlue,"droite"); //On détermine le mouvement d'un bot, peut-être réutiliser pour un même robot avec une même direction
			//On pourra plus tard lister tout les move possibles
			Move goBasBlue = new Move(botBlue,"bas");
			Move goHautBlue = new Move(botBlue,"haut");
			Move goGaucheBlue = new Move(botBlue,"gauche");

			Move goBasRed = new Move(botRed,"bas");

			//GENERATION DES ETATS ET TEST
			State etat = new State(grille);
			State etat2 = etat.play(goBasBlue);
			State etat3 = etat2.play(goBasBlue);
			State etat4 = etat3.play(goBasRed);
			etat.affiche();
			etat2.affiche();
			etat3.affiche();
			etat4.affiche();

/*
	//test
		etat2.getPosPionts().entrySet().forEach(entry->{
    System.out.println(entry.getKey() + " | "+entry.getValue());
 		});
*/
	}
}
