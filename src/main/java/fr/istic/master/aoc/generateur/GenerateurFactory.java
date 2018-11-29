package fr.istic.master.aoc.generateur;

import fr.istic.master.aoc.generateur.interfaces.Generateur;
import fr.istic.master.aoc.strategie.EnumAlgoDiffusion;
import fr.istic.master.aoc.strategie.coherenceatomique.DiffusionAtomique;
import fr.istic.master.aoc.strategie.coherencesequentielle.DiffusionSequentielle;

public class GenerateurFactory {

	public static Generateur fabriqueGenerateur(EnumAlgoDiffusion type) {
		Generateur generateur = null;

		switch (type) {
		case COHERENCE_ATOMIQUE:
			DiffusionAtomique diffusionAtomique = new DiffusionAtomique();
			generateur = new GenerateurImpl(diffusionAtomique);
			break;
		case COHERENCE_CAUSALE:
			DiffusionSequentielle diffusionCausale = new DiffusionSequentielle();
			generateur = new GenerateurImpl(diffusionCausale);
			break;
		case COHERENCE_SEQUENTIELLE:
			DiffusionSequentielle diffusionSequentielle = new DiffusionSequentielle();
			generateur = new GenerateurImpl(diffusionSequentielle);
			break;
		default:
			break;

		}

		return generateur;
	}
}
