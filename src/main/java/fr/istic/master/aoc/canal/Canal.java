package fr.istic.master.aoc.canal;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fr.istic.master.aoc.afficheur.GetValue;
import fr.istic.master.aoc.afficheur.interfaces.Afficheur;
import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.generateur.Update;
import fr.istic.master.aoc.generateur.interfaces.Generateur;
import fr.istic.master.aoc.generateur.interfaces.GenerateurAsync;

/**
 * @author Michel & Dorian
 *
 *         Classe représentant un canal qui connait le générateur et l'afficheur
 *
 */
public class Canal implements AfficheurAsync, GenerateurAsync {
	private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
	private int latence = 100;
	private Afficheur afficheur;
	private String name;
	private Generateur generateur;

	public Canal(String name, Afficheur afficheur) {
		this.name = name;
		this.afficheur = afficheur;
		this.latence = (int) (Math.random() * 900 + 100);
	}

	@Override
	public Future<Object> update(Generateur g) {
		this.generateur = g;
		return scheduler.schedule(new Update(this, afficheur), latence, TimeUnit.MILLISECONDS);
	}

	@Override
	public Future<Integer> getValue() {
		return scheduler.schedule(new GetValue(generateur), latence, TimeUnit.MILLISECONDS);
	}

	@Override
	public String toString() {
		return name;
	}

}
