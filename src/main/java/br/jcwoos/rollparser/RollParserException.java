package br.jcwoos.rollparser;

import br.jcwoos.exception.BowlingException;

/**
 * Custom exceptions allow us to be more specific when an error occours
 *
 */
public class RollParserException extends BowlingException {

	private static final long serialVersionUID = 1L;

	public RollParserException(String error) {
		super(error);
	}

}
