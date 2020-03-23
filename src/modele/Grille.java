package src.modele;
import java.util.*;
import java.util.HashSet;
import src.modele.pionts.*;

public class Grille{

	//Attribut
	private int nbLign; // nombre de ligne
	private int nbCol;	// nombre de colonne

	private int l;
	private int c;

	private Piont[][] grille; // une grille a 2Dimension rempli de Piont
	private HashSet<Piont> ensemble_piont; // ensemble qui contient tout les pionts important


	// Constructeur
	public Grille(int nbLign){
		if(nbLign<10){
			System.out.println("La grille sera trop petite, elle a été fixé au minimum : 10x10");
			nbLign = 10;
		}
		this.nbLign = nbLign;
		this.nbCol = nbLign;
		this.l = decoupage();
		this.c = this.l;
		this.ensemble_piont=new HashSet<Piont>();

		Piont[][][] listeConstruct = new Piont[(this.nbLign/l)*(this.nbLign/l)][this.l][this.c];
		for(int i = 0;i<(this.nbLign/l)*(this.nbLign/l);i++){
			listeConstruct[i] = construct();
		}
		this.grille = assemblage(listeConstruct);
		this.grille = setMurs();
	}

	/*
	public Grille(int nbLign, int nbCol){ //Pas de génération
		this.nbLign = nbLign;
		this.nbCol = nbCol;
		this.grille = new Piont[nbLign][nbCol];
		this.ensemble_piont = new HashSet<Piont>();
	}*/

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

	public void setG (Piont[][] g){
		this.grille=g;
	}

	public void setGrille(Integer x, Integer y,Piont p){ //Permet d'ajouter un caractère
		this.grille[x][y]=p;
	}
	public void setEnsemblePiont(HashSet<Piont> ensemble_piont){
		this.clear();
		this.ensemble_piont=ensemble_piont;
		for(Piont p: ensemble_piont){
			this.setGrille(p.getX(),p.getY(),p);
		}
	}

//Methodes

	public int decoupage(){
		int i = (int)this.nbLign/10;
		this.nbLign = (this.nbLign/i)*i; //On adapate la taille de la grille pour avoir des part egales		
		this.nbCol = (this.nbCol/i)*i;
		System.out.println("La grille a été ajustée en "+this.nbLign+"x"+this.nbLign);
		return this.nbLign/i;
	}

	public void clear(){
		for(int i=0;i<this.nbCol;i++){
			for(int j=0;j<this.nbLign;j++){
				if (! (this.grille[i][j] instanceof Mur)){
					this.grille[i][j]=new Piont(i,j);
				}
			}
		}
	}

	public void afficher(HashSet<Piont> ensemble_piont1){
		for (Piont p: ensemble_piont1){
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
	public void afficher(){
		this.afficher(this.ensemble_piont);
	}


	public void addPiont(Piont p){
		this.ensemble_piont.add(p);
		this.setGrille(p.getX(),p.getY(),p);
	}

	public Piont[][] construct(){
		grille	= new Piont[this.l][this.c];
		for(int i=0; i<this.l; i++){	//2 boucle car tableau a 2 dimension
			for(int j=0; j<this.c ;j++){
				//on remplit le tableau d'objets de type Piont;
				Piont new_piont = new Piont(i,j);
				this.grille[i][j]= new_piont;
			}
		}
		grille=this.setAngles();
		return grille;
	}

	public Piont[][] assemblage(Piont[][][] liste){
		Piont nouveau [][] = new Piont[nbLign][nbCol];
		for(int i = 0;i<nbLign;i++){
			for(int j = 0;j<nbCol;j++){
				Piont new_piont = new Piont(i,j);
				nouveau[i][j]= new_piont;
			}
		}

		int bx = 0;
		int by = 0;

		for(int biais = 0;biais<(this.nbLign/l)*(this.nbLign/l);biais++){
			//CALCUL DU BIAIS	
			//Permet de repartir chaque pièce dans une zone de la grille
			for(int i=0;i<this.l;i++){
				for(int j=0;j<this.c;j++){
					nouveau[bx+i][by+j] = liste[biais][i][j];
				}
			}
			bx = bx + l;
			if(bx == nbLign){
				bx = 0;
				by = by +c;
			}
		}
		return nouveau;
	}

	public Piont[][] setMurs(){
		//setBordures
		for(int i=0; i<nbLign; i++){
			Mur new_mur1 = new Mur(0,i);
			grille[0][i]=new_mur1;
			Mur new_mur2 = new Mur(nbLign-1,i);
			grille[i][0]=new_mur2;

			Mur new_mur3 = new Mur(i,0);
			grille[nbLign-1][i]=new_mur3;
			Mur new_mur4 = new Mur(i,nbCol-1);
			grille[i][nbCol-1]=new_mur4;
		}

		//SetCentre
		int cx = nbLign/10;//Centre x
		int cy = nbCol/10;

		if((nbLign/10)%2 != 0){ //Si le centre est impair
			cx += 1;
			cy += 1;
		} //Si le nombre de lignes et de colonnes du centre est pair, il sera centré dans le tableau
		Piont centre [][] = new Piont[cx][cy]; //On crée le centre de la taille nbLign/10 x nbLign/10
		int bx = nbLign/2-cx/2; //biais abscisse
		int by = nbCol/2-cy/2;
		//Remplir le centre de murs et l'ajouter en même temps à la grille
		for(int i=0; i<cx;i++){
			for(int j=0; j<cy;j++){
				Mur mur = new Mur(i,j);
				centre[i][j] = mur;
				grille[bx+i][by+j] = centre[i][j];
			}
		}
		return this.grille;
	}

	public Piont [][] setAngles(){
		Random random = new Random(); //Instance de la calsse Random

		int l2 = (int)l/2; //On divise ligne et colonne puis on le converti en int
		int c2 = (int)c/2;

		int a = (l2-2)+random.nextInt(1);
		int b = (c2-2)+random.nextInt(1);
		Mur m1 = new Mur(a,b);
		this.grille[a][b] = m1;
		m1.setAngle(this.grille);

		a = (l2+1)+random.nextInt(3);
		b = (c2-2)+random.nextInt(1);
		Mur m2 = new Mur(a,b);
		this.grille[a][b] = m2;
		m2.setAngle(this.grille);
		
		a = (l2-2)+random.nextInt(1);
		b = (c2+1)+random.nextInt(3);
		Mur m3 = new Mur(a,b);
		this.grille[a][b] = m3;
		m3.setAngle(this.grille);
	
		a = (l2+1)+random.nextInt(3);
		b = (c2+1)+random.nextInt(3);
		Mur m4 = new Mur(a,b);
		this.grille[a][b] = m4;
		m4.setAngle(this.grille);

		//setMurs
		a = 1;
		b = 2+random.nextInt(c-3);
		Mur mur1 = new Mur(a,b);
		this.grille[a][b] = mur1;

		a = 2+random.nextInt(c-3);
		b = 1;
		Mur mur2 = new Mur(a,b);
		this.grille[a][b] = mur2;

		a = this.l-1;
		b = 2+random.nextInt(c-3);
		Mur mur3 = new Mur(a,b);
		this.grille[a][b] = mur3;

		a = 2+random.nextInt(c-3);
		b = this.c-1;
		Mur mur4 = new Mur(a,b);
		this.grille[a][b] = mur4;
		return this.grille;
	}
}
