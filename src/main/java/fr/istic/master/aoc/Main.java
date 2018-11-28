package fr.istic.master.aoc;

import fr.istic.master.aoc.afficheur.AfficheurImpl;
import fr.istic.master.aoc.afficheur.interfaces.Afficheur;
import fr.istic.master.aoc.canal.Canal;
import fr.istic.master.aoc.generateur.GenerateurFactory;
import fr.istic.master.aoc.generateur.GenerateurImpl;
import fr.istic.master.aoc.strategie.EnumAlgoDiffusion;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		GenerateurImpl generateur = GenerateurFactory.fabriqueGenerateur(EnumAlgoDiffusion.COHERENCE_SEQUENTIELLE);

		for (int i = 0; i < 4; i++) {
			Afficheur a = creerAfficheur(i);
			Canal c = creerCanal(i, a);
			generateur.attach(c);
		}

		while (true) {
			generateur.tick();
			Thread.sleep(30);
		}
	}

	private static Afficheur creerAfficheur(int number) {
		return new AfficheurImpl("Afficheur " + number);

	}

	private static Canal creerCanal(int number, Afficheur afficheur) {
		return new Canal("Canal" + number, afficheur);
	}

}
