package solveur;

public class Main {
	public static void main(String[] args){

			//GENERATION
			Grille g1=new Grille(16,24); //choix de taille de la grille
			Mirror mirrorBlue = new Mirror(1,8,"blue",'h',g1);
			Mirror mirrorRed = new Mirror(8,1,"red",'t',g1);
			Bot botBlue = new Bot(1,1,"blue",g1); //Création du bot et ajout automatique à une grille existante (position, couleur, grille)
			Goal goal = new Goal(8,10,"blue",g1);
			g1.afficher();

			//CREATION DES MOVES POSSIBLES
			Move goDroiteBlue = new Move(botBlue,"droite"); //On détermine le mouvement d'un bot, peut-être réutiliser pour un même robot avec une même direction
			//On pourra plus tard lister tout les move possibles
			Move goBasBlue = new Move(botBlue,"bas");
			Move goHautBlue = new Move(botBlue,"haut");
			Move goGaucheBlue = new Move(botBlue,"gauche");

			//GENERATION DES ETATS ET TEST
			State state1 = new State(g1,goDroiteBlue); //Calcul de la prochaine carte avec un move donné
			state1.getGrille().afficher();

			State state2 = new State(state1.getGrille(),goBasBlue);
			state2.getGrille().afficher();

			State state3 = new State(state2.getGrille(),goGaucheBlue);
			state3.getGrille().afficher();

			State state4 = new State(state3.getGrille(),goHautBlue);
			state4.getGrille().afficher();
	}

	}
