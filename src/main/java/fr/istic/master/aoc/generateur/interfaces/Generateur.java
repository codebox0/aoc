package fr.istic.master.aoc.generateur.interfaces;

import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;

/**
 *
 * Interface representant le générateur de données.
 *
 * @author michel & dorian
 *
 *
 */
public interface Generateur {

	/**
	 * Récupérer la valeur du générateur
	 *
	 * @param canal - le canal
	 * @return la valeur du générateur
	 */
	Integer getValue();

	/**
	 * Enregistrer un canal auprès du générateur
	 *
	 * @param canal - le canal observant le générateur
	 */
	void attach(AfficheurAsync canal);

	/**
	 * Désenregistrer un canal auprès du générateur
	 *
	 * @param canal - le canal observant le générateur
	 */
	void detach(AfficheurAsync canal);

	/**
	 * fonction principale, génère une valeur et lance la mise à jour des afficheurs
	 */
	void tick();

}
