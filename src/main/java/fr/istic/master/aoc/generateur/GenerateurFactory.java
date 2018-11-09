package fr.istic.master.aoc.generateur;

import fr.istic.master.aoc.strategie.DiffusionAtomique;

public class GenerateurFactory {

	public static GenerateurImpl fabriqueGenerateur() {
		return new GenerateurImpl(new DiffusionAtomique());
	}
}
