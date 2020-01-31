package grid;


import javax.swing.*;
import java.util.*;
import java.awt.*;



public class GUI extends JFrame{

	int spacing = 5; // Constante qui decide l'ecart entre chaque case

	// La fenetre
	public GUI(){
		this.setTitle("Solveur"); // Titre de la Fenetre
		this.setSize(1286,829); // Taille de la fenetre (Longueur, Hauteur)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Lorsque on clique sur fermer, notre application est EXTERMINER
		this.setVisible(true); //permet que la fenetre soit visible
		this.setResizable(true);

		Board board = new Board();
		this.setContentPane(board);
	}

	public class Board extends JPanel {
		// L'interieur de la fenetre
		public void paintComponent(Graphics g){
			g.setColor(Color.DARK_GRAY); // couleur du background
			g.fillRect(0,0,1286,829); // Methode qui crée un rectangle, (Coordoné x, Coordoné y, largeur, hauteur)
			g.setColor(Color.gray); // Couleur des case
			for (int i =0; i<16; i++){ // 16 case de largeur
				for (int j =0;j<9;j++){ // 9 case de hauteur
					g.fillRect(spacing+i*80 , spacing+j*80+80 , 80-2*spacing , 80-2*spacing ); // 80-2*spacing permet que il n'y est pas de collision entre les cases
				}

			}

		}



	}

}
