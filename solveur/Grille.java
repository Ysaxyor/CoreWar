package solveur;

import java.io.*;
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

		Generation q1 = new Generation(10,10);
		Generation q2 = new Generation(10,10);
		Generation q3 = new Generation(10,10);
		Generation q4 = new Generation(10,10);
		assemblage(q1.getGrille(),q2.getGrille(),q3.getGrille(),q4.getGrille());
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

	public void assemblage(char [][] q1,char [][] q2, char [][] q3, char [][] q4){
		char nouveau [][] = new char[nbLign][nbCol];
		for(int i = 0;i<nbLign/2;i++){
			for(int j = 0;j<nbCol/2;j++){
				nouveau[i][j] = q1[i][j];
				nouveau[i][nbCol-j-1] = q3[i][j];
				nouveau[nbLign-i-1][j] = q2[i][j];
				nouveau[nbLign-i-1][nbCol-j-1] = q4[i][j];
			}
		}
		grille = nouveau;
	}

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
}
