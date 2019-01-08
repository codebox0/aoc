package fr.istic.master.aoc.generateur;

import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.generateur.interfaces.Generateur;

/**
 * 
 * Copie d'un générateur portant une valeur généré par celui-ci
 * 
 * @author michel & dorian
 *
 */
public class CopieGenerateur implements Generateur {

	private int value;
	private long timestamp;

	public CopieGenerateur(int value) {
		this.value = value;
		this.timestamp = System.currentTimeMillis();
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
	
	public long getTimestamp() {
		return timestamp;
	}

}
