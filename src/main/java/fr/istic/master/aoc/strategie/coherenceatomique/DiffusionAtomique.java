package fr.istic.master.aoc.strategie.coherenceatomique;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.generateur.interfaces.Generateur;
import fr.istic.master.aoc.strategie.AlgoDiffusion;

public class DiffusionAtomique implements AlgoDiffusion {

	Map<AfficheurAsync, Boolean> registre = new HashMap<>();
	int value = 0;
	private Generateur generateur;
	private Phase phase = Phase.WRITE;

	public void setGenerateur(Generateur generateur) {
		this.generateur = generateur;
	}

	public void addCanal(AfficheurAsync canal) {
		registre.put(canal, false);
	}

	@Override
	public int getValue(AfficheurAsync canal) {
		System.out.println("DiffusionAtomique.getValue()");
		registre.put(canal, true);
		Optional<Boolean> findFirst = registre.values().stream().filter(value -> value == false).findFirst();
		if (!findFirst.isPresent()) {
			phase = Phase.WRITE;
		}

		return value;
	}

	@Override
	public void tick() {
		if (phase == Phase.WRITE) {
			value++;
			generateur.majValeur();
			phase = Phase.READ;
		}
	}

}
