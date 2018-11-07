package fr.istic.master.aoc;

import java.util.concurrent.Callable;

public class Update implements Callable<Object> {

	private Afficheur afficheur;

	public Update(Afficheur afficheur) {
		this.afficheur = afficheur;
	}

	public Object call() throws Exception {
		afficheur.update();
		return null;
	}

}
