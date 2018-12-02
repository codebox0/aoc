package fr.istic.master.aoc.strategie.coherencesequentielle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.generateur.interfaces.Generateur;
import fr.istic.master.aoc.strategie.AlgoDiffusion;
import fr.istic.master.aoc.strategie.Phase;
import fr.istic.master.aoc.strategie.coherenceatomique.DiffusionAtomique;

public class DiffusionSequentielle implements AlgoDiffusion {

	private static final Executor executor = Executors.newFixedThreadPool(1);
	private List<AfficheurAsync> canaux = new ArrayList<>();
	private int copyValue;
	private Phase phase = Phase.WRITE;
	private Generateur generateur;

	@Override
	public void configure(Generateur generateur, List<AfficheurAsync> canaux) {
		this.generateur = generateur;
		this.canaux = canaux;
	}

	@Override
	public Integer getValue() {
		return copyValue;
	}

	@Override
	public void execute(int value) {

		if (Phase.WRITE == phase) {
			phase = Phase.READ;
			this.copyValue = value;

			executor.execute(new Runnable() {

				@Override
				public void run() {
					DiffusionAtomique diffusionAtomique = new DiffusionAtomique();
					diffusionAtomique.configure(generateur, canaux);
					diffusionAtomique.execute(value);
					phase = Phase.WRITE;
				}
			});
		}

	}

}
