package fr.istic.master.aoc.generateur;

import java.util.concurrent.Callable;

import fr.istic.master.aoc.afficheur.interfaces.Afficheur;
import fr.istic.master.aoc.generateur.interfaces.GenerateurAsync;

public class Update implements Callable<Object> {

	private Afficheur afficheur;
	private GenerateurAsync canal;

	public Update(GenerateurAsync canal, Afficheur afficheur) {
		this.afficheur = afficheur;
		this.canal = canal;
	}

	@Override
	public Object call() throws Exception {
		System.out.println("Method Invocation: Update");
		afficheur.update(canal);
		return null;
	}

}
