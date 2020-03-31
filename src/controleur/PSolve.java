package src.controleur;

import javax.swing.*;
import java.util.HashMap;

public class PSolve extends JPanel {

    private BSolve bsolve;
    private int indexS;
    private int indexP;

    public PSolve(BSolve bsolve){
        super();
        this.bsolve=bsolve;
        this.add(bsolve);

        //test



        //Bouton ETAT suivant
        JButton etatSuiv = new JButton("Etat suivant");
        this.indexS = 1;

        etatSuiv.addActionListener(e -> {
            if (PSolve.this.bsolve.getListeEtats() != null) {
                if (PSolve.this.indexS >= PSolve.this.bsolve.getListeEtats().size()+1) {
                    PSolve.this.indexS = 1;
                }
                System.out.println(PSolve.this.indexS);
                PSolve.this.bsolve.getJeu().setPosPionts(PSolve.this.bsolve.getListeEtats().get(PSolve.this.indexS).getPosPionts());
                PSolve.this.bsolve.getListeEtats().get(PSolve.this.indexS).affiche();
                PSolve.this.indexS += 1;
            }else{
                JOptionPane.showMessageDialog(null, "Jeu insoluble ! Veuillez générer un nouveau jeu via le menu");
            }

        });
        this.add(etatSuiv);

        //Bouton ETAT precedant
        JButton etatPrec = new JButton("Etat precedent");

        this.indexP = 1;
        etatPrec.addActionListener(e -> {
            if (PSolve.this.bsolve.getListeEtats() != null) {
                if (PSolve.this.indexP == 0) {
                    PSolve.this.indexP = PSolve.this.bsolve.getListeEtats().size();
                }

                PSolve.this.bsolve.getJeu().setPosPionts(PSolve.this.bsolve.getListeEtats().get(PSolve.this.indexP).getPosPionts());
                PSolve.this.bsolve.getListeEtats().get(PSolve.this.indexP).affiche();
                PSolve.this.indexP -= 1;
            }else{
                JOptionPane.showMessageDialog(null, "Jeu insoluble ! Veuillez générer un nouveau jeu via le menu");
            }
        });

        this.add(etatPrec);

    }

}
