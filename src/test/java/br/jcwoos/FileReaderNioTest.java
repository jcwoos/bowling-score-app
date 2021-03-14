package br.jcwoos;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.jcwoos.exception.BowlingException;
import br.jcwoos.filereader.FileReadExpection;
import br.jcwoos.filereader.FileReaderNio;

public class FileReaderNioTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void shouldThrowFileNotFoundException() throws BowlingException {
		exceptionRule.expect(FileReadExpection.class);
		exceptionRule.expectMessage("File some file not found!");
		new FileReaderNio("some file").readFile();
	}

	@Test
	public void shouldThrowEmptyFileException() throws BowlingException {
		exceptionRule.expect(FileReadExpection.class);
		exceptionRule.expectMessage("Empty file!");
		new FileReaderNio("sample_cases/empty.txt").readFile();
	}
}