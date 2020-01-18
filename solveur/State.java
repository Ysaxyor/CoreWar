package solveur;

public class State{

	//Attributs
	private char[][] grille;
	private Move move;
	private String dir; //On peut récupérer direction avec move.getDirection mais cette variable pourra accueillir de nouvelle direction si on rencontre un mirroir

	public State(char[][] grille,Move move){ //Constructeur
		this.grille = grille;
		this.move = move;
		dir = this.move.getDirection();
		grille = deplacement();
	}

	//getters

	//setters

	//méthodes

	public char[][] deplacement(){
		switch(dir){
			case "gauche":
				break;
			case "droite":
				break;
			case "haut":
				break;
			case "bas":
				break;
			default:
				System.out.println("Erreur de direction.");
				break;
		}
		return this.grille;
	}



}