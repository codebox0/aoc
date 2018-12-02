package fr.istic.master.aoc.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import fr.istic.master.aoc.generateur.GenerateurAvecDiffusion;
import fr.istic.master.aoc.strategie.EnumAlgoDiffusion;

public class ApplicationBuilder {

	public static Fenetre build(GenerateurAvecDiffusion generateur, List<AfficheurUI> afficheurs) {
		Fenetre fenetre = new Fenetre();

		fenetre.setSize(new Dimension(200, 100));

		buildBoutons(fenetre, generateur);

		buildAfficheurs(afficheurs, fenetre);

		fenetre.setVisible(true);
		return fenetre;
	}

	private static void buildAfficheurs(List<AfficheurUI> afficheurs, Fenetre fenetre) {
		JPanel espaceAfficheurs = new JPanel(new GridLayout(2, 2));
		afficheurs.forEach(afficheur -> espaceAfficheurs.add(afficheur));
		fenetre.setEspaceAfficheurs(espaceAfficheurs);
	}

	private static void buildBoutons(Fenetre fenetre, GenerateurAvecDiffusion generateur) {
		JRadioButton atomique = new JRadioButton("Atomique");
		atomique.setActionCommand(String.valueOf(EnumAlgoDiffusion.COHERENCE_ATOMIQUE));

		JRadioButton sequentielle = new JRadioButton("Séquentielle");
		sequentielle.setActionCommand(String.valueOf(EnumAlgoDiffusion.COHERENCE_SEQUENTIELLE));

		JRadioButton causale = new JRadioButton("Causale");
		causale.setActionCommand(String.valueOf(EnumAlgoDiffusion.COHERENCE_CAUSALE));

		ButtonGroup group = new ButtonGroup();
		group.add(atomique);
		group.add(sequentielle);
		group.add(causale);

		EspaceBoutons espaceBoutons = new EspaceBoutons(generateur, new GridLayout(3, 1));

		espaceBoutons.add(atomique);
		espaceBoutons.add(sequentielle);
		espaceBoutons.add(causale);

		atomique.addActionListener(espaceBoutons);
		sequentielle.addActionListener(espaceBoutons);
		causale.addActionListener(espaceBoutons);

		fenetre.setEspaceBoutons(espaceBoutons);
	}
}
