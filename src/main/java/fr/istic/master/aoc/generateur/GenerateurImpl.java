package fr.istic.master.aoc.generateur;

import java.util.ArrayList;
import java.util.List;

import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;
import fr.istic.master.aoc.generateur.interfaces.Generateur;
import fr.istic.master.aoc.strategie.AlgoDiffusion;

public class GenerateurImpl implements Generateur {

	private List<AfficheurAsync> canaux = new ArrayList<AfficheurAsync>();
	private AlgoDiffusion algoDiffusion;
	private int value;

	public GenerateurImpl(AlgoDiffusion algoDiffusion) {
		this.algoDiffusion = algoDiffusion;
	}

	public void attach(AfficheurAsync canal) {
		canaux.add(canal);
		algoDiffusion.addCanal(canal);

	}

	@Override
	public void detach(AfficheurAsync canal) {
		canaux.remove(canal);
	}

	@Override
	public Integer getValue(AfficheurAsync canal) {
		System.out.println("Canal:" + canal);
		return algoDiffusion.getValue();
	}

	@Override
	public void genererValeur() {
		value++;

		algoDiffusion.execute(this, value);
	}

}
