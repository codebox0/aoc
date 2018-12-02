package fr.istic.master.aoc.generateur.interfaces;

import java.util.concurrent.Future;

/**
 *
 * Interface représentant le générateur asynchrone
 *
 * @author michel & dorian
 *
 */
public interface GenerateurAsync {

	/**
	 * Méthode de récupération asynchrone de la valeur du générateur
	 * 
	 * @return la valeur récupérée depuis le générateur
	 */
	Future<Integer> getValue();
}
