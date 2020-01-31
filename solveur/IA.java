package solveur;
import java.lang.Math;

public class IA{
  private State etat;

  public IA(State etat){
    this.etat = etat;
  }


  public State getEtat(){
    return this.etat;
  }
  public void setEtat(State etat){
    this.etat=etat;
  }

  public double getDistance(Goal goal, Boolean type){
    if (type){
      return Math.sqrt(Math.pow((goal.getX()-this.etat.getBotX()),2) + Math.pow((goal.getY()-this.etat.getBotY()),2));
    }
    return Math.abs((goal.getX()-this.etat.getBotX()))+Math.abs((goal.getY()-this.etat.getBotY()));
  }
  public double getDistance(Goal goal){
    return this.getDistance(goal,false);
  }
}
