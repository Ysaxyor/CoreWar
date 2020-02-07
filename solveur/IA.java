package solveur;
import java.lang.Math;
import solveur.pionts.*;

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
    Integer playerX=this.etat.getPosPionts().get(player).get(0);
    Integer playerY=this.etat.getPosPionts().get(player).get(1);
    if (type){
      return Math.sqrt(Math.pow((goal.getX()-playerX),2) + Math.pow((goal.getY()-playerY),2));
    }
    return Math.abs((goal.getX()-playerX))+Math.abs((goal.getY()-playerY));
  }
  public double getDistance(Goal goal,Bot player){
    return this.getDistance(goal,player,false);
  }
}
