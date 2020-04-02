package src.modele;
import src.modele.pionts.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;

public class State extends AbstractModeleEcoutable{	//Objet qui represente l'etat d'une grille de jeu;

	//Attributs
	private Grille grille;
	private HashMap<Piont,ArrayList<Integer>> posPionts; // On met en memoire la position
		//des pionts à l'instant de la creation de l'etat;

	public State(Grille grille){ //Constructeur
		super();
		this.grille = grille;
		this.posPionts=this.saveState();
		this.ecouteurs=new ArrayList<>();
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
		this.posPionts=this.saveState();
		fireChangement();
	}
	public void setPosPionts(HashMap<Piont,ArrayList<Integer>> posPionts){
		this.posPionts=posPionts;
		if(posPionts != null){
		HashSet<Piont> setPos = new HashSet<>();
		this.grille.clear();
		this.posPionts.forEach((p, value) -> {
			p.setX(value.get(0));
			p.setY(value.get(1));
			setPos.add(p);
		});
		this.grille.setEnsemblePiont(setPos);
		fireChangement();
		}
	}
	//méthodes

	public void affiche(){
		// on affiche la grille en fonction des positions des pionts à l'instant
		// de la creation de l'etat;
		HashSet<Piont> setPos = new HashSet<>();
		this.grille.clear();
		this.posPionts.forEach((p, value) -> {
			p.setX(value.get(0));
			p.setY(value.get(1));
			setPos.add(p);
		});
		this.grille.setEnsemblePiont(setPos);
		this.grille.afficher();
		fireChangement();
	}

	public State play(Move move){ // Creer un nouvel etat qui copie tout les données
		//de l'état présent, et applique un deplacement suivant le move entré en parametre;

		Grille new_grille = new Grille(this.grille.getNL());
		new_grille.setG(this.grille.getGrille());
		new_grille.clear();
		State new_state=new State(new_grille);
		for(Piont p: this.grille.getEnsemblePiont()){
			p.setX(this.posPionts.get(p).get(0));
			p.setY(this.posPionts.get(p).get(1));
			new_grille.addPiont(p);
		}


		new_state.deplacement(move);

		//On remet a jour les nouvelles positions des pionts;
		new_state.setPosPionts(new_state.saveState());

		if(move.getBot().getX()==this.getPosPionts().get(move.getBot()).get(0)){
			if(move.getBot().getY()==this.getPosPionts().get(move.getBot()).get(1)){
				return this;
			}
		}
		return new_state;
	}

	private void deplacement(Move move){	// gère le deplacement d'un piont;
		//on recupere le bot
		Piont bot = move.getBot();
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

		if (dir.equals("bas")){
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
		if (dir.equals("droite")){
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
		if (dir.equals("haut")){
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
		if (dir.equals("gauche")){
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

	public HashMap<Piont,ArrayList<Integer>> saveState(){
		//save la position des pionts;
		HashMap<Piont,ArrayList<Integer>> posP = new HashMap<>();
		for (Piont p: this.grille.getEnsemblePiont()){
			ArrayList<Integer> pos= new ArrayList<>();
			pos.add(p.getX());
			pos.add(p.getY());
			posP.put(p,pos);
		}
		return posP;
	}

	public boolean isFinished(){
		//On check si le bot de la couleur du goal est a la meme position
		// que ce goal;
		ArrayList<Piont> bots = new ArrayList<>();
		Piont goal = null;
		for(Piont p: this.grille.getEnsemblePiont()){
			if (p instanceof Goal){
				goal = p;
			}
			if (p instanceof Bot){
				bots.add(p);
			}
		}
		for (Piont b: bots){
			assert goal != null;
			if (b.getColor().equals(goal.getColor())){
					if(this.posPionts.get(b).get(0)==goal.getX() && this.posPionts.get(b).get(1)==goal.getY()){
						return true;
					}
				}
		}
		return false;
	}

	public HashSet<State> getFutureStates(){
		//Return un ensemble des Etats futurs possibles; ne doit pas modifier l'etat actuel;
		ArrayList<Piont> bots = new ArrayList<>();
		for (Piont b: this.getGrille().getEnsemblePiont()){
			if (b instanceof Bot){
				bots.add(b);
			}
		}
		ArrayList<Move> moves = new ArrayList<>();
		for (Piont b: bots){
			moves.add(new Move(b,"bas"));
			moves.add(new Move(b,"gauche"));
			moves.add(new Move(b,"droite"));
			moves.add(new Move(b,"haut"));
		}
		HashSet<State> etat_futurs = new HashSet<>();
		for (Move m: moves){
			etat_futurs.add(this.play(m));
		}

		//ici on supprime les occurences des etats futurs possible;
		//ainsi si les positions des pionts de deux etats sont les mêmes
		//alors il n'est pas necessaire de l'inclure une deuxieme fois
		//dans les etats futurs;
		HashSet<State> tmp = new HashSet<>();
		for (State s: etat_futurs){//on parcours une premiere fois l'ensemble
			tmp.add(s);
			for (State s2: etat_futurs){//en sachant S on parcours une deuxieme fois l'ensemble;
				if(s==s2){
					continue;
				}
				if(s.getPosPionts().equals(s2.getPosPionts())){ // on regarde si les positions
					//des pionts de S sont les mêmes quand ceux de s2;
					if(tmp.contains(s)){
						tmp.remove(s2);}
				}
			}
		}

		return tmp;

	}

	/***
	 * On evalue la distance de Manhattan entre le bot courant (c-a-d de meme couleur) et l'objectif
	 * @return un entier
	 */
	public int getEval(){
		//return la distance de Manhattan entre le joueur, et l'objectif
		Piont player=null;
		Piont goal=null;
		for (Piont g: this.getGrille().getEnsemblePiont()){
			if (g instanceof Goal){
				goal=g;
			}
		}
		for (Piont b: this.getGrille().getEnsemblePiont()){
			if (b instanceof Bot){
				assert goal != null;
				if(b.getColor().equals(goal.getColor())){
					player=b;
				}
			}
		}
		int playerX = this.getPosPionts().get(player).get(0);
		int playerY = this.getPosPionts().get(player).get(1);
		assert goal != null;
		return Math.abs((goal.getX()-playerX))+Math.abs((goal.getY()-playerY));
	}

	public void clean(){
		this.grille.clear();
		this.grille.getEnsemblePiont().clear();
		fireChangement();
	}

	/***
	 * On genere un ensemble de piont aleatoire que l'on dispose sur la grille.
	 */
	public void ensembleAlea(){
		HashSet<Piont> ensemble_alea = new  HashSet<>();
		Random random = new Random();

		Bot botBlue = new Bot(0,0,"Blue");
		Bot botRed = new Bot (0,0,"Red");
		Bot botGreen = new Bot (0,0,"Green");
		Bot botYellow = new Bot (0,0,"Yellow");
		ArrayList<Piont> ensemble_bot=new ArrayList<>();
		ensemble_bot.add(botBlue);
		ensemble_bot.add(botRed);
		ensemble_bot.add(botGreen);
		ensemble_bot.add(botYellow);
		int nb_bot = 2 + random.nextInt(3);
		Piont rand = new Piont(0,0);
		for (int i=0;i<=nb_bot;i++){
			int index_bot = random.nextInt(4);
			Piont bot = ensemble_bot.get(index_bot);
			int x = 1 + random.nextInt(this.getGrille().getNC()-2);
			int y = 1 + random.nextInt(this.getGrille().getNC()-2);
			bot.setX(x);
			bot.setY(y);
			ensemble_alea.add(bot);
			rand=bot;
		}
		ensemble_alea.add(new Goal(1 + random.nextInt(this.getGrille().getNC()-2),1 + random.nextInt(this.getGrille().getNC()-2), rand.getColor()));

		ArrayList<Piont> ensemble_mirror=new ArrayList<>();
		Mirror redMirrorH = new Mirror(0,0,"Red",'h');
		Mirror redMirrorT = new Mirror(0,0,"Red",'t');
		Mirror yellowMirrorH = new Mirror(0,0,"Yellow",'h');
		Mirror yellowMirrorT = new Mirror(0,0,"Yellow",'t');
		Mirror blueMirrorH = new Mirror(0,0,"Blue",'h');
		Mirror blueMirrorT = new Mirror(0,0,"Blue",'t');
		Mirror greenMirrorH = new Mirror(0,0,"Green",'h');
		Mirror greenMirrorT = new Mirror(10,24,"Green",'t');
		ensemble_mirror.add(redMirrorH);
		ensemble_mirror.add(redMirrorT);
		ensemble_mirror.add(yellowMirrorH);
		ensemble_mirror.add(yellowMirrorT);
		ensemble_mirror.add(blueMirrorH);
		ensemble_mirror.add(blueMirrorT);
		ensemble_mirror.add(greenMirrorH);
		ensemble_mirror.add(greenMirrorT);

		int nb_mirror = 2 + random.nextInt(5);
		for (int i=0;i<=nb_mirror;i++){
			int index_mirror = random.nextInt(8);
			Piont mirror = ensemble_mirror.get(index_mirror);
			int x = 1 + random.nextInt(this.getGrille().getNC()-2);
			int y = 1 + random.nextInt(this.getGrille().getNC()-2);
			mirror.setX(x);
			mirror.setY(y);
			ensemble_alea.add(mirror);
		}
		Grille new_grille = new Grille(this.getGrille().getNL());
		new_grille.setEnsemblePiont(ensemble_alea);
		this.setGrille(new_grille);
	}
}
