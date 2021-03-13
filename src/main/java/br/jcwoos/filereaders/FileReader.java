package br.jcwoos.filereaders;

import java.util.List;

public interface FileReader {

	List<String> readFile() throws FileReadExpection;

	boolean exists();
}
