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

/**
 * 
 * Diffuse à chaque canal une liste de copie de générateur horodaté. Cette liste
 * est représentée par une file de type FIFO qui est dépilée par un thread dont
 * le rôle est de faire la mise à jour de la valeur au travers du canal.
 * L'implémentation Java utilisée est de type ExecutorService.
 * 
 * @author michel & dorian
 *
 */
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
				} catch (InterruptedException e) {
					System.out.println("Thread interrompu pendant son exécution");
				} catch (ExecutionException e) {
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
