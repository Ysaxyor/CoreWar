package src.controller;

import src.modele.*;
import javax.swing.*;
import java.awt.event.*;

public class BGeneration extends JButton implements ActionListener{

    private State jeu;

    public BGeneration(State jeu){

        super("Generation");
        this.jeu=jeu;
        this.addActionListener(this);

    }


    public void actionPerformed(ActionEvent e){
        Grille new_grille = new Grille(this.jeu.getGrille().getNL());
        new_grille.setEnsemblePiont(this.jeu.getGrille().getEnsemblePiont());
        this.jeu.setGrille(new_grille);
    }


}