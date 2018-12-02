package fr.istic.master.aoc.ui;

import java.util.List;

public class ApplicationBuilder {

	public static Fenetre build(List<AfficheurUI> afficheurs) {
		Fenetre fenetre = new Fenetre();

		afficheurs.forEach(afficheur -> fenetre.getEspaceAfficheur().add(afficheur));

		fenetre.setVisible(true);
		return fenetre;
	}
}
