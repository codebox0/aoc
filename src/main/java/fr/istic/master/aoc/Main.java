package fr.istic.master.aoc;

import fr.istic.master.aoc.afficheur.AfficheurFactory;
import fr.istic.master.aoc.canal.Canal;
import fr.istic.master.aoc.generateur.GenerateurFactory;
import fr.istic.master.aoc.generateur.GenerateurImpl;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		GenerateurImpl generateur = GenerateurFactory.fabriqueGenerateur();

		creerCanalEtAfficheur(generateur, 1);
		creerCanalEtAfficheur(generateur, 2);
		creerCanalEtAfficheur(generateur, 3);
		creerCanalEtAfficheur(generateur, 4);

		while (true) {
			generateur.generationDeValeurs();
			Thread.sleep(3000);
		}
	}

	private static Canal creerCanalEtAfficheur(GenerateurImpl generateur, int number) {
		Canal canal = new Canal(generateur, "Canal" + number);
		AfficheurFactory.newAfficheur(canal, "Afficheur" + number);
		generateur.addCanal(canal);
		return canal;
	}

}
