package fr.istic.master.aoc.afficheur;

import java.util.concurrent.Callable;

import fr.istic.master.aoc.generateur.interfaces.Generateur;

public class GetValue implements Callable<Integer> {

	private Generateur generateur;

	public GetValue(Generateur generateur) {
		this.generateur = generateur;
	}

	public Integer call() throws Exception {
		return generateur.getValue();
	}

}
