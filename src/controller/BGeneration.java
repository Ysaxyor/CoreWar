package src.controller;

import src.modele.*;
import src.modele.pionts.*;
import src.controller.*;
import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class BGeneration extends JButton implements ActionListener{

    private State jeu;
    private BSolve bsolve;

    public BGeneration(State jeu){

        super("Generation");
        this.jeu=jeu;
        this.addActionListener(this);

    }


    public HashSet<Piont> ensembleAlea(){
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
            int x = 1 + random.nextInt(this.jeu.getGrille().getNC()-2);
            int y = 1 + random.nextInt(this.jeu.getGrille().getNC()-2);
            bot.setX(x);
            bot.setY(y);
            ensemble_alea.add(bot);
            rand=bot;
        }
        ensemble_alea.add(new Goal(1 + random.nextInt(this.jeu.getGrille().getNC()-2),1 + random.nextInt(this.jeu.getGrille().getNC()-2), rand.getColor()));

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
            int x = 1 + random.nextInt(this.jeu.getGrille().getNC()-2);
            int y = 1 + random.nextInt(this.jeu.getGrille().getNC()-2);
            mirror.setX(x);
            mirror.setY(y);
            ensemble_alea.add(mirror);
        }


        return ensemble_alea;
    }

    public void actionPerformed(ActionEvent e){
        Grille new_grille = new Grille(this.jeu.getGrille().getNL());
        new_grille.setEnsemblePiont(this.ensembleAlea());
        this.jeu.setGrille(new_grille);
        bsolve = new BSolve(jeu);
    }


}
