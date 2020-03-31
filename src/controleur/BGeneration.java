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

    public void actionPerformed(ActionEvent e){
        this.jeu.ensembleAlea();
    }


}
