package fr.istic.master.aoc.canal;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fr.istic.master.aoc.afficheur.GetValue;
import fr.istic.master.aoc.afficheur.interfaces.Afficheur;
import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.generateur.GenerateurImpl;
import fr.istic.master.aoc.generateur.Update;
import fr.istic.master.aoc.generateur.interfaces.Generateur;
import fr.istic.master.aoc.generateur.interfaces.GenerateurAsync;

public class Canal implements AfficheurAsync, GenerateurAsync {
	private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
	private Generateur generateur;
	private Afficheur afficheur;
	private String name;

	public Canal(GenerateurImpl generateur, String name) {
		this.generateur = generateur;
		this.name = name;
	}

	public void setGenerateur(Generateur generateur) {
		this.generateur = generateur;
	}

	public void setAfficheur(Afficheur afficheur) {
		this.afficheur = afficheur;
	}

	@Override
	public Future<Object> update(Generateur g) {
		return scheduler.schedule(new Update(afficheur), 500, TimeUnit.MILLISECONDS);
	}

	@Override
	public Future<Integer> getValue() {
		return scheduler.schedule(new GetValue(this, generateur), 500, TimeUnit.MILLISECONDS);
	}

	@Override
	public String toString() {
		return name;
	}
}
