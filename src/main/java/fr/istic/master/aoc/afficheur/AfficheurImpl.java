package fr.istic.master.aoc.afficheur;

import java.util.concurrent.ExecutionException;

import fr.istic.master.aoc.afficheur.interfaces.Afficheur;
import fr.istic.master.aoc.generateur.interfaces.GenerateurAsync;

public class AfficheurImpl implements Afficheur {

	private String name;

	public AfficheurImpl(String afficheurName) {
		this.name = afficheurName;
	}

	@Override
	public void update(GenerateurAsync canal) {
		try {
			System.out.println("Afficheur: " + name + " getValue: " + canal.getValue().get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return name;
	}

}
