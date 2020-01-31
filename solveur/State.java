package solveur;

public class State{

	//Attributs
	private Grille grille;

	public State(Grille grille){ //Constructeur
		this.grille = grille;

	}

	//getters
	public Grille getGrille(){
		return this.grille;
	}
	public void setGrille(Grille grille){
		this.grille=grille;
	}

	//setters

	//méthodes
	public void affiche(){
		this.grille.afficher();
	}


	public Grille deplacement(Move move, Bot player){
		String dir=move.getDirection();
		Integer botX = move.getBot().getX();
		Integer botY = move.getBot().getY();
		move.getBot().setX(botX);
		move.getBot().setY(botY);
		Move newMove = new Move(player,dir);
		if(this.grille.getGrille()[move.getBot().getX()][move.getBot().getY()] != 't'){
			if(this.grille.getGrille()[move.getBot().getX()][move.getBot().getY()] != 'h'){
				this.grille.setGrille(move.getBot().getX(),move.getBot().getY(),'.'); //On supprime l'emplacement initial du robot
			}
		}

		switch(dir){
			case "gauche":
				switch(this.grille.getGrille()[botX][botY-1]){
					case 'x': //Si on trouve un mur
						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					case 'B': //Si on trouve un robot
						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					case 't': // (\)
						if(this.grille.getMirrorByXY(botX,botY-1).getColor() != move.getBot().getColor()){ //Dans le cas où le robot n'est pas de la même couleur que le miroir
							dir = "haut";
						}
						botY -= 1;
						this.grille.setGrille(botX,botY,'t');
						newMove.setDirection(dir);
						player.setY(botY);
						return deplacement(newMove,player);
					case 'h': // (/)

						if(this.grille.getMirrorByXY(botX,botY-1).getColor() != move.getBot().getColor()){ //Dans le cas où le robot n'est pas de la même couleur que le miroir
							dir = "bas";
						}
						botY -= 1;
						player.setY(botY);
						newMove.setDirection(dir);
						return deplacement(newMove,player);
					case 'O':
						botY -= 1;
						player.setY(botY);
						congrats();

						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					default: //Dans le cas où il n'y a que du vide
						botY -= 1;
						player.setY(botY);
						return deplacement(newMove,player);
				}
			case "droite":
				switch(this.grille.getGrille()[botX][botY+1]){
					case 'x': //Si on trouve un mur

						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					case 'B': //Si on trouve un robot

						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					case 't': //Si on trouve un trampoline il faudra déterminer si on le traverse ou si on peut l'emprunter et dans quelle direction
						//à définir
						if(this.grille.getMirrorByXY(botX,botY+1).getColor() != move.getBot().getColor()){ //Dans le cas où le robot n'est pas de la même couleur que le miroir
							dir = "bas";
						}
						botY += 1;
						player.setY(botY);
						newMove.setDirection(dir);
						return deplacement(newMove,player);
					case 'h': // (/)

						if(this.grille.getMirrorByXY(botX,botY+1).getColor() != move.getBot().getColor()){ //Dans le cas où le robot n'est pas de la même couleur que le miroir
							dir = "haut";
						}
						botY += 1;
						newMove.setDirection(dir);
						player.setY(botY);
						return deplacement(newMove,player);
					case 'O':
						botY += 1;
						player.setY(botY);
						congrats();

						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					default: //Dans le cas où il n'y a que du vide
						botY += 1;
						player.setY(botY);
						return deplacement(newMove,player);
				}
			case "haut":
				switch(this.grille.getGrille()[botX-1][botY]){
					case 'x': //Si on trouve un mur

						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					case 'B': //Si on trouve un robot

						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					case 't': // (\)

						if(this.grille.getMirrorByXY(botX-1,botY).getColor() != move.getBot().getColor()){
							dir = "gauche";
						}
						botX -= 1;
						newMove.setDirection(dir);
						player.setX(botX);
						return deplacement(newMove,player);
					case 'h': // (/)

						if(this.grille.getMirrorByXY(botX-1,botY).getColor() != move.getBot().getColor()){
							dir = "droite";
						}
						botX -= 1;
						newMove.setDirection(dir);
						player.setX(botX);
						return deplacement(newMove,player);
					case 'O':
						botX -= 1;
						player.setX(botX);
						congrats();

						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					default: //Dans le cas où il n'y a que du vide
						botX -= 1;
						player.setX(botX);
						return deplacement(newMove,player);
				}
			case "bas":
				switch(this.grille.getGrille()[botX+1][botY]){
					case 'x': //Si on trouve un mur

						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					case 'B': //Si on trouve un robot

						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					case 't': //Si on trouve un trampoline il faudra déterminer si on le traverse ou si on peut l'emprunter et dans quelle direction
						//à définir

						if(this.grille.getMirrorByXY(botX+1,botY).getColor() != move.getBot().getColor()){
							dir = "droite";
						}
						botX += 1;
						newMove.setDirection(dir);
						player.setX(botX);
						return deplacement(newMove,player);
					case 'h': // (/)

						if(this.grille.getMirrorByXY(botX+1,botY).getColor() != move.getBot().getColor()){
							dir = "gauche";
						}
						botX += 1;
						newMove.setDirection(dir);
						player.setX(botX);
						return deplacement(newMove,player);
					case 'O':
						botX += 1;
						player.setX(botX);
						congrats();

						this.grille.setGrille(botX,botY,'B'); //On place le robot au dernier endroit calculé
						return this.grille;
					default: //Dans le cas où il n'y a que du vide
						botX += 1;
						player.setX(botX);
						return deplacement(newMove,player);
				}
			default:
				System.out.println("Erreur de direction.");
				return this.grille;
		}
	}

	public void congrats(){
		System.out.println("Objectif atteint !");
	}

	public State play(Move move, Bot player){
		Grille newGrille = new Grille(this.grille.getNL(),this.grille.getNC());
		newGrille.setMirrors(this.grille.getMirrors());
		State newState = new State(newGrille);
		newState.setGrille(newState.deplacement(move,player));
		return newState;
	}


}
