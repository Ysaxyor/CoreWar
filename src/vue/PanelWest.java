package	src.vue;


import src.modele.*;
import src.controller.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;



public class PanelWest extends JPanel{

	private Boolean menuON = false;
	private JButton gene= new JButton("Generation");
	private BClean clean;
	private Component rigidareaW = Box.createRigidArea(new Dimension(95,30));



	public PanelWest(State jeu){

		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

		this.setBorder(new EmptyBorder(new Insets(100,100,100,100))); // Top:left:bottom:right

		this.add(gene);
		this.add(Box.createRigidArea(new Dimension(0,100)));

		this.clean= new BClean(jeu);

		this.add(clean);
		this.add(rigidareaW);

		isMenu();


	}


	public void isMenu(){

		if (menuON){
			rigidareaW.setVisible(false);
			gene.setVisible(true);
			clean.setVisible(true);
				}
		else{

			rigidareaW.setVisible(true);
			gene.setVisible(false);
			clean.setVisible(false);

		}

	}

	public void setMenu(){

		menuON= !menuON;
	}
}
