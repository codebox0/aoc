package fr.istic.master.aoc.diffusion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.generateur.CopieGenerateur;
import fr.istic.master.aoc.generateur.interfaces.Generateur;

public class DiffusionCausale implements AlgoDiffusion {

	private final Map<AfficheurAsync, ExecutorService> executors = new HashMap<>();
	private List<AfficheurAsync> canaux = new ArrayList<>();

	@Override
	public void configure(Generateur generateur, List<AfficheurAsync> canaux) {
		this.canaux = canaux;
		canaux.forEach(canal -> executors.put(canal, Executors.newFixedThreadPool(1)));
	}

	@Override
	public Integer getValue() {
		return null;
	}

	@Override
	public void execute(int value) {

		Generateur copie = new CopieGenerateur(value);
		canaux.forEach(canal -> executors.get(canal).submit(new Runnable() {

			@Override
			public void run() {
				try {
					canal.update(copie).get();
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			}
		}));
	}

	@Override
	public void shutdown() {
		executors.values().forEach(executor -> executor.shutdownNow());
	}

}
