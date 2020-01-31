package solveur;

public class Move{

	//Attributs
	private Bot bot;
	private String direction; // gauche / droite / haut / bas

	public Move(Bot bot, String direction){
		this.bot = bot;
		this.direction = direction;
	}

	//getters
	public Bot getBot(){
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
}
