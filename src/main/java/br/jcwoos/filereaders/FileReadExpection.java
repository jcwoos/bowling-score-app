package br.jcwoos.filereaders;

/**
 * Custom exceptions allow us to be more specific when an error occours
 *
 */
public class FileReadExpection extends Exception {

	private static final long serialVersionUID = 1L;

	public FileReadExpection(String string) {
		super(string);
	}

}
