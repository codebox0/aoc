package fr.istic.master.aoc.generateur;

import java.util.ArrayList;
import java.util.List;

import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.generateur.interfaces.Generateur;
import fr.istic.master.aoc.strategie.AlgoDiffusion;

public class GenerateurImpl implements Generateur {

	private Integer value = new Integer(0);
	private List<AfficheurAsync> canaux = new ArrayList<AfficheurAsync>();
	private AlgoDiffusion algoDiffusion;

	public GenerateurImpl(AlgoDiffusion algoDiffusion) {
		this.algoDiffusion = algoDiffusion;
	}

	public void addCanal(AfficheurAsync canal) {
		canaux.add(canal);
	}

	public void removeCanal(AfficheurAsync canal) {
		canaux.remove(canal);
	}

	@Override
	public Integer getValue(AfficheurAsync canal) {
		System.out.println("Canal:" + canal);
		return value;
	}

	public void generationDeValeurs() {
		value++;
		// Utilisation de la strategie
		canaux.forEach(canal -> {
			System.out.println("Diffusion de la valeur: " + value);
			canal.update(this);
		});
	}

}
