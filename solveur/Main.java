package solveur;

public class Main {
	public static void main(String[] args){

			//GENERATION
			Grille g1=new Grille(16,24); //choix de taille de la grille

			Mirror mirrorBlue = new Mirror(1,8,"blue",'t',g1);
			g1.getMirrors().add(mirrorBlue);
			Mirror mirrorRed = new Mirror(8,1,"red",'h',g1);
			g1.getMirrors().add(mirrorRed);

			Bot botBlue = new Bot(1,1,"blue",g1); //Création du bot et ajout automatique à une grille existante (position, couleur, grille)
			Goal goal = new Goal(8,10,"blue",g1);
		//	g1.afficher();

			//CREATION DES MOVES POSSIBLES
			Move goDroiteBlue = new Move(botBlue,"droite"); //On détermine le mouvement d'un bot, peut-être réutiliser pour un même robot avec une même direction
			//On pourra plus tard lister tout les move possibles
			Move goBasBlue = new Move(botBlue,"bas");
			Move goHautBlue = new Move(botBlue,"haut");
			Move goGaucheBlue = new Move(botBlue,"gauche");

			//GENERATION DES ETATS ET TEST

			State etat1 = new State(g1);

			etat1.affiche();

			State etat2 = etat1.play(goDroiteBlue,botBlue);

			etat2.affiche();

			etat1.affiche();

			IA test = new IA(etat1);
			System.out.println(test.getDistance(goal,botBlue));
	}

	}
