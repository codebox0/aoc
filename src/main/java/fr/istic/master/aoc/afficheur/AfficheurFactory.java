package fr.istic.master.aoc.afficheur;

import fr.istic.master.aoc.afficheur.interfaces.Afficheur;

public class AfficheurFactory {

	public static Afficheur build(String name) {
		return new AfficheurImpl(name);
	}
}
