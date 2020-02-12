package solveur.ia;
import solveur.*;
import java.util.*;

public class Node{
  private State valeur;
  private int cout;
  private int heuristique;

  private Node pere;
  private HashSet<Node> freres;
  private HashSet<Node> fils;

  public Node(State valeur){
    this.valeur=valeur;
    this.heuristique=valeur.getEval();
    this.freres=null;
    this.pere=null;
    this.fils=null;
  }
  //getters
  public State getValeur(){
    return this.valeur;
  }
  public int getCout(){
    return this.cout;
  }
  public int getHeuristique(){
    return this.heuristique;
  }
  public Node getPere(){
    return this.pere;
  }
  public HashSet<Node> getFrere(){
    return this.freres;
  }
  public HashSet<Node> getFils(){
    return this.fils;
  }
//setters
  public void setValeur(State valeur){
    this.valeur=valeur;
  }
  public void setCout(int cout){
    this.cout=cout;
  }
  public void setHeuristique(int heuristique){
    this.heuristique=heuristique;
  }
  public void setPere(Node pere){
    this.pere=pere;
  }
  public void setFreres(HashSet<Node> freres){
    this.freres=freres;
  }
  public void setFils(HashSet<Node> fils){
    this.fils=fils;
  }
}
