package fr.istic.master.aoc.generateur;

import java.util.concurrent.Callable;

import fr.istic.master.aoc.afficheur.interfaces.Afficheur;
import fr.istic.master.aoc.generateur.interfaces.GenerateurAsync;

/**
 * Concrete Method Invocation du pattern Active Object
 * Utilisé pour récupérer la valeur d'un générateur obtenu par construction.
 * 
 * @author michel & dorian
 *
 */
public class Update implements Callable<Object> {

	private Afficheur afficheur;
	private GenerateurAsync canal;

	public Update(GenerateurAsync canal, Afficheur afficheur) {
		this.afficheur = afficheur;
		this.canal = canal;
	}

	@Override
	public Object call() throws Exception {
		afficheur.update(canal);
		return null;
	}

}
