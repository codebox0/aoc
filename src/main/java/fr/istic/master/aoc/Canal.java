package fr.istic.master.aoc;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Canal implements AfficheurAsync, GenerateurAsync {
	private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
	private Generateur generateur;
	private Afficheur afficheur;

	public Canal(Generateur g, Afficheur f) {
		this.generateur = g;
		this.afficheur = f;

	}

	public Future<Object> update(Generateur g) {
		return scheduler.schedule(new Update(afficheur), 500, TimeUnit.MILLISECONDS);
	}

	public Future<Integer> getValue() {
		return scheduler.schedule(new GetValue(generateur), 500, TimeUnit.MILLISECONDS);
	}

}
