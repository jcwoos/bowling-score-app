package br.jcwoos;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.jcwoos.exception.BowlingException;
import br.jcwoos.rollparser.DefaultRollParser;
import br.jcwoos.rollparser.RollParserException;

/**
 * Unit test for simple App.
 */
public class DefaultRollParserTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void parsingRoll1() throws BowlingException {
		// testing simple case
		assertEquals(1, new DefaultRollParser().parseLine("Name\t1").getPinfalls().intValue());
	}

	@Test
	public void parsingRoll2() throws BowlingException {
		// testing simple case
		assertEquals(10, new DefaultRollParser().parseLine("Name\t10").getPinfalls().intValue());
	}

	@Test
	public void parsingRoll3() throws BowlingException {
		// testing simple case
		// must accept F and f on the file
		assertEquals(0, new DefaultRollParser().parseLine("Name\tF").getPinfalls().intValue());
		assertEquals(0, new DefaultRollParser().parseLine("Name\tf").getPinfalls().intValue());
	}

	@Test
	public void parsingRoll4() throws BowlingException {
		// DefaultRollParser throw an error if it has nothing to parse
		exceptionRule.expect(RollParserException.class);
		exceptionRule.expectMessage("No content to be parsed");
		new DefaultRollParser().parseLines();
	}

	@Test
	public void parsingRoll5() throws BowlingException {
		// testing simple case
		assertEquals(1, new DefaultRollParser(List.of("Name\t10")).parseLines().size());
	}

}
