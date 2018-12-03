package fr.istic.master.aoc;

import fr.istic.master.aoc.afficheur.AfficheurFactory;
import fr.istic.master.aoc.afficheur.interfaces.Afficheur;
import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.canal.CanalFactory;
import fr.istic.master.aoc.diffusion.AlgoDiffusionFactory;
import fr.istic.master.aoc.diffusion.EnumAlgoDiffusion;
import fr.istic.master.aoc.generateur.GenerateurAvecDiffusion;
import fr.istic.master.aoc.generateur.GenerateurFactory;
import fr.istic.master.aoc.generateur.interfaces.Generateur;

/**
 * Classe initialisant les afficheurs, les canaux et le générateur
 *
 * @author michel & dorian
 *
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		Generateur generateur = GenerateurFactory.build();

		for (int i = 0; i < 4; i++) {
			Afficheur a = creerAfficheur(i);
			AfficheurAsync c = creerCanal(i, a);
			generateur.attach(c);
		}

		((GenerateurAvecDiffusion) generateur)
				.setAlgoDiffusion(AlgoDiffusionFactory.build(EnumAlgoDiffusion.COHERENCE_ATOMIQUE));
	}

	/**
	 * Création d'un afficheur avec son label
	 *
	 * @param nombre
	 * @return
	 */
	private static Afficheur creerAfficheur(int nombre) {
		return AfficheurFactory.build("Afficheur " + nombre);

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
