package fr.istic.master.aoc;

import java.util.ArrayList;
import java.util.List;

import fr.istic.master.aoc.afficheur.AfficheurUI;
import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.canal.Canal;
import fr.istic.master.aoc.generateur.GenerateurImpl;
import fr.istic.master.aoc.generateur.interfaces.Generateur;
import fr.istic.master.aoc.generateur.interfaces.GenerateurAvecDiffusion;
import fr.istic.master.aoc.ui.ApplicationBuilder;

/**
 * 
 * Classe de lancement de l'application avec une interface utilisateur.
 * 
 * @author michel & dorian
 *
 */
public class MainSwing {

	/**
	 * Point d'entrée principal de l'application. Construit le modèle de class
	 * permettant l'intération générateur - canal - afficheur Fait appel à la
	 * construction de l'IHM.
	 * 
	 * @param arguments
	 *            - Aucun paramètre nécessaire ici
	 * @throws InterruptedException
	 */
	public static void main(String[] arguments) throws InterruptedException {
		Generateur generateur = new GenerateurImpl();

		List<AfficheurUI> afficheurs = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			AfficheurUI a = new AfficheurUI();
			afficheurs.add(a);
			AfficheurAsync c = new Canal("Canal" + i, a);
			generateur.attach(c);
		}

		ApplicationBuilder.build((GenerateurAvecDiffusion) generateur, afficheurs);
	}
}
