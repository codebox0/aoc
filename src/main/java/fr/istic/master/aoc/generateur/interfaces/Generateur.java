package fr.istic.master.aoc.generateur.interfaces;

import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;

public interface Generateur {

	Integer getValue(AfficheurAsync canal);

	void majValeur();
}
