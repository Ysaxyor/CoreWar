package src.modele.ia;

import java.lang.Math;
import java.util.*;
import src.modele.*;
import src.modele.pionts.*;

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
/*
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
*/
  public ArrayList<Node> aEtoile(){

    Node current = new Node(this.etat);
    PriorityQueue<Node> open = new PriorityQueue<>(new Compare2Node());
    HashSet<Node> closed = new HashSet<>();
    ArrayList<Node> path = new ArrayList<>();
    open.add(current);
    while(! open.isEmpty()){
      current = open.poll();
      new GraphState(current);
      closed.add(current);
      if (current.getValeur().isFinished()){
        path.add(current);
        break;
      }
      for (Node fils: current.getFils()){
        if (closed.contains(fils)){
          continue;
        }
        if(current.getEval()>fils.getEval() || ! open.contains(fils)){
          fils.setPere(current);
          if(!open.contains(fils)){
            open.add(fils);
          }
        }
      }
    }
    while(current.getPere()!=null){
      path.add(current.getPere());
      current=current.getPere();
    }
    Collections.reverse(path);
    return path;
}


















}
