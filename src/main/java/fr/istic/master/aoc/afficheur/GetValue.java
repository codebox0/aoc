package fr.istic.master.aoc.afficheur;

import java.util.concurrent.Callable;

import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.generateur.interfaces.Generateur;

public class GetValue implements Callable<Integer> {

	private Generateur generateur;
	private AfficheurAsync canal;

	public GetValue(AfficheurAsync canal, Generateur generateur) {
		this.canal = canal;
		this.generateur = generateur;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("Method Invocation: Update");
		return generateur.getValue(canal);
	}

}
