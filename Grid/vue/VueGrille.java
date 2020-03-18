package	src.vue;

import src.modele.pionts.*;
import src.modele.*;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Object;



public class VueGrille extends JPanel {

    private State jeu;



	GridLayout grid = new GridLayout(20,20,3,4);

	public VueGrille(State jeu){
        this.jeu=jeu;
		this.setLayout(grid);



		  // Boucle permettant de creer les cases
       for (int i =0; i<this.jeu.getGrille().getNC(); i++){
            for (int j =0; j<this.jeu.getGrille().getNL(); j++){
                this.add(new Case(this.jeu.getGrille().getGrille()[i][j]));
                



            }
        }



         this.setVisible(true); //permet que la fenetre soit visible

    }


	}
