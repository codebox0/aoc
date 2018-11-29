package fr.istic.master.aoc.strategie.coherencesequentielle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.generateur.interfaces.Generateur;
import fr.istic.master.aoc.strategie.AlgoDiffusion;
import fr.istic.master.aoc.strategie.Phase;

public class DiffusionSequentielle implements AlgoDiffusion {

	private static final Executor executor = Executors.newFixedThreadPool(1);
	private List<AfficheurAsync> canaux = new ArrayList<>();
	private int copyValue;
	private Phase phase = Phase.WRITE;

	@Override
	public void addCanal(AfficheurAsync canal) {
		canaux.add(canal);
	}

	@Override
	public Integer getValue() {
		return copyValue;
	}

	@Override
	public void execute(Generateur generateur, int value) {

		if (Phase.WRITE == phase) {
			phase = Phase.READ;
			this.copyValue = value;

			executor.execute(new Runnable() {

				@Override
				public void run() {
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
					phase = Phase.WRITE;
				}
			});
		}

	}

}
