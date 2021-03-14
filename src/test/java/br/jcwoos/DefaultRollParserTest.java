package br.jcwoos;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sun.tools.javac.util.List;

import br.jcwoos.rollparser.DefaultRollParser;
import br.jcwoos.rollparser.RollParserException;

/**
 * Unit test for simple App.
 */
public class DefaultRollParserTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void parsingRoll1() throws RollParserException {
		// testing simple case
		assertEquals(1, new DefaultRollParser().parseLine("Name\t1").getPinfalls().intValue());
	}

	@Test
	public void parsingRoll2() throws RollParserException {
		// testing simple case
		assertEquals(10, new DefaultRollParser().parseLine("Name\t10").getPinfalls().intValue());
	}

	@Test
	public void parsingRoll3() throws RollParserException {
		// testing simple case
		// must accept F and f on the file
		assertEquals(0, new DefaultRollParser().parseLine("Name\tF").getPinfalls().intValue());
		assertEquals(0, new DefaultRollParser().parseLine("Name\tf").getPinfalls().intValue());
	}

	@Test
	public void parsingRoll4() throws RollParserException {
		// DefaultRollParser throw an error if it has nothing to parse
		exceptionRule.expect(RollParserException.class);
		exceptionRule.expectMessage("No content to be parsed");
		new DefaultRollParser().parseLines();
	}

	@Test
	public void parsingRoll5() throws RollParserException {
		// testing simple case
		assertEquals(1, new DefaultRollParser(List.of("Name\t10")).parseLines().size());
	}

}
