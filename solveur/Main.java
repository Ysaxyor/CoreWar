package solveur;

public class Main {
	public static void main(String[] args){

			Grille g1=new Grille(16,24); //choix de taille de la grille
			Bot botBlue = new Bot(1,1,"blue",g1); //Création du bot et ajout automatique à une grille existante (position, couleur, grille)
			g1.afficher();

	}

	}
