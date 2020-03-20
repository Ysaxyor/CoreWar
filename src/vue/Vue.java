package	src.vue;

import src.modele.*;

import javax.swing.*;
import java.awt.*;



public class Vue extends JFrame  {

    private State jeu;


     public Vue(State jeu){
        this.jeu=jeu;

     	 Component rigidareaE = Box.createRigidArea(new Dimension(200,30));
         PanelWest panelWest= new PanelWest(this.jeu);

         this.setTitle("Solveur"); // Titre de la Fenetre
         this.setSize(1500,1000); // Taille de la fenetre (Longueur, Hauteur)
         this.setMinimumSize(new Dimension(1286,829)); // Taille Minimum de la fenetre
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Lorsque on clique sur fermer, la fenetre se ferme
         this.setResizable(true); // Permet de resize la fenetre


         this.setLayout(new BorderLayout()); // Fonction qui permet de choisir la position elements N,W,E,S

         this.add(new PanelNord(panelWest),BorderLayout.NORTH);             //NORD
         this.add(new VueGrille(this.jeu),BorderLayout.CENTER);             //CENTRE
         this.add(panelWest,BorderLayout.WEST);                             //OUEST
         this.add(rigidareaE,BorderLayout.EAST);                            //EST


        this.setVisible(true); //permet que la fenetre soit visible









}
}
