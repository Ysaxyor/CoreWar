package solveur;
import solveur.pionts.*;

public class Move{

	//Attributs
	private Piont bot;
	private String direction; // gauche / droite / haut / bas

	public Move(Piont bot, String direction){
		this.bot = bot;
		this.direction = direction;
	}

	//getters
	public Piont getBot(){
		return this.bot;
	}

	public String getDirection(){
		return this.direction;
	}

	//setters
	public void setDirection(String direction){
		this.direction=direction;
	}
	//méthodes
	public String toString(){
		return "bot: "+this.bot+" direction: "+this.direction;
	}
}
