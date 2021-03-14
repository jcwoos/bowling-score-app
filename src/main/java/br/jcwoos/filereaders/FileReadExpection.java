package br.jcwoos.filereaders;

import br.jcwoos.filereaders.exception.BowlingException;

/**
 * Custom exceptions allow us to be more specific when an error occours
 *
 */
public class FileReadExpection extends BowlingException {

	private static final long serialVersionUID = 1L;

	public FileReadExpection(String string) {
		super(string);
	}

}
