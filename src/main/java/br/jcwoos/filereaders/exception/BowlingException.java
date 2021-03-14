package br.jcwoos.filereaders.exception;

/**
 * Custom exceptions allow us to be more specific when an error occours
 *
 */
public class BowlingException extends Exception {

	private static final long serialVersionUID = 1L;

	public BowlingException(String error) {
		super(error);
	}

}
