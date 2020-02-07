package solveur;

import java.util.Random;

public class Generation{
	
	private int nbLign; // nombre de ligne
	private int nbCol;	// nombre de colonne
	private char [][] grille;

	public Generation(int l,int c){

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
		setMurs();
		setAngles();
	}

	public char[][] getGrille(){
		return this.grille;	
	}

	public char[][] setBordures(){ //Crée les frontières de la carte
		//La première et le dernière ligne est remplit de x
		for(int i=0; i<nbCol; i++){
			grille[0][i]='x';
			grille[i][0]='x';
		}
		return this.grille;
	}

	public char[][] setCentre(){ //Création du centre 2x2 de la grille
		if(nbLign%2!=0 || nbCol%2!=0){ //Si
			System.out.println("Impossible de créer un centre dans cette grille");
			return this.grille;
		} else{
			grille[nbLign-1][nbCol-1]='x';
			return this.grille;
		}
	}

	public char [][] setMurs(){
		Random random = new Random();
		this.grille[1][2+random.nextInt(nbCol-1-2)] = 'x';
		this.grille[2+random.nextInt(nbLign-1-2)][1] = 'x';
		return this.grille;
	}

	public char [][] setAngles(){
		Random random = new Random(); //Instance de la calsse Random
		int [] alea = new int [16]; // La liste des coordonnées des futurs angles
		for(int i = 0; i<4;i++){
			alea[i] = 3+random.nextInt(2); //Proche
			alea[i+4] = 7+random.nextInt(2); //Loin
			alea[11-i] = random.nextInt(2); //Binaire
			if(alea[11-i]==0){
				alea[15-i] = -1;
			}else{
				alea[15-i] = 0;			
			}
		}

		this.grille[alea[0]][alea[1]] = 'x'; //angle 1
		this.grille[alea[0]][alea[1]+1] = 'x';
		this.grille[alea[0]+alea[8]+alea[12]][alea[1]] = 'x';

		this.grille[alea[3]][alea[5]] = 'x'; //angle 3
		this.grille[alea[3]][alea[5]+1] = 'x';
		this.grille[alea[3]+alea[9]+alea[13]][alea[5]] = 'x';

		this.grille[alea[4]][alea[2]] = 'x'; //angle 2
		this.grille[alea[4]][alea[2]-1] = 'x';
		this.grille[alea[4]+alea[10]+alea[14]][alea[2]] = 'x';

		this.grille[alea[6]][alea[7]] = 'x'; //angle 4
		this.grille[alea[6]][alea[7]-1] = 'x';
		this.grille[alea[6]+alea[11]+alea[15]][alea[7]] = 'x';
		return this.grille;
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