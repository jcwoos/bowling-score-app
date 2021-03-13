package br.jcwoos.rollparser;

/**
 * Custom exceptions allow us to be more specific when an error occours
 *
 */
public class RollParserException extends Exception {

	private static final long serialVersionUID = 1L;

	public RollParserException(String error) {
		super(error);
	}

}
