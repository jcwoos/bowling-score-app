package br.jcwoos.rollparser;

import java.util.ArrayList;
import java.util.List;

import br.jcwoos.constants.Score;
import br.jcwoos.filereaders.FileReadExpection;
import br.jcwoos.filereaders.FileReaderNio;
import br.jcwoos.model.Roll;

public class DefaultRollParser implements RollParser {

	private List<String> lines;

	public DefaultRollParser() {
	}

	public DefaultRollParser(FileReaderNio fileReaderNio) throws FileReadExpection {
		lines = fileReaderNio.readFile();
	}

	public DefaultRollParser(List<String> lines) {
		this.lines = lines;
	}

	@Override
	public List<Roll> parseLines() throws RollParserException {
		if (lines == null) { throw new RollParserException("No content to be parsed"); }
		List<Roll> rolls = new ArrayList<>();
		for (String rollText : lines) {
			rolls.add(parseLine(rollText));
		}
		return rolls;
	}

	@Override
	public Roll parseLine(String rollText) throws RollParserException {
		if ((rollText == null) || rollText.isEmpty()) { throw new RollParserException("Invalid input to be parsed"); }
		String[] splittedText = rollText.trim().split("\t");
		if (splittedText.length != 2) { throw new RollParserException("Invalid line format " + rollText); }
		String player = splittedText[0];
		String pinFalls = splittedText[1];
		boolean foul = Score.FOUL.equalsIgnoreCase(pinFalls);
		int pinFalls2 = foul ? 0 : Integer.parseInt(pinFalls);
		if ((pinFalls2 < 0) || (pinFalls2 > 10)) { throw new RollParserException("Invalid number of pins knocked down " + rollText); }
		return new Roll(player, pinFalls2, foul);
	}

}
