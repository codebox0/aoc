package fr.istic.master.aoc.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

	private static final long serialVersionUID = -8043020251216804567L;
	private JPanel espaceBoutons;
	private JPanel espaceAfficheurs;

	public Fenetre() {
		setLayout(new BorderLayout());
		setSize(new Dimension(600, 600));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		espaceBoutons = new JPanel();
		espaceBoutons.setLayout(new GridLayout(3, 1));
		espaceAfficheurs = new JPanel(new GridLayout(2, 2));

		this.add(espaceBoutons, BorderLayout.WEST);
		this.add(espaceAfficheurs, BorderLayout.CENTER);
	}

	public JPanel getEspaceBoutons() {
		return espaceBoutons;
	}

	public JPanel getEspaceAfficheur() {
		return espaceAfficheurs;
	}

}
