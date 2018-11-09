package fr.istic.master.aoc.afficheur;

import java.util.concurrent.ExecutionException;

import fr.istic.master.aoc.afficheur.interfaces.Afficheur;
import fr.istic.master.aoc.generateur.interfaces.GenerateurAsync;

public class AfficheurImpl implements Afficheur {

	private GenerateurAsync canal;

	public AfficheurImpl(GenerateurAsync canal) {
		this.canal = canal;
	}

	@Override
	public void update() {
		canal.getValue();

		try {
			System.out.println("Valeur:" + canal.getValue().get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
