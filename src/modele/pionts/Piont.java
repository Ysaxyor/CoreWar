package src.modele.pionts;

public class Piont{
  private int x;
  private int y;
  private char symbole;

  public Piont(int x, int y, char symbole){
    this.x=x;
    this.y=y;
    this.symbole=symbole;
  }
  //Instance par defaut; représente une case "vide"
  public Piont(int x,int y){
    this(x,y,'.');
  }


  //Getters
  public int getX(){
    return this.x;
  }
  public int getY(){
    return this.y;
  }
  public char getSymbole(){
    return this.symbole;
  }
  public String getColor(){
    return "None";
  }
  public Character getSens(){
    return null;
  }
  //Setters
  public void setX(int x){
    this.x=x;
  }
  public void setY(int y){
    this.y=y;
  }

  //Methodes

  public boolean collision(Piont p){
    return false;
  };
}
