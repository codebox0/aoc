package fr.istic.master.aoc.generateur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.generateur.interfaces.Generateur;
import fr.istic.master.aoc.strategie.AlgoDiffusion;

public class GenerateurImpl implements Generateur, GenerateurAvecDiffusion {

	private List<AfficheurAsync> canaux = new ArrayList<AfficheurAsync>();
	private AlgoDiffusion algoDiffusion;
	private int value;
	private ExecutorService executeur = Executors.newFixedThreadPool(1);
	private boolean mustRun = true;

	@Override
	public void attach(AfficheurAsync canal) {
		canaux.add(canal);
	}

	@Override
	public void detach(AfficheurAsync canal) {
		canaux.remove(canal);
	}

	@Override
	public Integer getValue() {
		return algoDiffusion.getValue();
	}

	@Override
	public void setAlgoDiffusion(AlgoDiffusion algoDiffusion) {
		mustRun = false;
		try {
			executeur.awaitTermination(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			this.algoDiffusion = algoDiffusion;
			executeur = Executors.newFixedThreadPool(1);
			mustRun = true;
			tick();
		}
	}

	@Override
	public void tick() {

		final Generateur generateur = this;
		executeur.execute(new Runnable() {

			@Override
			public void run() {
				while (mustRun) {
					value++;
					algoDiffusion.configure(generateur, canaux);
					algoDiffusion.execute(value);
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		});

	}
}
