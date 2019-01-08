package fr.istic.master.aoc.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * Définition de la fenêtre principale
 * 
 * @author michel & dorian
 *
 */
public class Fenetre extends JFrame {

	private static final long serialVersionUID = -8043020251216804567L;

	public Fenetre() {
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
