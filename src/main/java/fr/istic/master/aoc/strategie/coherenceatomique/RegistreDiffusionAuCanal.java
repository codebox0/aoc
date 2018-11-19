package fr.istic.master.aoc.strategie.coherenceatomique;

import fr.istic.master.aoc.afficheur.interfaces.AfficheurAsync;

public class RegistreDiffusionAuCanal {
	private boolean valeurRecuperee;
	private AfficheurAsync canal;

	public RegistreDiffusionAuCanal(AfficheurAsync canal) {
		this.canal = canal;
	}

	public AfficheurAsync getCanal() {
		return canal;
	}

	public boolean isValeurRecuperee() {
		return valeurRecuperee;
	}

	public void setValeurRecuperee(boolean valeurRecuperee) {
		this.valeurRecuperee = valeurRecuperee;
	}

}
