package fr.istic.master.aoc.strategie;

import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.generateur.interfaces.Generateur;

public interface AlgoDiffusion {

	void addCanal(AfficheurAsync canal);

	void execute(Generateur generateur, int value);

	Integer getValue();

}
