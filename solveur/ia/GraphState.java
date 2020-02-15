package solveur.ia;
import java.util.*;
import solveur.*;

public class GraphState{
  private Node current;
  private int profondeur;

  public GraphState(Node current,int profondeur){
    this.current=current;
    this.profondeur=profondeur;
    this.buildGraph();
  }

  public GraphState(Node current){
    this(current,1);
  }

  public Node getCurrent(){
    return this.current;
  }


//methodes
//si posPiont fils1 == posPiont fils2 -> fils1=fils2
  public void buildGraph(){
    for (State etatf: this.current.getValeur().etatFuturs()){
      if(this.current.getValeur()==etatf){
        continue;
      }
      Node new_fils = new Node(etatf);
      new_fils.setPere(this.current);
      new_fils.setCout(this.current.getCout()+1);
      this.current.addFils(new_fils);
    }
  }

}
