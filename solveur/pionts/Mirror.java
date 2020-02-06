package solveur.pionts;

public class Mirror extends Piont{

	//Attributs
	private Integer x;
	private Integer y;
	private String color;
	private char sens; // t -> /       h -> \

	public Mirror(Integer x, Integer y, String color, char sens){ //Constructeur
		super(x,y,sens);
		this.color = color;
		this.sens = sens;
	}

	//getters
	public String getColor(){
		return this.color;
	}
	public char getSens(){
		return this.sens;
	}


@Override
	public boolean collision(Piont p){
		if (p.getColor()==this.color){
			return false;
		}
		return true;
	}
}
