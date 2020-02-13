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
  public HashSet<Node> algo(Node current){

    PriorityQueue<Node> open = new PriorityQueue<>(new Compare2Node());
    HashSet<Node> closed = new HashSet<>();
    HashSet<Node> path = new HashSet<>();
    path.add(current);

    while(! open.isEmpty()){

      for (Node noeud: current.getFils()){
        open.add(noeud);
      }
      current=open.poll();
      //genere le graph a partir du noeud current (lui attribut des fils);
      GraphState newt = new GraphState(current);
      closed.add(current);
      if (current.getHeuristique()==0){
        path.add(current);
        return path;
      }


//A REVOIR
      for(Node noeud: current.getFils()){
        if (closed.contains(noeud)){
          continue;
        }
        if (noeud.getEval()<current.getEval() || ! open.contains(noeud)){
          noeud.setPere(current);
          if(! open.contains(noeud)){
            open.add(noeud);
          }
        }
      }
    }
    return path;
  }

















}
