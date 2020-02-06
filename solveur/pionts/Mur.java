package solveur.pionts;

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


}
