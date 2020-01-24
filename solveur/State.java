package solveur;

public class State{

	//Attributs
	private Grille grille;
	private Move move;

	private String dir; //On peut récupérer direction avec move.getDirection mais cette variable pourra accueillir de nouvelle direction si on rencontre un mirroir
	private Integer botX; //Positions du bot
	private Integer botY;

	public State(Grille grille,Move move){ //Constructeur
		this.grille = grille;
		this.move = move;

		dir = this.move.getDirection();
		botX = move.getBot().getX();
		botY = move.getBot().getY();

		this.grille = deplacement();
		move.getBot().setX(botX);
		move.getBot().setY(botY);
	}

	//getters
	public Grille getGrille(){
		return this.grille;
	}

	//setters

	//méthodes

	public Grille deplacement(){
		switch(dir){
			case "gauche":
				switch(this.grille.getGrille()[botX][botY-1]){
					case 'x': //Si on trouve un mur
						this.grille.setGrille(move.getBot().getX(),move.getBot().getY(),'.'); //On supprime l'emplacement initial du robot
						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					case 'B': //Si on trouve un robot
						this.grille.setGrille(move.getBot().getX(),move.getBot().getY(),'.'); //On supprime l'emplacement initial du robot
						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					case 't': // (\)
						if(this.grille.getMirrorByXY(botX,botY-1).getColor() != this.move.getBot().getColor()){ //Dans le cas où le robot n'est pas de la même couleur que le miroir
							dir = "haut";
						}
						botY -= 1;
						return deplacement();
					case 'h': // (/)
						if(this.grille.getMirrorByXY(botX,botY-1).getColor() != this.move.getBot().getColor()){ //Dans le cas où le robot n'est pas de la même couleur que le miroir
							dir = "bas";
						}
						botY -= 1;
						return deplacement();
					case 'O':
						botY -= 1;
						congrats();
						this.grille.setGrille(move.getBot().getX(),move.getBot().getY(),'.'); //On supprime l'emplacement initial du robot
						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					default: //Dans le cas où il n'y a que du vide
						botY -= 1;
						return deplacement();
				}
			case "droite":
				switch(this.grille.getGrille()[botX][botY+1]){
					case 'x': //Si on trouve un mur
						this.grille.setGrille(move.getBot().getX(),move.getBot().getY(),'.'); //On supprime l'emplacement initial du robot
						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					case 'B': //Si on trouve un robot
						this.grille.setGrille(move.getBot().getX(),move.getBot().getY(),'.'); //On supprime l'emplacement initial du robot
						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					case 't': //Si on trouve un trampoline il faudra déterminer si on le traverse ou si on peut l'emprunter et dans quelle direction
						//à définir
						if(this.grille.getMirrorByXY(botX,botY+1).getColor() != this.move.getBot().getColor()){ //Dans le cas où le robot n'est pas de la même couleur que le miroir
							dir = "bas";
						}
						botY += 1;
						return deplacement();
					case 'h': // (/)
						if(this.grille.getMirrorByXY(botX,botY+1).getColor() != this.move.getBot().getColor()){ //Dans le cas où le robot n'est pas de la même couleur que le miroir
							dir = "haut";
						}
						botY += 1;
						return deplacement();
					case 'O':
						botY += 1;
						congrats();
						this.grille.setGrille(move.getBot().getX(),move.getBot().getY(),'.'); //On supprime l'emplacement initial du robot
						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					default: //Dans le cas où il n'y a que du vide
						botY += 1;
						return deplacement();
				}
			case "haut":
				switch(this.grille.getGrille()[botX-1][botY]){
					case 'x': //Si on trouve un mur
						this.grille.setGrille(move.getBot().getX(),move.getBot().getY(),'.'); //On supprime l'emplacement initial du robot
						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					case 'B': //Si on trouve un robot
						this.grille.setGrille(move.getBot().getX(),move.getBot().getY(),'.'); //On supprime l'emplacement initial du robot
						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					case 't': // (\)
						if(this.grille.getMirrorByXY(botX-1,botY).getColor() != this.move.getBot().getColor()){
							dir = "gauche";
						}
						botX -= 1;
						return deplacement();
					case 'h': // (/)
						if(this.grille.getMirrorByXY(botX-1,botY).getColor() != this.move.getBot().getColor()){
							dir = "droite";
						}
						botX -= 1;
						return deplacement();
					case 'O':
						botX -= 1;
						congrats();
						this.grille.setGrille(move.getBot().getX(),move.getBot().getY(),'.'); //On supprime l'emplacement initial du robot
						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					default: //Dans le cas où il n'y a que du vide
						botX -= 1;
						return deplacement();
				}
			case "bas":
				switch(this.grille.getGrille()[botX+1][botY]){
					case 'x': //Si on trouve un mur
						this.grille.setGrille(move.getBot().getX(),move.getBot().getY(),'.'); //On supprime l'emplacement initial du robot
						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					case 'B': //Si on trouve un robot
						this.grille.setGrille(move.getBot().getX(),move.getBot().getY(),'.'); //On supprime l'emplacement initial du robot
						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					case 't': //Si on trouve un trampoline il faudra déterminer si on le traverse ou si on peut l'emprunter et dans quelle direction
						//à définir
						if(this.grille.getMirrorByXY(botX+1,botY).getColor() != this.move.getBot().getColor()){
							dir = "droite";
						}
						botX += 1;
						return deplacement();
					case 'h': // (/)
						if(this.grille.getMirrorByXY(botX+1,botY).getColor() != this.move.getBot().getColor()){
							dir = "gauche";
						}
						botX += 1;
						return deplacement();
					case 'O':
						botX += 1;
						congrats();
						this.grille.setGrille(move.getBot().getX(),move.getBot().getY(),'.'); //On supprime l'emplacement initial du robot
						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					default: //Dans le cas où il n'y a que du vide
						botX += 1;
						return deplacement();
				}
			default:
				System.out.println("Erreur de direction.");
				return this.grille;
		}
	}

	public void congrats(){
		System.out.println("Objectif atteint !");
	}



}
