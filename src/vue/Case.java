package	src.vue;

import src.modele.pionts.*;
import javax.swing.*;
import java.awt.*;


public class Case extends JPanel{

	private Piont subject;

	public Case(Piont subject){
		super();
		this.subject=subject;

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

		if(this.subject instanceof Mirror){
			int x1; int x2; int y1; int y2;
			int width = 8;
			Graphics2D g2D = (Graphics2D) g;
			g2D.setStroke(new BasicStroke(width));
			if(this.subject.getSens().equals('t')){
				x1 = 0;
				y1 = this.getHeight();
				x2 = this.getWidth();
				y2 = 0;
			}else{
				x1 = 0;
				y1 = 0;
				x2 = this.getWidth();
				y2 = this.getHeight();
			}

			if(colorSubject.equals("Red")){
				g2D.setColor(Color.RED);
				g2D.drawLine(x1,y1,x2,y2);
			}
			if(colorSubject.equals("Blue")){
				g2D.setColor(Color.BLUE);
				g2D.drawLine(x1,y1,x2,y2);
			}
			if(colorSubject.equals("Green")){
				g2D.setColor(Color.GREEN);
				g2D.drawLine(x1,y1,x2,y2);
			}
			if(colorSubject.equals("Yellow")){
				g2D.setColor(Color.YELLOW);
				g2D.drawLine(x1,y1,x2,y2);
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
			if(colorSubject.equals("Green")){
				g.setColor(Color.GREEN);
				g.fillRect(0,0,this.getWidth(),this.getHeight());
			}
			if(colorSubject.equals("Yellow")){
				g.setColor(Color.YELLOW);
				g.fillRect(0,0,this.getWidth(),this.getHeight());
			}
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
			if(colorSubject.equals("Green")){
				g.setColor(Color.GREEN);
				g.fillOval(0,0,this.getWidth(),this.getHeight());
			}
			if(colorSubject.equals("Yellow")){
				g.setColor(Color.YELLOW);
				g.fillOval(0,0,this.getWidth(),this.getHeight());
			}
		}

	}

		
}

