package src.vue;

import src.modele.*;

public class Main {
	public static void main(String[] args) {
		new Vue(new State(new Grille(10)));

	}
	
}
