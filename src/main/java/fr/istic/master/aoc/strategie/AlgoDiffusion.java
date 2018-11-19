package fr.istic.master.aoc.strategie;

import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;

public interface AlgoDiffusion {

	int getValue(AfficheurAsync canal);

	void tick();

}
