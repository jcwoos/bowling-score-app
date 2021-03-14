package br.jcwoos.rollparser;

import java.util.List;

import br.jcwoos.model.Roll;

public interface RollParser {

	List<Roll> parseLines() throws RollParserException;

	Roll parseLine(String string) throws RollParserException;
}
