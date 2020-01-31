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

  public double getDistance(Goal goal, Bot player, Boolean type){
    if (type){
      return Math.sqrt(Math.pow((goal.getX()-player.getX()),2) + Math.pow((goal.getY()-player.getY()),2));
    }
    return Math.abs((goal.getX()-player.getX()))+Math.abs((goal.getY()-player.getY()));
  }
  public double getDistance(Goal goal,Bot player){
    return this.getDistance(goal,player,false);
  }
}
