package br.jcwoos;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.jcwoos.filereaders.FileReadExpection;
import br.jcwoos.filereaders.FileReaderNio;

public class FileReaderNioTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void shouldThrowFileNotFoundException() throws FileReadExpection {
		exceptionRule.expect(FileReadExpection.class);
		exceptionRule.expectMessage("File some file not found!");
		new FileReaderNio("some file").readFile();
	}

	@Test
	public void shouldThrowEmptyFileException() throws FileReadExpection {
		exceptionRule.expect(FileReadExpection.class);
		exceptionRule.expectMessage("Empty file!");
		new FileReaderNio("empty.txt").readFile();
	}
}