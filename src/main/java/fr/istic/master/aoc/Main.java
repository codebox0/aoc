package fr.istic.master.aoc;

import fr.istic.master.aoc.afficheur.AfficheurImpl;
import fr.istic.master.aoc.afficheur.interfaces.Afficheur;
import fr.istic.master.aoc.canal.Canal;
import fr.istic.master.aoc.generateur.GenerateurFactory;
import fr.istic.master.aoc.generateur.GenerateurImpl;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		GenerateurImpl generateur = GenerateurFactory.fabriqueGenerateur();

		Afficheur a1 = creerAfficheur(1);
		Afficheur a2 = creerAfficheur(2);
		Afficheur a3 = creerAfficheur(3);
		Afficheur a4 = creerAfficheur(4);

		Canal c1 = creerCanal(1, a1);
		generateur.attach(c1);

		Canal c2 = creerCanal(2, a2);
		generateur.attach(c2);

		Canal c3 = creerCanal(3, a3);
		generateur.attach(c3);

		Canal c4 = creerCanal(4, a4);
		generateur.attach(c4);

		while (true) {
			generateur.generationDeValeurs();
			Thread.sleep(3000);
		}
	}

	private static Afficheur creerAfficheur(int number) {
		return new AfficheurImpl("Afficheur " + number);

	}

	private static Canal creerCanal(int number, Afficheur afficheur) {
		return new Canal("Canal" + number, afficheur);
	}

}
