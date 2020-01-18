package solveur;

public class Bot{

	//Attributs
	private Integer x;
	private Integer y;
	private String color;

	public Bot(Integer x, Integer y, String color,Grille grille){ //Constructeur
		this.x = x;
		this.y = y;
		this.color = color;
		grille.setGrille('B',x,y); //Ajoute le bot à la grille
	}

	//getters

	//setters

	//méthodes
}