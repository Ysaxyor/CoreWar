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
  public HashSet<State> algo(State current){
    HashSet<State> open = new HashSet<>();
    HashSet<State> closed = new HashSet<>();
    open.add(current);
    while(! open.isEmpty()){
      current.affiche();
      for (State s: open){
        if (current.getEval()>s.getEval()){
          current=s;
        }
      }
      if (open.contains(current)){
        open.remove(current);
      }
      closed.add(current);

      for(State s: current.etatFuturs()){
        if (closed.contains(s)){
          continue;
        }
        if (s.getEval()<current.getEval() || ! open.contains(s)){

          if(! open.contains(s)){
            open.add(s);
          }
        }
      }
    }

    return open;
  }

















}
