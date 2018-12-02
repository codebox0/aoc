package fr.istic.master.aoc;

import java.util.ArrayList;
import java.util.List;

import fr.istic.master.aoc.afficheur.interfaces.Afficheur;
import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.canal.CanalFactory;
import fr.istic.master.aoc.generateur.GenerateurAvecDiffusion;
import fr.istic.master.aoc.generateur.GenerateurFactory;
import fr.istic.master.aoc.generateur.interfaces.Generateur;
import fr.istic.master.aoc.ui.AfficheurUI;
import fr.istic.master.aoc.ui.ApplicationBuilder;

public class MainSwing {
	public static void main(String[] args) throws InterruptedException {
		Generateur generateur = GenerateurFactory.build();

		List<AfficheurUI> afficheurs = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			AfficheurUI a = creerAfficheur(i);
			afficheurs.add(a);
			AfficheurAsync c = creerCanal(i, a);
			generateur.attach(c);
		}
		GenerateurAvecDiffusion generateurAvecDiffusion = (GenerateurAvecDiffusion) generateur;
		ApplicationBuilder.build(generateurAvecDiffusion, afficheurs);
	}

	/**
	 * Création d'un afficheur avec son label
	 *
	 * @param nombre
	 * @return
	 */
	private static AfficheurUI creerAfficheur(int nombre) {
		return new AfficheurUI();

	}

	/**
	 *
	 * Création d'un canal avec son label et le lie avec son afficheur
	 *
	 * @param nombre
	 * @param afficheur
	 * @return
	 */
	private static AfficheurAsync creerCanal(int nombre, Afficheur afficheur) {
		return CanalFactory.build("Canal" + nombre, afficheur);
	}
}
