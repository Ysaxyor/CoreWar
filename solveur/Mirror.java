package solveur;

public class Mirror{

	//Attributs
	private Integer x;
	private Integer y;
	private String color;
	private char sens; // t -> /       h -> \

	public Mirror(Integer x, Integer y, String color, char sens, Grille grille){ //Constructeur
		this.x = x;
		this.y = y;
		this.color = color;
		this.sens = sens;
		grille.setGrille(x,y,sens);
	}
}