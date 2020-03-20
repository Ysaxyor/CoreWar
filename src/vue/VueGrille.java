package	src.vue;

import src.modele.*;
import javax.swing.*;
import java.awt.*;



public class VueGrille extends JPanel implements EcouteurModele{

    private State jeu;


	public VueGrille(State jeu){
        this.jeu=jeu;
        this.jeu.ajoutEcouteur(this);
		this.setLayout(new GridLayout(this.jeu.getGrille().getNL(),this.jeu.getGrille().getNC(),3,4));

		this.setup();


        this.setVisible(true); //permet que la fenetre soit visible

    }

    public void modeleMisAJour(Object source){
        this.repaint();

        for (Component c: this.getComponents()){
            this.remove(c);
           

        }
         this.setup();
            this.revalidate();

    }

    public void setup(){

        // Boucle permettant de creer les cases
        for (int i =0; i<this.jeu.getGrille().getNC(); i++){
            for (int j =0; j<this.jeu.getGrille().getNL(); j++){
                this.add(new Case(this.jeu.getGrille().getGrille()[i][j]));
            }
        }


    }


	}
