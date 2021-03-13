package br.jcwoos;

import java.util.List;

import br.jcwoos.model.Roll;
import br.jcwoos.rollparser.RollParserException;

public interface RollParser {

	List<Roll> parseLines() throws RollParserException;

	Roll parseLine(String string) throws RollParserException;

}
