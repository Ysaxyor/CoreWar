package solveur.ia;
import java.util.Comparator;

public class Compare2Node implements Comparator<Node>{



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
