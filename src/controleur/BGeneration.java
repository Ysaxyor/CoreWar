package src.controleur;

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
    /***
     * Lorsque l'action est effectuée, on appelle la methode ensembleAlea() du jeu en attribut.
     */
    public void actionPerformed(ActionEvent e){
        this.jeu.ensembleAlea();
    }


}
