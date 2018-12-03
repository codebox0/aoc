package fr.istic.master.aoc.diffusion;

public class AlgoDiffusionFactory {

	public static AlgoDiffusion build(EnumAlgoDiffusion type) {
		AlgoDiffusion diffusion = null;
		switch (type) {
		case COHERENCE_ATOMIQUE:
			diffusion = new DiffusionAtomique();
			break;
		case COHERENCE_SEQUENTIELLE:
			diffusion = new DiffusionSequentielle();
			break;
		case COHERENCE_CAUSALE:
			diffusion = new DiffusionCausale();
			break;
		default:
			break;

		}

		return diffusion;
	}
}
