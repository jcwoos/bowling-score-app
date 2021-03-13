package br.jcwoos;

import java.util.List;

import br.jcwoos.filereaders.FileReadExpection;
import br.jcwoos.filereaders.FileReaderNio;
import br.jcwoos.model.Roll;
import br.jcwoos.rollparser.RollParserException;

public class DefaultRollParser implements RollParser {

	private List<String> lines;

	public DefaultRollParser(FileReaderNio fileReaderNio) throws FileReadExpection {
		lines = fileReaderNio.readFile();
	}

	@Override
	public List<Roll> parseLines() {
		return null;
	}

	@Override
	public Roll parseLine(String string) throws RollParserException {

		return null;
	}

}
