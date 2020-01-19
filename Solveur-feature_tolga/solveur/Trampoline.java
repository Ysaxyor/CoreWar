package solveur;

public class Trampoline{

	//Attributs
	private Integer x;
	private Integer y;
	private String color;
	private char dir;
	private int n;

	public Trampoline(Integer x, Integer y, String color,char dir,int n,Grille grille){ //Constructeur
		this.x = x;
		this.y = y;
		this.color = color;
		this.dir  = dir;
		grille.setGrille(dir,x,y); //Ajoute le bot à la grille
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
