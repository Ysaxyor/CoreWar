package solveur.ia;

import java.lang.Math;
import java.util.*;
import solveur.*;
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
  public HashSet<Node> algo(){

    Node current = new Node(this.etat);
    PriorityQueue<Node> open = new PriorityQueue<>(new Compare2Node());
    HashSet<Node> closed = new HashSet<>();
    open.add(current);
    while(! open.isEmpty()){
      current = open.poll();
      System.out.println(current);
      current.getValeur().affiche();
      new GraphState(current);
      closed.add(current);

      for(Node noeud: current.getFils()){
        if(closed.contains(noeud)){
          continue;
        }
        if(current.getEval()>noeud.getEval() || ! open.contains(noeud)){
          noeud.setCout(current.getCout()+1);
          noeud.setPere(current);
          if(! open.contains(noeud)){
            open.add(noeud);
          }
        }
      }
    }
    return closed;
}


















}
