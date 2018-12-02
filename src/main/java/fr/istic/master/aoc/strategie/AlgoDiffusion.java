package fr.istic.master.aoc.strategie;

import java.util.List;

import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.generateur.interfaces.Generateur;

/**
 *
 * Stratégie de diffusion
 *
 * @author michel
 *
 */
public interface AlgoDiffusion {

	Integer getValue();

	void configure(Generateur generateur, List<AfficheurAsync> canaux);

	void execute(int value);

}
