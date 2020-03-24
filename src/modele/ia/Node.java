package src.modele.ia;
import src.modele.*;
import java.util.*;

public class Node{
  private State valeur;
  private int cout;
  private int heuristique;

  private Node pere;
  private HashSet<Node> fils;

  public Node(State valeur){
    this.valeur=valeur;
    this.cout=0;
    this.heuristique=valeur.getEval();
    this.pere=null;
    this.fils=new HashSet<>();
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
  public int getEval(){
    return this.heuristique+this.cout;
  }
  public Node getPere(){
    return this.pere;
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
  //methodes

  public void addFils(Node fils){
    this.fils.add(fils);
  }
  public void removeFils(Node fils){
    this.fils.remove(fils);
  }
}
