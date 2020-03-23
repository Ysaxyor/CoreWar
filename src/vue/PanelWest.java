package	src.vue;


import src.modele.*;
import src.controller.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;



public class PanelWest extends JPanel{

	private Boolean menuON = false;
	private BClean clean;
	private BGeneration generation;
	private Component rigidareaW = Box.createRigidArea(new Dimension(95,30));



	public PanelWest(State jeu){

		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setBorder(new EmptyBorder(new Insets(100,100,100,100))); // Top:left:bottom:right
		this.generation=new BGeneration(jeu);
		this.clean= new BClean(jeu);


		this.add(generation);
		this.add(Box.createRigidArea(new Dimension(0,50)));
		this.add(clean);
		this.add(rigidareaW);

		isMenu();


	}


	public void isMenu(){

		if (menuON){
			rigidareaW.setVisible(false);
			generation.setVisible(true);
			clean.setVisible(true);
				}
		else{

			rigidareaW.setVisible(true);
			generation.setVisible(false);
			clean.setVisible(false);

		}

	}

	public void setMenu(){

		menuON= !menuON;
	}
}
