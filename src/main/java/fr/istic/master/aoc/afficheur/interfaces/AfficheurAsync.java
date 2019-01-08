package fr.istic.master.aoc.afficheur.interfaces;

import java.util.concurrent.Future;

import fr.istic.master.aoc.generateur.interfaces.Generateur;

/**
 * 
 * Interface ayant pour objectif de représenter un afficheur dans le monde
 * asynchrone.
 * 
 * @author michel & dorian
 *
 */
public interface AfficheurAsync {

	/**
	 * Opération de diffusion de la valeur du générateur à destination des
	 * afficheurs
	 * 
	 * @param g
	 *            - le générateur à observer
	 * @return
	 */
	Future<Object> update(Generateur g);

}
