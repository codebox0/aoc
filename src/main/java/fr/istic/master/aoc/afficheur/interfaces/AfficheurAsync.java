package fr.istic.master.aoc.afficheur.interfaces;

import java.util.concurrent.Future;

import fr.istic.master.aoc.generateur.interfaces.Generateur;

public interface AfficheurAsync {

	Future<Object> update(Generateur g);
}
