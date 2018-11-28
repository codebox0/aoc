package fr.istic.master.aoc.strategie.coherencesequentielle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.generateur.interfaces.Generateur;
import fr.istic.master.aoc.strategie.AlgoDiffusion;
import fr.istic.master.aoc.strategie.Phase;

public class DiffusionSequentielle implements AlgoDiffusion {

	Map<AfficheurAsync, Boolean> registre = new HashMap<>();
	int value = 0;
	private Generateur generateur;
	private Phase phase = Phase.WRITE;
	private int copyValue;

	public void setGenerateur(Generateur generateur) {
		this.generateur = generateur;
	}

	public void addCanal(AfficheurAsync canal) {
		registre.put(canal, false);
	}

	@Override
	public int getValue(AfficheurAsync canal) {
		System.out.println("DiffusionSequentielle.getValue()");
		registre.put(canal, true);
		Optional<Boolean> findFirst = registre.values().stream().filter(value -> value == false).findFirst();
		if (!findFirst.isPresent()) {
			phase = Phase.WRITE;
		}

		return copyValue;
	}

	@Override
	public void execute() {
		value++;
		if (phase == Phase.WRITE) {
			copyValue = value;
			generateur.majValeur();
			phase = Phase.READ;
		}
	}

}
