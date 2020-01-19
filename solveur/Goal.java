package solveur;

public class Goal{

	//Attributs
	private Integer x;
	private Integer y;
	private String color;

	public Goal(Integer x, Integer y, String color, Grille grille){ //Constructeur
		this.x = x;
		this.y = y;
		this.color = color;
		grille.setGrille(x,y,'O');
	}
}