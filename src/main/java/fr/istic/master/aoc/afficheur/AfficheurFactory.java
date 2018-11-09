package fr.istic.master.aoc.afficheur;

import fr.istic.master.aoc.canal.Canal;

public class AfficheurFactory {

	public static AfficheurImpl newAfficheur(Canal canal, String afficheurName) {
		AfficheurImpl afficheur = new AfficheurImpl(canal, afficheurName);
		canal.setAfficheur(afficheur);
		return afficheur;
	}
}
