package br.jcwoos.model;

import br.jcwoos.filereaders.exception.BowlingException;

/**
 * Custom exceptions allow us to be more specific when an error occours
 *
 */
public class WrongNumberOfRollsException extends BowlingException {

	private static final long serialVersionUID = 1L;

	public WrongNumberOfRollsException(String string) {
		super(string);
	}

}
