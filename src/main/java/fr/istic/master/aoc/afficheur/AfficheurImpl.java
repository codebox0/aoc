package fr.istic.master.aoc.afficheur;

import java.util.concurrent.ExecutionException;

import fr.istic.master.aoc.afficheur.interfaces.Afficheur;
import fr.istic.master.aoc.generateur.interfaces.GenerateurAsync;

public class AfficheurImpl implements Afficheur {

	private GenerateurAsync canal;
	private String name;

	public AfficheurImpl(GenerateurAsync canal, String afficheurName) {
		this.canal = canal;
		this.name = afficheurName;
	}

	@Override
	public void update() {
		try {
			System.out.println("Afficheur: " + name + " getValue: " + canal.getValue().get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	public void setCanal(GenerateurAsync canal) {
		this.canal = canal;
	}

	@Override
	public String toString() {
		return name;
	}

}
