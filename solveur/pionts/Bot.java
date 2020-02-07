package solveur.pionts;

public class Bot extends Piont{

	//Attributs
	private Integer x;
	private Integer y;
	private char symbole;
	private String color;

	public Bot(Integer x, Integer y,String color){ //Constructeur
		super(x,y,'B');
		this.color = color;
	}

	//getters

	public String getColor(){
		return this.color;
	}

	//setters


	//méthodes
	@Override
	public String toString(){
		return "Bot en coordonnees ("+this.getX()+","+this.getY()+")";
	}

	@Override
	public boolean collision(Piont p){
		return true;
	}
}
