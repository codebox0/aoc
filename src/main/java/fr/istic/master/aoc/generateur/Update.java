package fr.istic.master.aoc.generateur;

import java.util.concurrent.Callable;

import fr.istic.master.aoc.afficheur.interfaces.Afficheur;

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
