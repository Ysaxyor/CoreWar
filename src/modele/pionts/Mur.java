package src.modele.pionts;

import java.util.Random;

public class Mur extends Piont{
  private int x;
  private int y;
  private char symbole;

  public Mur(int x, int y, char symbole){
    super(x,y,symbole);
  }
  public Mur(int x, int y){
    this(x,y,'x');
  }
@Override
  public boolean collision(Piont p){
    return true;
  }

  public void setAngle(Piont [][] grille){
    Random random = new Random();
    int a = random.nextInt(2);
    int b = random.nextInt(2);
    if(a == 0){
    	a = -1;
    }
    if(b == 0){
    	b = -1;
    }
    Mur m1 = new Mur(this.getX()+a,this.getY());
    grille[this.getX()+a][this.getY()] = m1;
    Mur m2 = new Mur(this.getX()+a,this.getY()+b);
    grille[this.getX()][this.getY()+b] = m2;

  }


}
