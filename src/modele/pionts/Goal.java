package src.modele.pionts;

public class Goal extends Piont{

	//Attributs
	private Integer x;
	private Integer y;
	private String color;

	public Goal(Integer x, Integer y, String color){ //Constructeur
		super(x,y,'O');
		this.color = color;
	}

	public String getColor(){
		return this.color;
	}

	@Override
	public String toString(){
		return "Goal "+this.getColor()+" en coordonnees ("+this.getX()+","+this.getY()+")";
	}

/*
@Override
	public boolean collision(Piont p){
		if (p.getColor()==this.color){
			return true;
		}
	return false;
	}

*/
}
