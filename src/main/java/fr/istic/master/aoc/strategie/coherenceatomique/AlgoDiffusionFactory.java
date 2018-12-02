package fr.istic.master.aoc.strategie.coherenceatomique;

import fr.istic.master.aoc.strategie.AlgoDiffusion;
import fr.istic.master.aoc.strategie.EnumAlgoDiffusion;
import fr.istic.master.aoc.strategie.coherencesequentielle.DiffusionSequentielle;

public class AlgoDiffusionFactory {

	public static AlgoDiffusion build(EnumAlgoDiffusion type) {
		AlgoDiffusion diffusion = null;
		switch (type) {
		case COHERENCE_ATOMIQUE:
			diffusion = new DiffusionAtomique();
			break;
		case COHERENCE_CAUSALE:
			diffusion = new DiffusionSequentielle();
			break;
		case COHERENCE_SEQUENTIELLE:
			diffusion = new DiffusionSequentielle();
			break;
		default:
			break;

		}

		return diffusion;
	}
}
