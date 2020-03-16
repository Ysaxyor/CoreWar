package solveur.vue;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Object;



public class VueGrille extends JPanel {



	GridLayout grid = new GridLayout(20,20,3,4);

	public VueGrille(){

		this.setLayout(grid);



		  // Boucle permettant de creer les cases
       for (int i =0; i<400; i++){ 
                JLabel label1 = new JLabel();  // Commentaire dans la box
                label1.setMaximumSize(new Dimension(30,50)); // Taille des cases
                label1.setOpaque( true ); // Background du label
                label1.setBackground( Color.GRAY ); // couleur du background du label
                label1.setForeground( Color.BLACK ); // couleur du texte
        		label1.setVisible(true);

                Box box = Box.createHorizontalBox();  // Creation de la box
                box.add(label1); // Ajout du texte sur la case
                this.add(box); // Ajout des case sur la grille



               

            }
        

       
         this.setVisible(true); //permet que la fenetre soit visible

    }


	}
