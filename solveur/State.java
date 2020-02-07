package solveur;
import solveur.pionts.*;
import java.util.HashMap;
import java.util.ArrayList;
public class State{

	//Attributs
	private Grille grille;
	private HashMap<Piont,ArrayList<Integer>> posPionts;

	public State(Grille grille){ //Constructeur
		this.grille = grille;
		//this.saveState();
	}

	//getters
	public Grille getGrille(){
		return this.grille;
	}
	public HashMap<Piont,ArrayList<Integer>> getPosPionts(){
		return this.posPionts;
	}
	//setters

	public void setGrille(Grille grille){
		this.grille=grille;
	}
	//méthodes
	public void saveState(){ //save la position des pionts;
		for (Piont p: this.grille.getEnsemblePiont()){
			ArrayList<Integer> pos= new ArrayList<>();
			pos.add(p.getX());
			pos.add(p.getY());
			this.posPionts.put(p,pos);
		}
	}


	public void affiche(){
		this.grille.afficher();
	}

	public State play(Move move){ // Creer un nouvel etat qui copie tout les données
		//de l'état présent, et applique un deplacement suivant le move entré en parametre;
		Grille new_grille = new Grille(this.grille.getNL(),this.grille.getNC());
		State new_state=new State(new_grille);
		for(Piont p: this.grille.getEnsemblePiont()){
			Piont new_piont=p;
			new_grille.addPiont(new_piont);
		}
		new_state.deplacement(move);
		return new_state;
	}

	public void deplacement(Move move){	// gère le deplacement d'un piont;
		//on recupere le bot
		Bot bot = move.getBot();

		Piont vide = new Piont(bot.getX(),bot.getY());
		this.grille.setGrille(bot.getX(),bot.getY(),vide); //on supprime l'emplacement initial du robot;
		// on recup la direction du mouvement
		String dir = move.getDirection();
		// on recup la grille, qui permettera de gerer les coordonnees;
		Piont[][] coord = this.grille.getGrille();

		// on initialise des nouveaux mouvements possible en cas de collision avec un mirror;
		Move vers_bas = new Move(bot,"bas");
		Move vers_droite = new Move(bot,"droite");
		Move vers_gauche = new Move(bot,"gauche");
		Move vers_haut = new Move(bot,"haut");

		if (dir == "bas"){
			while(! coord[bot.getX()+1][bot.getY()].collision(bot)){// tant que la collision avec le piont
				// voisin est false, on deplace le robot à l'emplacement voisin;
				bot.setX(bot.getX()+1);
			}
			// on regarde si le voisin est une instance de Mirror;
			if (coord[bot.getX()+1][bot.getY()] instanceof Mirror){
				bot.setX(bot.getX()+1);
				// on regarde le sens du Mirror;
				if (coord[bot.getX()][bot.getY()].getSymbole()=='t'){
					//dans le cas ou l'on arrive du bas sur --> \ le robot vas vers la gauche;
					//on applique donc un nouveau deplacement vers la gauche;
					this.deplacement(vers_gauche);
				}else{
					//  on arrive du bas sur --> /
					this.deplacement(vers_droite);
				}
			}
		}
		if (dir == "droite"){
			while(! coord[bot.getX()][bot.getY()+1].collision(bot)){
				bot.setY(bot.getY()+1);
			}
			if (coord[bot.getX()][bot.getY()+1] instanceof Mirror){
				bot.setY(bot.getY()+1);
				if (coord[bot.getX()][bot.getY()].getSymbole()=='t'){
					// on arrive vers la droite sur \ <---
					this.deplacement(vers_haut);
				}else{
					//  / <----
					this.deplacement(vers_bas);
				}
			}
		}
		if (dir == "haut"){
			while(! coord[bot.getX()-1][bot.getY()].collision(bot)){
				bot.setX(bot.getX()-1);
			}
			if (coord[bot.getX()-1][bot.getY()] instanceof Mirror){
				bot.setX(bot.getX()-1);
				if (coord[bot.getX()][bot.getY()].getSymbole()=='t'){
					// on arrive du haut sur --> \
					this.deplacement(vers_droite);
				}else{
					// on arrive du haut sur --> /
					this.deplacement(vers_gauche);
				}
			}
		}
		if (dir == "gauche"){
			while(! coord[bot.getX()][bot.getY()-1].collision(bot)){
				bot.setY(bot.getY()-1);
			}
			if (coord[bot.getX()][bot.getY()-1] instanceof Mirror){
				bot.setY(bot.getY()-1);
				if(coord[bot.getX()][bot.getY()].getSymbole()=='t'){
					//  --> \
					this.deplacement(vers_bas);
				}else{
					// --> /
					this.deplacement(vers_haut);
				}
			}
		}

	}

	public void congrats(){
		System.out.println("Objectif atteint !");
	}

}
