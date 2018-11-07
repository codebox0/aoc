package fr.istic.master.aoc;

import java.util.concurrent.Callable;

public class GetValue implements Callable<Integer> {

	private Generateur generateur;

	public GetValue(Generateur generateur) {
		this.generateur = generateur;
	}

	public Integer call() throws Exception {
		return generateur.getValue();
	}

}
