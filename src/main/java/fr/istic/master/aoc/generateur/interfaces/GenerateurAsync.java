package fr.istic.master.aoc.generateur.interfaces;

import java.util.concurrent.Future;

public interface GenerateurAsync {

	Future<Integer> getValue();
}
