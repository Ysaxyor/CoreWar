package src.modele.ia;

import java.util.*;
import src.modele.*;

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

  /***
   * Implementation d'A*
   * @return La liste des noeuds de la solution.
   */
  public ArrayList<Node> aEtoile(){
    long tempsDebut = System.currentTimeMillis(); //Permet de mettre une horloge;
    Node current = new Node(this.etat);
    PriorityQueue<Node> open = new PriorityQueue<>(new Compare2Node());
    HashSet<Node> closed = new HashSet<>();
    ArrayList<Node> path = new ArrayList<>();

    open.add(current);
    while(! open.isEmpty()){
      System.out.println((System.currentTimeMillis()-tempsDebut)/1000F);
      current = open.poll();
      new GraphState(current);
      closed.add(current);
      assert current != null;
      if (current.getValeur().isFinished()){
        path.add(current);
        break;
      }
      if(((System.currentTimeMillis()-tempsDebut)/1000F) >= 60){ //Si on depasse 60s d'attente, on stop le programme et on renvoit null;
        return null;
      }
      for (Node fils: current.getFils()){
        if (closed.contains(fils)){
          continue;
        }
        if(current.getEval()>fils.getEval() || ! open.contains(fils)){
          fils.setPere(current);
          fils.setHeuristique(fils.getHeuristique()+fils.getCout());
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
