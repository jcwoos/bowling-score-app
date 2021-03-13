package br.jcwoos.filereaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderNio implements FileReader {

	private String fileName;

	public FileReaderNio(String fileName) {
		super();
		this.fileName = fileName;
	}

	@Override
	public List<String> readFile() throws FileReadExpection {
		if (!exists()) { throw new FileReadExpection("File " + fileName + " not found!"); }
		Path path = Paths.get(fileName);
		try {
			List<String> content = Files.lines(path).collect(Collectors.toList());
			if (content.isEmpty()) { throw new FileReadExpection("Empty file!"); }
			return content;
		} catch (IOException e) {
			throw new FileReadExpection("Failed to read the file " + fileName);
		}
	}

	@Override
	public boolean exists() {
		Path path = Paths.get(fileName);
		return (path != null) && path.toFile().exists();
	}
}
