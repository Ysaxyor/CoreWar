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
		grille.setGrille(x,y,'B'); //Ajoute le bot à la grille
	}

	//getters
	public Integer getX(){
		return this.x;
	}

	public Integer getY(){
		return this.y;
	}

	//setters

	public void setX(Integer x){
		this.x = x;
	}

	public void setY(Integer y){
		this.y = y;
	}

	//méthodes
}
