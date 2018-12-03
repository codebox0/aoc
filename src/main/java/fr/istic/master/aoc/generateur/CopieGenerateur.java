package fr.istic.master.aoc.generateur;

import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.generateur.interfaces.Generateur;

public class CopieGenerateur implements Generateur {

	private int value;

	public CopieGenerateur(int value) {
		this.value = value;
	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public void attach(AfficheurAsync canal) {
		// NE RIEN FAIRE
	}

	@Override
	public void detach(AfficheurAsync canal) {
		// NE RIEN FAIRE

	}

	@Override
	public void tick() {
		// NE RIEN FAIRE
	}

}
