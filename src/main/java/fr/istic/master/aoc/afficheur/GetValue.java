package fr.istic.master.aoc.afficheur;

import java.util.concurrent.Callable;

import fr.istic.master.aoc.generateur.interfaces.Generateur;

/**
 * Concrete Method Invocation du pattern Active Object
 * Utilisé pour récupérer la valeur d'un générateur obtenu par construction.
 * 
 * @author michel & dorian
 *
 */
public class GetValue implements Callable<Integer> {

	private Generateur generateur;

	public GetValue(Generateur generateur) {
		this.generateur = generateur;
	}

	@Override
	public Integer call() throws Exception {
		return generateur.getValue();
	}

}
