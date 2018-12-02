package fr.istic.master.aoc.canal;

import fr.istic.master.aoc.afficheur.interfaces.Afficheur;
import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;

public class CanalFactory {

	public static AfficheurAsync build(String name, Afficheur afficheur) {
		return new Canal(name, afficheur);
	}

}
