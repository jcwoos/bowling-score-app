package br.jcwoos;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
		assertEquals(1, new DefaultRollParser().parseLine("Name\t1").getPinFalls().intValue());
	}

	@Test
	public void parsingRoll2() throws RollParserException {
		// testing simple case
		assertEquals(10, new DefaultRollParser().parseLine("Name\t10").getPinFalls().intValue());
	}

	@Test
	public void parsingRoll3() throws RollParserException {
		// testing simple case
		// must accept F and f on the file
		assertEquals(0, new DefaultRollParser().parseLine("Name\tF").getPinFalls().intValue());
		assertEquals(0, new DefaultRollParser().parseLine("Name\tf").getPinFalls().intValue());
	}

	@Test
	public void parsingRoll4() throws RollParserException {
		// DefaultRollParser don't accept space as separator

		exceptionRule.expect(RollParserException.class);

		new DefaultRollParser().parseLine("Name 1");

	}

	@Test
	public void parsingRoll5() throws RollParserException {
		// DefaultRollParser don't accept lines without a second value

		exceptionRule.expect(RollParserException.class);
		new DefaultRollParser().parseLine("Name1");

	}

	@Test
	public void parsingRoll6() throws RollParserException {
		// DefaultRollParser don't accept empty lines

		exceptionRule.expect(RollParserException.class);
		new DefaultRollParser().parseLine("");

	}

	@Test
	public void parsingRoll7() throws RollParserException {
		// DefaultRollParser don't accept null to parse

		exceptionRule.expect(RollParserException.class);
		new DefaultRollParser().parseLine(null);

	}

	@Test
	public void parsingRoll8() throws RollParserException {
		// DefaultRollParser don't accept lines with more than one tab as separator

		exceptionRule.expect(RollParserException.class);
		new DefaultRollParser().parseLine("Name\t\t1");
	}

	@Test
	public void parsingRoll9() throws RollParserException {
		// DefaultRollParser don't accept values bellow zero

		exceptionRule.expect(RollParserException.class);
		new DefaultRollParser().parseLine("Name\t-1");
	}

	@Test
	public void parsingRoll10() throws RollParserException {
		// DefaultRollParser don't accept values over 10

		exceptionRule.expect(RollParserException.class);
		new DefaultRollParser().parseLine("Name\t11");

	}

	@Test
	public void parsingRoll11() throws RollParserException {
		// DefaultRollParser don't accept lines with more than two values

		exceptionRule.expect(RollParserException.class);
		new DefaultRollParser().parseLine("Name\t1\t2");

	}

	@Test
	public void parsingRoll12() throws RollParserException {
		// DefaultRollParser throw an error if it has nothing to parse

		exceptionRule.expect(RollParserException.class);
		new DefaultRollParser().parseLines();

	}
}
