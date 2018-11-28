package fr.istic.master.aoc.generateur;

import fr.istic.master.aoc.strategie.EnumAlgoDiffusion;
import fr.istic.master.aoc.strategie.coherenceatomique.DiffusionAtomique;
import fr.istic.master.aoc.strategie.coherencesequentielle.DiffusionSequentielle;

public class GenerateurFactory {

	public static GenerateurImpl fabriqueGenerateur(EnumAlgoDiffusion type) {
		GenerateurImpl generateur = null;

		switch (type) {
		case COHERENCE_ATOMIQUE:
			DiffusionAtomique diffusionAtomique = new DiffusionAtomique();
			generateur = new GenerateurImpl(diffusionAtomique);
			diffusionAtomique.setGenerateur(generateur);
			break;
		case COHERENCE_CAUSALE:
			break;
		case COHERENCE_SEQUENTIELLE:
			DiffusionSequentielle diffusionSequentielle = new DiffusionSequentielle();
			generateur = new GenerateurImpl(diffusionSequentielle);
			diffusionSequentielle.setGenerateur(generateur);
			break;
		default:
			break;

		}

		return generateur;
	}
}
