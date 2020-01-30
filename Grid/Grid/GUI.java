package grid;


import javax.swing.*;
import java.util.*;
import java.awt.*;



public class GUI extends JFrame{

	// La fenetre
	public GUI(){
		this.setTitle("Solveur"); // Titre de la Fenetre
		this.setSize(1286,829); // Taille de la fenetre (Longueur, Hauteur)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Lorsque on clique sur fermer, notre application est EXTERMINER
		this.setVisible(true); //permet que la fenetre soit visible
		this.setResizable(false);

		Board board = new Board();
		this.setContentPane(board);
	}

	public class Board extends JPanel {
		// L'interieur de la fenetre
		public void paintComponent(Graphics g){
			g.setColor(Color.red); // couleur
			g.fillRect(0,0,1280,80); // Methode qui crée un rectangle,




		}



	}

}