package src.modele.ia;
import java.util.Comparator;

public class Compare2Node implements Comparator<Node>{


  /***
   * Redefinition de compare, on regarde d'abord l'evaluation de chaque noeud puis en cas
   * d'egalite on regarde l'heuristique.
   * @param noeud1 Premier noeud
   * @param noeud2 Second noeud
   * @return Un entier, 1 si l'evaluation ou l'heuristique du premier noeud est superieur au second noeud, -1 s'il est
   * inferieur, et 0 en cas d'egalite.
   */
  @Override
  public int compare(Node noeud1, Node noeud2){
    if (noeud1.getEval()>noeud2.getEval()){
      return 1;
    }else{
      if (noeud1.getEval()<noeud2.getEval()){
        return -1;
      }
    }
    if(noeud1.getHeuristique()>noeud2.getHeuristique()){
      return 1;
    }else{
      if (noeud1.getHeuristique()<noeud2.getHeuristique()){
        return -1;
      }
    }

    return 0;
  }

}
