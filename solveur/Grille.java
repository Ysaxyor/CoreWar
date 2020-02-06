package solveur;
import java.util.*;
import java.util.HashSet;
import solveur.pionts.*;

public class Grille{

	//Attribut
	private int nbLign; // nombre de ligne
	private int nbCol;	// nombre de colonne
	private Piont[][] grille; // une grille a 2Dimension rempli de Piont
	private HashSet<Piont> ensemble_piont; // ensemble qui contient tout les pionts important


	// Constructeur
	public Grille(int l,int c){
		this.nbLign=l;
		this.nbCol=c;
		this.grille=this.construct();
		this.ensemble_piont=new HashSet<Piont>();
	}

	//Getters
	public int getNL(){
		return this.nbLign;
	}
	public int getNC(){
		return this.nbCol;
	}
	public Piont[][] getGrille(){
		return this.grille;
	}
	public HashSet<Piont> getEnsemblePiont(){
		return this.ensemble_piont;
	}

	//Setters
	public void setNL(int l){
		this.nbLign=l;
	}
	public void setNC(int c){
		this.nbCol=c;
	}
	public void setGrille(Integer x, Integer y,Piont p){ //Permet d'ajouter un caractère
		this.grille[x][y]=p;
	}
	public void setEnsemblePiont(HashSet<Piont> ensemble_piont){
		this.ensemble_piont=ensemble_piont;
	}



//Methodes
	// construct permet la construction de la grille;
	public Piont[][] construct(){
		grille	= new Piont [this.nbLign][this.nbCol];
		for(int i=0; i<this.nbLign; i++){	//2 boucle car tableau a 2 dimension
			for(int j=0; j<this.nbCol ;j++){
				//on remplit le tableau d'objets de type Piont;
				Piont new_piont = new Piont(i,j);
				this.grille[i][j]= new_piont;
			}
		}
		grille=this.setBordures();
		grille=this.setCentre();
		return grille;
	}

	//Crée les frontières de la carte; à l'aide du piont Mur
	public Piont[][] setBordures(){
		//La première et le dernière colonne est remplit de Mur
		for(int i=0; i<nbCol; i++){
			Mur new_mur1 = new Mur(0,i);
			grille[0][i]=new_mur1;
			Mur new_mur2 = new Mur(nbLign-1,i);
			grille[nbLign-1][i]=new_mur2;
		}
		//On ajoute ensuite un mur à chaque premiere et derniere ligne de la grille
		for(int i=1;i<nbLign-1;i++){
			Mur new_mur3 = new Mur(i,0);
			grille[i][0]=new_mur3;
			Mur new_mur4 = new Mur(i,nbCol-1);
			grille[i][nbCol-1]=new_mur4;
		}
		return this.grille;
	}
	//Création du centre 2x2 de la grille
	public Piont[][] setCentre(){
		if(nbLign%2!=0 || nbCol%2!=0){
			//System.out.println("Impossible de créer un centre dans cette grille");
			return this.grille;
		} else{
			Mur new_mur1=new Mur(nbLign/2-1,nbCol/2-1);
			Mur new_mur2=new Mur(nbLign/2-1,nbCol/2-1);
			Mur new_mur3=new Mur(nbLign/2-1,nbCol/2);
			Mur new_mur4=new Mur(nbLign/2,nbCol/2);
			grille[nbLign/2-1][nbCol/2-1]=new_mur1;
			grille[nbLign/2][nbCol/2-1]=new_mur2;
			grille[nbLign/2-1][nbCol/2]=new_mur3;
			grille[nbLign/2][nbCol/2]=new_mur4;
			return this.grille;
		}
	}


	public void afficher(){
		for (Piont p: this.ensemble_piont){
			this.setGrille(p.getX(),p.getY(),p);
		}

		System.out.println();
		for(int i=0; i<nbLign; i++){	//2 boucle car tableau a 2 dimension
			for(int j=0; j<nbCol;j++){
				//On affiche l'attribut symbole de chaque pionts du tableau;
				System.out.print("|" + grille[i][j].getSymbole());
			}
			System.out.println("|");
		}
		System.out.println();
	}

	public void addPiont(Piont p){
		this.ensemble_piont.add(p);
		this.setGrille(p.getX(),p.getY(),p);
	}


}
