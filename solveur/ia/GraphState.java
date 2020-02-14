package solveur.ia;
import java.util.*;
import solveur.*;

public class GraphState{
  private Node current;

  public GraphState(Node current){
    this.current=current;
    this.buildFreres();
  }

  public Node getCurrent(){
    return this.current;
  }


//methodes
//si posPiont fils1 == posPiont fils2 -> fils1=fils2
  public void buildFreres(){
    HashSet<Node> fils = new HashSet<>();
    for (State f: current.getValeur().etatFuturs()){
      Node n = new Node(f);
      n.setPere(this.current);
      n.setCout(this.current.getCout()+1);
      fils.add(n);
    }
    for (Node n1: fils){
      HashSet<Node> freres = new HashSet<>();
      for (Node n2: fils){
        if (n1 != n2){
          freres.add(n2);
        }
      }
      n1.setFreres(freres);
    }

    this.current.setFils(fils);
  }

}
