package solveur;

import java.util.*;



public class Grille{
	
	//Attribut
	private int nbLign; // nombre de ligne
	private int nbCol;	// nombre de colonne
	private char [][] grille; // une grille a 2Dimension rempli de caractere, chaque case est un caractere
	private int nbTp;

	// Constructeur
	public Grille(int l,int c,int ntp){

		nbLign=l;
		nbCol=c;
		nbTp =ntp;
		grille= new char [nbLign][nbCol];


		for(int i=0; i<nbLign; i++){	//2 boucle car tableau a 2 dimension
			for(int j=0; j<nbCol ;j++){
				grille[i][j]= '.';
			}
		}
		setBordures();
		setMur();
		setTrampoline();
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
	
	// Generateur aléatoire d'une valeur dans un intervalle donné.
	public int Randomizer(int min,int max){
		return (int)(Math.random()*(max-min))+min;
		}
	
	// Méthode créant 2 murs extérieurs dans chaque quart de la grille d'une manière aléatoire
	public char[][] setMurExt(){
		// déclaration d'une ligne ou colonne random en fonction du quart de grille
		int l1 = Randomizer(1,nbLign/2);
		int c1 = Randomizer(1,nbCol/2);
		int l2 = Randomizer(nbLign/2,nbLign-1);
		int c3 = Randomizer(nbCol/2,nbCol-1);
		// si on a 2 fois le même index alors on aura 2 murs au même endroit, pour éviter ce conflit condition provisoire
		if (l1 != c1 && l2 != c1 && l1 != c3 && l2 != c3){
		//1er quart en haut à gauche
		grille[l1][1]='x';
		grille[1][c1]='x';
		//2e quart bas gauche (-2 pour s'adapter à la bordure du jeu)
		grille[l2][1]='x';
		grille[nbLign -2][c1]='x';
		//3e quart haut droite
		grille[l1][nbCol-2]='x';
		grille[1][c3]='x';
		//4e quart bas droite
		grille[l2][nbCol-2]='x';
		grille[nbLign -2][c3]='x';
		}
		else {
			// récursivité si on a le même index sur une des positions
			setMurExt();
			}
		return this.grille;
		}
		
	
	// Méthode pour ajouter les murs centraux (initiaux) dans la grille et les murs extèrieurs aléatoires
	public char[][] setMur(){
		// Murs au milieu
		grille[nbLign/2][nbCol/2]='x';
		grille[nbLign/2][(nbCol/2)-1]='x';
		grille[(nbLign/2)-1][(nbCol/2)-1]='x';
		grille[(nbLign/2)-1][(nbCol/2)]='x';
		setMurExt();
		return this.grille;
		
		}
	// méthode PROVISOIRES ... je ferai avec un ensemble d'objet provenant d'une classe Trampoline
	public char[][] setTrampoline(){
		System.out.println(nbTp);
		for (int i = 0; i < nbTp; i++){
		Integer r_x = Randomizer(1,nbLign-2);
			Integer r_y = Randomizer(1,nbCol-2);
			System.out.println(r_x);
			Random r = new Random();
			char c = r.nextBoolean() ? 'h' : 't';
			grille[r_x][r_y] = c;
			}
		
		return this.grille;
		}
	
	
}
