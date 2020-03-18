package	src.vue;

import src.modele.*;
import src.modele.pionts.*;


import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Object;



public class Vue extends JFrame  {

    private State jeu;
	GridLayout grid = new GridLayout(20,20,3,4);


   private PanelWest pw2;



     public Vue(State jeu){
        this.jeu=jeu;

     	 Component rigidareaE = Box.createRigidArea(new Dimension(200,30));

     	//rigidareaW.setBackground(Color.RED);


     	  this.setLayout(new BorderLayout()); // Fonction qui permet de choisir la position elements N,W,E,S

     	  	 this.add(rigidareaE,BorderLayout.EAST);


         this.add(new VueGrille(this.jeu),BorderLayout.CENTER);



         pw2= new PanelWest();
         this.add(new PanelNord(pw2),BorderLayout.NORTH);

       	 this.add(pw2,BorderLayout.WEST);


        this.setTitle("Solveur"); // Titre de la Fenetre
        this.setSize(1500,1000); // Taille de la fenetre (Longueur, Hauteur)
        this.setMinimumSize(new Dimension(1286,829)); // Taille Minimum de la fenetre



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Lorsque on clique sur fermer, la fenetre se ferme

        this.setResizable(true); // Permet de resize la fenetre




       this.setVisible(true); //permet que la fenetre soit visible









}
}
