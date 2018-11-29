package fr.istic.master.aoc.strategie.coherenceatomique;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.generateur.interfaces.Generateur;
import fr.istic.master.aoc.strategie.AlgoDiffusion;

public class DiffusionAtomique implements AlgoDiffusion {

	List<AfficheurAsync> canaux = new ArrayList<>();
	private int value;

	@Override
	public void addCanal(AfficheurAsync canal) {
		canaux.add(canal);
	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public void execute(Generateur generateur, int value) {

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

}
