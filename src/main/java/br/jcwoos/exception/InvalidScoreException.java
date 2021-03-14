package br.jcwoos.exception;

/**
 * Custom exceptions allow us to be more specific when an error occours
 *
 */
public class InvalidScoreException extends BowlingException {

	private static final long serialVersionUID = 1L;

	public InvalidScoreException(String error) {
		super(error);
	}

}
