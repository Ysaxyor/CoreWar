package grid;


import javax.swing.*;
import java.util.*;
import java.awt.*;



public class GUI extends JFrame{
	GridLayout grid = new GridLayout(24,24,3,4); // Grille 24x24 , espacé de 5 horizontalement et 4 verticalement

	JFrame frame = new JFrame();
	// La fenetre
	public GUI(){
		frame.setTitle("Solveur"); // Titre de la Fenetre
		frame.setSize(1400,900); // Taille de la fenetre (Longueur, Hauteur)
		frame.setMinimumSize(new Dimension(1286,829));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Lorsque on clique sur fermer, notre application est EXTERMINER
		frame.setVisible(true); //permet que la fenetre soit visible
		frame.setResizable(true); // Permet de resize la fenetre
		frame.setLayout(new BorderLayout());

		

		
		 
		JPanel panel = new JPanel();
		frame.add(panel,BorderLayout.CENTER); // Panel de la grille centré
     		panel.setLayout(grid);

		//
		Component rigidareaN = Box.createRigidArea(new Dimension(200,200)); // "Mur invisible" Situé au Nord
		Component rigidareaS = Box.createRigidArea(new Dimension(30,30));// "Mur invisible" Situé au Sud
		Component rigidareaE = Box.createRigidArea(new Dimension(30,30));// "Mur invisible" Situé au EST
		Component rigidareaW = Box.createRigidArea(new Dimension(30,30));// "Mur invisible" Situé au OUEST


		frame.add(rigidareaN, BorderLayout.NORTH);  // Ajout des "Mur Invisible" au Nord
		frame.add(rigidareaS, BorderLayout.SOUTH); // Ajout des "Mur Invisible" au Sud
		frame.add(rigidareaE, BorderLayout.EAST); // Ajout des "Mur Invisible" EST
		frame.add(rigidareaW, BorderLayout.WEST); // Ajout des "Mur Invisible" OUEST

		

		for (int i =0; i<576; i++){ // Boucle permettant de creer les cases
				panel.add(new JButton()); // Ajout des case sur la grille

			}
	}
}
