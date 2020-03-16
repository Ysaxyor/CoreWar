package solveur.vue;


import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Object;



public class PanelWest extends JPanel{

	private Boolean menuON = false;
	private JButton gene= new JButton("Generation");
	private JButton clean= new JButton("Clean");
	private Component rigidareaW = Box.createRigidArea(new Dimension(95,30));



	public PanelWest(){

		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

		this.setBorder(new EmptyBorder(new Insets(100,100,100,100))); // Top:left:bottom:right

		this.add(gene);
		this.add(Box.createRigidArea(new Dimension(0,100)));
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

		if (menuON){

			menuON=false;
		}
		else{
			menuON=true;
		}
	}
}