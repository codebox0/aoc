package fr.istic.master.aoc.diffusion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.generateur.interfaces.Generateur;

public class DiffusionAtomique implements AlgoDiffusion {

	List<AfficheurAsync> canaux = new ArrayList<>();
	private int value;
	private Generateur generateur;

	@Override
	public void configure(Generateur generateur, List<AfficheurAsync> canaux) {
		this.generateur = generateur;
		this.canaux = canaux;

	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public void execute(int value) {

		this.value = value;
		@SuppressWarnings("rawtypes")
		List<Future> futures = new ArrayList<>();
		canaux.forEach(canal -> {
			futures.add(canal.update(generateur));
		});

		futures.forEach(future -> {
			try {
				future.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public void shutdown() {
		// NE RIEN FAIRE
	}
}
