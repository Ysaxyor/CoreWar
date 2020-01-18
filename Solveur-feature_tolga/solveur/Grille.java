package solveur;

import java.util.*;



public class Grille{

	//Attribut
	private int nbLign; // nombre de ligne
	private int nbCol;	// nombre de colonne
	private char [][] grille; // une grille a 2Dimension rempli de caractere, chaque case est un caractere

	// Constructeur
	public Grille(int l,int c){

		nbLign=l;
		nbCol=c;
		grille= new char [nbLign][nbCol];


		for(int i=0; i<nbLign; i++){	//2 boucle car tableau a 2 dimension
			for(int j=0; j<nbCol ;j++){
				grille[i][j]= '.';
			}
		}
		setBordures();
		setMur();
	}

	//Getters

	public char[][] getGrille(){
		return this.grille;
	}

	//Setters

	public char[][] setGrille(Character c,Integer x, Integer y){ //Permet d'ajouter un caractère
		this.grille[x][y]=c;
		return this.grille;
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

	//Méthodes pour tester move plus tard

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
	
	public char[][] setQuartsdeMur(){
		
		
		}
		
	
	// Méthode pour ajouter des murs dans la grille
	public char[][] setMur(){
		// Murs au milieu
		grille[nbLign/2][nbCol/2]='x';
		grille[nbLign/2][(nbCol/2)-1]='x';
		grille[(nbLign/2)-1][(nbCol/2)-1]='x';
		grille[(nbLign/2)-1][(nbCol/2)]='x';
		return this.grille;
		
		}
	
	
}
