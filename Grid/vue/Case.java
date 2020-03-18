package	src.vue;

import src.modele.*;
import src.modele.pionts.*;

import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Object;





public class Case extends JPanel{

	private Piont subject;
	private State state;


	public Case(Piont subject){
		super();
		this.subject=subject;
		//this.setBackground(Color.BLACK);

	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		g.setColor(Color.GRAY);
		g.fillRect(0,0,this.getWidth(),this.getHeight());

		if(this.subject instanceof Mur){
			g.setColor(Color.BLACK);
			g.fillRect(0,0,this.getWidth(),this.getHeight());
		}

		if(this.subject instanceof Bot){

			String colorBot =this.subject.getColor(); 


			if(colorBot.equals("Blue")){
					g.setColor(Color.BLUE);
					g.fillOval(0,0,this.getWidth(),this.getHeight());
				}
				if(colorBot.equals("Red")){
					g.setColor(Color.RED);
					g.fillOval(0,0,this.getWidth(),this.getHeight());
				
			}
		}

		if(this.subject instanceof Mirror){
			String colorMirror = this.subject.getColor();

			if(colorMirror.equals("Red")){
					g.setColor(Color.RED);
					g.fillRect(0,0,this.getWidth(),this.getHeight());
				}
				if(colorMirror.equals("Blue")){
					g.setColor(Color.BLUE);
					g.fillRect(0,0,this.getWidth(),this.getHeight());
				
			} 
		}

		if(this.subject instanceof Goal){
			String colorGoal = this.subject.getColor();

			if(colorGoal.equals("Red")){
					g.setColor(Color.RED);
					g.fillRect(0,0,this.getWidth(),this.getHeight());
				}
				if(colorGoal.equals("Blue")){
					g.setColor(Color.BLUE);
					g.fillRect(0,0,this.getWidth(),this.getHeight());
				
			} 
		}

			


		}

		
	}

