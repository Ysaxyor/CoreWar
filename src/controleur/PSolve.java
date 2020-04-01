package src.controleur;

import src.modele.pionts.Piont;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PSolve extends JPanel {

    private BSolve bsolve;
    private int indexS;
    private int indexP;
    private HashMap<Piont, ArrayList<Integer>> save;
    public static boolean first=true;

    public PSolve(BSolve bsolve){
        super();
        this.bsolve=bsolve;
        this.add(bsolve);

        //test


        //Bouton ETAT suivant
        JButton etatSuiv = new JButton("Etat suivant");
        this.indexS = 1;


        etatSuiv.addActionListener(e -> {
            if (this.bsolve.getListeEtats() != null){
                if (first){
                    this.save=bsolve.getListeEtats().get(0).getValeur().getPosPionts();
                    first=false;
                    this.indexS=1;
                    this.indexP=1;
                }
                if (this.indexS >= this.bsolve.getListeEtats().size()) {
                    this.indexS = 0;
                    first=true;
                }

                if(this.indexS==0){
                    bsolve.getJeu().setPosPionts(this.save);
                    }
                else{
                    bsolve.getJeu().setPosPionts(bsolve.getListeEtats().get(indexS).getValeur().getPosPionts());
                }

                this.indexP = this.indexS-1;
                this.indexS += 1;
                }
            else{
                JOptionPane.showMessageDialog(null, "Jeu insoluble (ou calcul trop long)! " +
                        System.getProperty("line.separator")+" Veuillez générer un nouveau jeu via le menu.");
            }
        });
        this.add(etatSuiv);

        //Bouton ETAT precedant
        JButton etatPrec = new JButton("Etat precedent");

        this.indexP = 0;
        etatPrec.addActionListener(e -> {
            if (this.bsolve.getListeEtats() != null) {
                if (first){
                    this.save=bsolve.getListeEtats().get(0).getValeur().getPosPionts();
                    first=false;
                }
                if (this.indexP <= 0) {
                    bsolve.getJeu().setPosPionts(this.save);
                    first=true;
                    this.indexP = this.bsolve.getListeEtats().size();
                }else{
                    bsolve.getJeu().setPosPionts(bsolve.getListeEtats().get(indexP).getValeur().getPosPionts());
                }
                this.indexS = this.indexP+1;
                this.indexP -= 1;
            }else{
                JOptionPane.showMessageDialog(null, "Jeu insoluble (ou calcul trop long)! " +
                        System.getProperty("line.separator")+" Veuillez générer un nouveau jeu via le menu.");
            }
        });

        this.add(etatPrec);

    }

}
