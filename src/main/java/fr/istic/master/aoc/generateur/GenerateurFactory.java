package fr.istic.master.aoc.generateur;

import fr.istic.master.aoc.generateur.interfaces.Generateur;

public class GenerateurFactory {

	public static Generateur build() {
		return new GenerateurImpl();
	}
}
