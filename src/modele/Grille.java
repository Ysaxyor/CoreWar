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
	public Grille(int nbLign, boolean cond){
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
			listeConstruct[i] = construct2();
		}
		this.grille = assemblage2(listeConstruct);
		this.grille = setMurs2();
	}

	public Grille(int nbLign){

		if(nbLign%2==0){               //Si ligne est pair, on le garde, sinon on le décrémente de un pour qu'il le soit
			this.nbLign = nbLign;
			this.nbCol = nbLign;
		}else{
			this.nbLign = nbLign-1;
			this.nbCol = nbLign-1;
		}

		//Q
		this.l = nbLign/2;
		this.c = nbCol/2;

		this.grille = assemblage(construct(),construct(),construct(),construct());
		this.ensemble_piont=new HashSet<Piont>();
	}

	public Grille(int nbLign, int nbCol){
		this.nbLign = nbLign;
		this.nbCol = nbCol;

		this.grille = new Piont[nbLign][nbCol];
		this.ensemble_piont = new HashSet<Piont>();
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

	public void setG (Piont[][] g){
		this.grille=g;
	}

	public void setGrille(Integer x, Integer y,Piont p){ //Permet d'ajouter un caractère
		this.grille[x][y]=p;
	}
	public void setEnsemblePiont(HashSet<Piont> ensemble_piont){
		this.ensemble_piont=ensemble_piont;
	}

//Methodes

	public int decoupage(){
		int i = (int)this.nbLign/10;
		this.nbLign = (this.nbLign/i)*i; //On adapate la taille de la grille pour avoir des part egales		
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
		grille=this.setMurs();
		grille=this.setAngles();
		return grille;
	}

	public Piont[][] construct2(){
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

	public Piont [][] assemblage(Piont [][] q1,Piont [][] q2, Piont [][] q3, Piont [][] q4){
		Piont nouveau [][] = new Piont[nbLign][nbCol];
		for(int i = 0;i<nbLign/2;i++){
			for(int j = 0;j<nbCol/2;j++){
				nouveau[i][j] = q1[i][j];
				nouveau[i][nbCol-j-1] = q3[i][j];
				nouveau[nbLign-i-1][j] = q2[i][j];
				nouveau[nbLign-i-1][nbCol-j-1] = q4[i][j];
			}
		}
		return nouveau;
	}

	public Piont[][] assemblage2(Piont[][][] liste){
		Piont nouveau [][] = new Piont[nbLign][nbCol];
		//Debut temporaire

		for(int i = 0;i<nbLign;i++){
			for(int j = 0;j<nbCol;j++){
				Piont new_piont = new Piont(i,j);
				nouveau[i][j]= new_piont;
			}
		}
					
		//Fin temporaire

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
		//La première et le dernière colonne est remplit de Mur
		//setBordures
		for(int i=0; i<c; i++){
			Mur new_mur1 = new Mur(0,i);
			grille[0][i]=new_mur1;
			Mur new_mur2 = new Mur(l-1,i);
			grille[i][0]=new_mur2;
		}

		//SetCentre

		return this.grille;
	}

	public Piont[][] setMurs2(){
		//La première et le dernière colonne est remplit de Mur
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

		//setCentre
		Mur m=new Mur(l-1,c-1);
		grille[l-1][c-1]=m;

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
