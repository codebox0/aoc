package fr.istic.master.aoc.generateur.interfaces;

import fr.istic.master.aoc.diffusion.AlgoDiffusion;

/**
 * Interface permettant l'affectation d'un algorithme de diffusion à un générateur
 * 
 * @author michel & dorian
 *
 */
public interface GenerateurAvecDiffusion {

	/**
	 * Permet de changer le type d'algorithme de diffusion
	 * 
	 * @param algoDiffusion - Algorithme de diffusion à utiliser
	 */
	void setAlgoDiffusion(AlgoDiffusion algoDiffusion);

}
