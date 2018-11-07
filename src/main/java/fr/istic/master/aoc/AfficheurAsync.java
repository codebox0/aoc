package fr.istic.master.aoc;

import java.util.concurrent.Future;

public interface AfficheurAsync {

	Future<Object> update(Generateur g);
}
