package br.jcwoos.model;

/**
 * Custom exceptions allow us to be more specific when an error occours
 *
 */
public class WrongNumberOfRollsException extends Exception {

	private static final long serialVersionUID = 1L;

	public WrongNumberOfRollsException(String string) {
		super(string);
	}

}
