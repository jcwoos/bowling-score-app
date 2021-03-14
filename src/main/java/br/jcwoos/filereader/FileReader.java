package br.jcwoos.filereaders;

import java.util.List;

public interface FileReader {

	/**
	 * Must be able to read a file
	 * @return
	 * @throws FileReadExpection
	 */
	List<String> readFile() throws FileReadExpection;

	/**
	 * Must be able to read a file
	 * @param fileName
	 * @return
	 * @throws FileReadExpection
	 */
	List<String> readFile(String fileName) throws FileReadExpection;

	/**
	 * Must be able to indicate if the file exists
	 * @return
	 */
	boolean exists();
}
