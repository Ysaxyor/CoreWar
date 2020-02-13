package grid;


import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;



public class GUI extends JFrame implements ActionListener{

	
	GridLayout grid = new GridLayout(20,20,3,4);
	JButton b2 = new JButton("Menu");

	JFrame frame = new JFrame();
     JPanel panel_menu = new JPanel();
    
    //


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

         //Panel menu
        panel_menu.setBackground(Color.blue);
	    frame.add(panel_menu,BorderLayout.WEST); 
     	panel_menu.setLayout(new FlowLayout());

     	//


		/// Les Boutons

		JButton b1 = new JButton("Solve game");
        frame.add(b1,BorderLayout.NORTH);
        b1.setBounds(500,50,200,100); 
       // b1.setSize(105,100);
        b1.setVisible(true);


        
        /// Bouton avec Action listener
        JButton b2 = new JButton("Menu");
        
        b2.setBounds(1000,50,200,100); 
       // b2.setSize(100,100);
        b2.addActionListener(this);
        frame.add(b2,BorderLayout.NORTH);
        b2.setVisible(true);

		


		///
		 
		JPanel panel = new JPanel();
		frame.add(panel,BorderLayout.CENTER); // Panel de la grille centré
     		panel.setLayout(grid);

		/////
		
		
        



		//////

		Component rigidareaN = Box.createRigidArea(new Dimension(200,200)); // "Mur invisible" Situé au Nord
		Component rigidareaS = Box.createRigidArea(new Dimension(30,30));// "Mur invisible" Situé au Sud
		Component rigidareaE = Box.createRigidArea(new Dimension(30,30));// "Mur invisible" Situé au EST
		
				

		frame.add(rigidareaN, BorderLayout.NORTH);  // Ajout des "Mur Invisible" au Nord
		frame.add(rigidareaS, BorderLayout.SOUTH); // Ajout des "Mur Invisible" au Sud
		frame.add(rigidareaE, BorderLayout.EAST); // Ajout des "Mur Invisible" EST
		

		///	MENU BOUTONS

		//Component rigidareaW = Box.createRigidArea(new Dimension(100,100));// "Mur invisible" Situé au OUEST
		//panel_menu.add(rigidareaW, BorderLayout.WEST); // Ajout des "Mur Invisible" OUESt


		JButton bgen = new JButton("Generation");
        		panel_menu.add(bgen,FlowLayout.LEFT);
        		bgen.setBounds(8,50,100,100);
        		bgen.setVisible(false);   

        JButton bclean = new JButton("Clean");
        		panel_menu.add(bclean,FlowLayout.LEFT);
        		bclean.setBounds(8,50,100,100);
        		bclean.setVisible(false);  

         JButton bclose = new JButton("Close");
        		panel_menu.add(bclose,FlowLayout.LEFT);
        		bclose.setBounds(8,50,100,100);
        		bclose.setVisible(false);

		///
		

		for (int i =0; i<400; i++){ // Boucle permettant de creer les cases
				JLabel label1 = new JLabel( "mur" );  // Commentaire dans la box
				label1.setMaximumSize(new Dimension(50, 50)); // 
				label1.setOpaque( true ); // Background du label
				label1.setBackground( Color.GRAY ); // couleur du background du label
				label1.setForeground( Color.BLACK ); // couleur du texte
		
				Box box = Box.createHorizontalBox(); 
				box.add(label1);
				panel.add(box); // Ajout des case sur la grille

			}
	}

    /// Methode qui est censé faire "pousser" la grille vers la droite
	public void actionPerformed(ActionEvent e){


				//Component rigidareaW = Box.createRigidArea(new Dimension(100,100));// "Mur invisible" Situé au OUEST
				//panel_menu.add(rigidareaW, BorderLayout.WEST); // Ajout des "Mur Invisible" OUESt

                
              
				JButton bgen = new JButton("Generation");
        		panel_menu.add(bgen,FlowLayout.LEFT);
        		//bgen.setBounds(8,50,100,100);         		
        		bgen.setVisible(true);

        		JButton bclean = new JButton("Clean");
        		panel_menu.add(bclean,FlowLayout.LEFT);
        		//bclean.setBounds(8,50,100,100);        		
        		bclean.setVisible(true);

                JButton bclose = new JButton("Close");
        		panel_menu.add(bclose,FlowLayout.LEFT);
        		//bclose.setBounds(8,50,100,100);
        		bclose.setVisible(true); 

        		panel_menu.setVisible(true);

        		bclose.addActionListener(new ActionListener()
        		{     		
        		
        		
        		public void actionPerformed(ActionEvent event)
        		{
        			panel_menu.setVisible(false);
        			bgen.setVisible(false);
        			bclean.setVisible(false);
        			bclose.setVisible(false);
        		}
        	});

        		





		}

}


// Pour le menu:
    // pour fermer le menu
    // Boutton:generation
    //bouton: clean (mise a zero de la grille)
    // 
