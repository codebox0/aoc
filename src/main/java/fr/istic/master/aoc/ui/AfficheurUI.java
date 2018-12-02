package fr.istic.master.aoc.ui;

import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;

import fr.istic.master.aoc.afficheur.interfaces.Afficheur;
import fr.istic.master.aoc.generateur.interfaces.GenerateurAsync;

/**
 * @author michel & dorian
 *
 *         Implémentation d'un afficheur avec Swing
 *
 */
public class AfficheurUI extends JLabel implements Afficheur {

	private static final long serialVersionUID = 4571489304902222245L;

	public AfficheurUI() {
		setSize(20, 20);
	}

	@Override
	public void update(GenerateurAsync canal) {
		try {
			setText(String.valueOf(canal.getValue().get()));
		} catch (InterruptedException e) {
			Logger.getGlobal().log(Level.SEVERE, "Interruption de la récupération.", e);
		} catch (ExecutionException e) {
			Logger.getGlobal().log(Level.SEVERE, "Problème lors de l'exécution.", e);
		}
	}
}
