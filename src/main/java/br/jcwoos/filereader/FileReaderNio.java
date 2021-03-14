package br.jcwoos.filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderNio implements FileReader {

	private String fileName;

	public FileReaderNio(String fileName) {
		super();
		this.fileName = fileName;
	}

	@Override
	public List<String> readFile() throws FileReadExpection {
		return readFile(fileName);
	}

	@Override
	public List<String> readFile(String fileName) throws FileReadExpection {
		if (!exists()) { throw new FileReadExpection("File " + fileName + " not found!"); }
		Path path = Paths.get(fileName);
		try (Stream<String> stream = Files.lines(path)) {
			List<String> content = stream.collect(Collectors.toList());
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
