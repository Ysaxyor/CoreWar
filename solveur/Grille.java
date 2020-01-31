package solveur;

import java.util.*;

public class Grille{

	//Attribut
	private int nbLign; // nombre de ligne
	private int nbCol;	// nombre de colonne
	private char [][] grille; // une grille a 2Dimension rempli de caractere, chaque case est un caractere
	private List<Mirror> mirrors = new ArrayList<Mirror>(); //La liste des miroirs

	// Constructeur
	public Grille(int l,int c){

		nbLign=l;// Simplifiable
		nbCol=c;
		grille= new char [nbLign][nbCol];


		for(int i=0; i<nbLign; i++){	//2 boucle car tableau a 2 dimension
			for(int j=0; j<nbCol ;j++){
				grille[i][j]= '.';
			}
		}
		setBordures();
		setCentre();
	}

	//Getters
	public int getNL(){
		return this.nbLign;
	}
	public int getNC(){
		return this.nbCol;
	}
	public char[][] getGrille(){
		return this.grille;
	}

	public List<Mirror> getMirrors(){
		return this.mirrors;
	}

	public Mirror getMirrorByXY(int x,int y){ //Renvoie le Miroir correspondant aux coordonnées données
		for(int i = 0;i<this.mirrors.size();i++){
			if((this.mirrors.get(i).getX() == x) && (this.mirrors.get(i).getY() == y)){
				return this.mirrors.get(i);
			}
		}
		return this.mirrors.get(0); //Renvoie par défaut le premier mirroir pour éviter l'erreur missing return. Mais cet état ne sera jamais atteint
	}

	//Setters

	public void setGrille(Integer x, Integer y,Character c){ //Permet d'ajouter un caractère
		this.grille[x][y]=c;
	}
	public void setMirrors(List<Mirror> mirrors){
		this.mirrors=mirrors;
	}

	//Methodes

	public void toState(char[][] nouvelleGrille){ //On écrase la grille actuelle par la nouvelle dans le cas où l'IA veut enfin avancer
		this.grille = nouvelleGrille;
	}

	public void afficher(){
		System.out.println();
		for(int i=0; i<nbLign; i++){	//2 boucle car tableau a 2 dimension
			for(int j=0; j<nbCol;j++){

				System.out.print("|" + grille[i][j]);
			}

			System.out.println("|");

		}
		System.out.println();
	}

	public char[][] setBordures(){ //Crée les frontières de la carte
		//La première et le dernière ligne est remplit de x
		for(int i=0; i<nbCol; i++){
			grille[0][i]='x';
			grille[nbLign-1][i]='x';
		}
		//On ajoute ensuite un x à chaque premier et dernier ligne de la grille
		for(int i=1;i<nbLign-1;i++){
			grille[i][0]='x';
			grille[i][nbCol-1]='x';
		}
		return this.grille;
	}

	public char[][] setCentre(){ //Création du centre 2x2 de la grille
		if(nbLign%2!=0 || nbCol%2!=0){ //Si
			System.out.println("Impossible de créer un centre dans cette grille");
			return this.grille;
		} else{
			grille[nbLign/2-1][nbCol/2-1]='x';
			grille[nbLign/2][nbCol/2-1]='x';
			grille[nbLign/2-1][nbCol/2]='x';
			grille[nbLign/2][nbCol/2]='x';
			return this.grille;
		}
	}

}
