package fr.istic.master.aoc;

import java.util.concurrent.ExecutionException;

public class AfficheurImpl implements Afficheur {

	private GenerateurAsync canal;

	public AfficheurImpl(GenerateurAsync canal) {
		this.canal = canal;
	}

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
