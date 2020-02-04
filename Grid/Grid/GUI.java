package grid;


import javax.swing.*;
import java.util.*;
import java.awt.*;



public class GUI extends JFrame{

	int spacing = 5; // Constante qui decide l'ecart entre chaque case
	GridLayout grid = new GridLayout(20,20,4,3);

	JFrame frame = new JFrame();
	// La fenetre
	public GUI(){
		frame.setTitle("Solveur"); // Titre de la Fenetre
		frame.setSize(1500,1000); // Taille de la fenetre (Longueur, Hauteur)
		frame.setMinimumSize(new Dimension(1286,829));
		//frame.setExtendedState(frame.MAXIMIZED_BOTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Lorsque on clique sur fermer, notre application est EXTERMINER
		frame.setVisible(true); //permet que la fenetre soit visible
		frame.setResizable(true); // Permet de resize la fenetre
		frame.setLayout(new BorderLayout());

		

		
		 
		JPanel panel = new JPanel();
		frame.add(panel,BorderLayout.CENTER); // Panel de la grille centré
     		panel.setLayout(grid);

		/////
		
		
		//box.add( label1 );



		//////

		Component rigidareaN = Box.createRigidArea(new Dimension(200,200)); // "Mur invisible" Situé au Nord
		Component rigidareaS = Box.createRigidArea(new Dimension(30,30));// "Mur invisible" Situé au Sud
		Component rigidareaE = Box.createRigidArea(new Dimension(30,30));// "Mur invisible" Situé au EST
		Component rigidareaW = Box.createRigidArea(new Dimension(30,30));// "Mur invisible" Situé au OUEST


		frame.add(rigidareaN, BorderLayout.NORTH);  // Ajout des "Mur Invisible" au Nord
		frame.add(rigidareaS, BorderLayout.SOUTH); // Ajout des "Mur Invisible" au Sud
		frame.add(rigidareaE, BorderLayout.EAST); // Ajout des "Mur Invisible" EST
		frame.add(rigidareaW, BorderLayout.WEST); // Ajout des "Mur Invisible" OUEST

		

		for (int i =0; i<400; i++){ // Boucle permettant de creer les cases
				JLabel label1 = new JLabel( "mur" );  // Commentaire dans la box
				label1.setMaximumSize(new Dimension(Integer.MAX_VALUE, label1.getMinimumSize().height)); // 
				label1.setOpaque( true ); // Background du label
				label1.setBackground( Color.GRAY ); // couleur du background du label
				label1.setForeground( Color.BLACK ); // couleur du texte
		
				Box box = Box.createHorizontalBox(); 
				box.add(label1);
				panel.add(box); // Ajout des case sur la grille

			}
	}
}
