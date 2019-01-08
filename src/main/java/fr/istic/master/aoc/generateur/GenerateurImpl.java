package fr.istic.master.aoc.generateur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.diffusion.AlgoDiffusion;
import fr.istic.master.aoc.generateur.interfaces.Generateur;
import fr.istic.master.aoc.generateur.interfaces.GenerateurAvecDiffusion;

/**
 * 
 * Classe d'implémentation de l'interface Générateur. On exprime via l'interface
 * GenerateurAvecDiffusion le fait de pouvoir changer à la volée la stratégie de
 * diffusion.
 * 
 * @author michel & dorian
 *
 */
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
	public void setAlgoDiffusion(AlgoDiffusion nouvelAlgoDiffusion) {

		shutdownGenerateur();

		switchAlgoDiffusion(nouvelAlgoDiffusion);

		startGenerateur();
	}

	private void switchAlgoDiffusion(AlgoDiffusion nouvelAlgoDiffusion) {
		if (this.algoDiffusion != null) {
			algoDiffusion.shutdown();
			Logger.getGlobal().log(Level.INFO, "Switch from " + this.algoDiffusion.getClass().getSimpleName() + " to "
					+ nouvelAlgoDiffusion.getClass().getSimpleName());
		}
		algoDiffusion = nouvelAlgoDiffusion;
	}

	private void startGenerateur() {
		value = 0;
		executeur = Executors.newFixedThreadPool(1);
		mustRun = true;
		tick();
	}

	private void shutdownGenerateur() {
		mustRun = false;
		try {
			executeur.awaitTermination(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void tick() {

		final Generateur generateur = this;
		algoDiffusion.configure(generateur, canaux);

		executeur.execute(new Runnable() {

			@Override
			public void run() {
				while (mustRun) {
					value++;
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
