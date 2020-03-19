package	src.vue;

import src.modele.pionts.*;
import javax.swing.*;
import java.awt.*;


public class Case extends JPanel{

	private Piont subject;

	public Case(Piont subject){
		super();
		this.subject=subject;
		//this.setBackground(Color.BLACK);

	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		String colorSubject =this.subject.getColor();

		g.setColor(Color.GRAY);
		g.fillRect(0,0,this.getWidth(),this.getHeight());


		if(this.subject instanceof Mur){
			g.setColor(Color.BLACK);
			g.fillRect(0,0,this.getWidth(),this.getHeight());
		}

		if(this.subject instanceof Bot){

			if(colorSubject.equals("Blue")){
				g.setColor(Color.BLUE);
				g.fillOval(0,0,this.getWidth(),this.getHeight());
			}
			if(colorSubject.equals("Red")){
				g.setColor(Color.RED);
				g.fillOval(0,0,this.getWidth(),this.getHeight());
			}
		}

		if(this.subject instanceof Mirror){
			if(colorSubject.equals("Red")){
				g.setColor(Color.RED);
				g.fillRect(0,0,this.getWidth(),this.getHeight());
			}
			if(colorSubject.equals("Blue")){
				g.setColor(Color.BLUE);
				g.fillRect(0,0,this.getWidth(),this.getHeight());
			}
		}

		if(this.subject instanceof Goal){
			if(colorSubject.equals("Red")){
					g.setColor(Color.RED);
					g.fillRect(0,0,this.getWidth(),this.getHeight());
				}
			if(colorSubject.equals("Blue")){
				g.setColor(Color.BLUE);
				g.fillRect(0,0,this.getWidth(),this.getHeight());
			}
		}

	}

		
}

