package fr.istic.master.aoc.afficheur.interfaces;

import fr.istic.master.aoc.generateur.interfaces.GenerateurAsync;

/**
 * 
 * Interface définissant les opérations qu'un afficheur permet d'exécuter.
 * 
 * @author michel & dorian
 *
 */
public interface Afficheur {

	/**
	 * Met à jour l'afficheur.
	 * @param canal - la canal permettant de récupérer la valeur à mettre à jour.
	 */
	void update(GenerateurAsync canal);

}
