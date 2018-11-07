package fr.istic.master.aoc;

import java.util.concurrent.Future;

public interface GenerateurAsync {

	Future<Integer> getValue();
}
