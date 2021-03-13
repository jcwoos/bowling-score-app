package br.jcwoos.printer;

import br.jcwoos.model.BowlingMatch;

public interface BowlingMatchResultsPrinter {

	/**
	 * must be able to print the result of a given match
	 * @param match
	 */
	void printResults(BowlingMatch match);
}
