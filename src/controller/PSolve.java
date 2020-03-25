package src.controller;

import src.modele.Grille;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PSolve extends JPanel {

    private BSolve bsolve;
    private int indexS;
    private int indexP;

    public PSolve(BSolve bsolve){
        super();
        this.bsolve=bsolve;
        this.add(bsolve);

        JButton etatSuiv = new JButton("Etat suivant");
        this.indexS = 0;
        etatSuiv.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (PSolve.this.indexS >= PSolve.this.bsolve.getListeEtats().size()-1){
                    PSolve.this.indexS =0;
                }
                PSolve.this.bsolve.getListeEtats().get(PSolve.this.indexS).getValeur().affiche();
                Grille new_grille = PSolve.this.bsolve.getJeu().getGrille();
                new_grille.setEnsemblePiont(PSolve.this.bsolve.getListeEtats().get(PSolve.this.indexS).getValeur().getGrille().getEnsemblePiont());
                PSolve.this.bsolve.getJeu().setGrille(new_grille);
                PSolve.this.indexP = PSolve.this.indexS;
                PSolve.this.indexS +=1;
            }
        });
        this.add(etatSuiv);

        JButton etatPrec = new JButton("Etat precedent");
        this.indexP = 0;
        etatPrec.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (PSolve.this.indexP == 0){
                    PSolve.this.indexP = PSolve.this.bsolve.getListeEtats().size()-1;
                }
                Grille new_grille = PSolve.this.bsolve.getJeu().getGrille();
                new_grille.setEnsemblePiont(PSolve.this.bsolve.getListeEtats().get(PSolve.this.indexP).getValeur().getGrille().getEnsemblePiont());
                PSolve.this.bsolve.getJeu().setGrille(new_grille);
                PSolve.this.bsolve.getListeEtats().get(PSolve.this.indexP).getValeur().affiche();
                PSolve.this.indexS = PSolve.this.indexP;
                PSolve.this.indexP -=1;
            }
        });

        this.add(etatPrec);

    }

}
