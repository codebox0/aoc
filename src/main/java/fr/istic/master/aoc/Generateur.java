package fr.istic.master.aoc;

import java.util.Observer;

public interface Generateur {

	void attach(Observer o);

	void detach(Observer o);

	Integer getValue();
}
