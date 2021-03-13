package br.jcwoos.rollparser;

import br.jcwoos.exceptions.BowlingScoreCalculatorException;

public class RollParserException extends BowlingScoreCalculatorException {

	private static final long serialVersionUID = 1L;

	public RollParserException(String error) {
		super(error);
	}

}
