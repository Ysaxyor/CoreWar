package solveur.ia;
import solveur.*;

public class Node{
  private State valeur;
  private int cout;
  private int heuristique;


  public Node(State valeur){
    this.valeur=valeur;
    this.heuristique=valeur.getEval();
  }


}
