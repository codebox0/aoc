package fr.istic.master.aoc.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

	private static final long serialVersionUID = -8043020251216804567L;

	public Fenetre() {
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setEspaceBoutons(EspaceBoutons espaceBoutons) {
		espaceBoutons.setBounds(0, 0, 50, 50);
		this.add(espaceBoutons, BorderLayout.WEST);
	}

	public void setEspaceAfficheurs(JPanel espaceAfficheurs) {
		espaceAfficheurs.setBounds(50, 0, 100, 50);
		this.add(espaceAfficheurs, BorderLayout.CENTER);
	}

}
