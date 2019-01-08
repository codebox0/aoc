package fr.istic.master.aoc.diffusion;

import java.util.List;

import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.generateur.interfaces.Generateur;

/**
 *
 * Interface de Stratégie de diffusion
 *
 * @author michel
 *
 */
public interface AlgoDiffusion {

	/**
	 * Récupère la valeur destinée à être diffusée pour l'algorithme
	 * 
	 * @return une valeur pour l'afficheur
	 */
	Integer getValue();

	/**
	 * Opération de configuration de la stratégie
	 * 
	 * @param generateur - le générateur
	 * @param canaux - les observateurs du générateurs
	 */
	void configure(Generateur generateur, List<AfficheurAsync> canaux);

	/**
	 * Opération d'exécution
	 * @param value - la valeur générée par le générateur
	 */
	void execute(int value);

	/**
	 * Opération de terminaison de l'algorithme de diffusion
	 */
	void shutdown();

}
