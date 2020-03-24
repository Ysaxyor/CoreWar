package src.modele.ia;
import src.modele.*;

public class GraphState{
  private Node current;

  public GraphState(Node current){
    this.current=current;
    this.buildGraph();
  }

  public Node getCurrent(){
    return this.current;
  }


//methodes
//si posPiont fils1 == posPiont fils2 -> fils1=fils2
  public void buildGraph(){
    for (State etatf: this.current.getValeur().getFutureStates()){
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
