package br.jcwoos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.jcwoos.rollparser.DefaultRollParser;
import br.jcwoos.rollparser.RollParserException;

/**
 * Unit test for simple App.
 */
public class DefaultRollParserTest {

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
	public void parsingRoll4() {
		// DefaultRollParser don't accept space as separator
		try {
			new DefaultRollParser().parseLine("Name 1");
		} catch (RollParserException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void parsingRoll5() {
		// DefaultRollParser don't accept lines without a second value
		try {
			new DefaultRollParser().parseLine("Name1");
		} catch (RollParserException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void parsingRoll6() {
		// DefaultRollParser don't accept empty lines
		try {
			new DefaultRollParser().parseLine("");
		} catch (RollParserException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void parsingRoll7() {
		// DefaultRollParser don't accept null to parse
		try {
			new DefaultRollParser().parseLine(null);
		} catch (RollParserException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void parsingRoll8() {
		// DefaultRollParser don't accept lines with more than one tab as separator
		try {
			new DefaultRollParser().parseLine("Name\t\t1");
		} catch (RollParserException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void parsingRoll9() throws RollParserException {
		// DefaultRollParser don't accept values bellow zero
		try {
			new DefaultRollParser().parseLine("Name\t-1");
		} catch (RollParserException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void parsingRoll10() throws RollParserException {
		// DefaultRollParser don't accept values over 10
		try {
			new DefaultRollParser().parseLine("Name\t11");
		} catch (RollParserException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void parsingRoll11() throws RollParserException {
		// DefaultRollParser don't accept lines with more than two values
		try {
			new DefaultRollParser().parseLine("Name\t1\t2");
		} catch (RollParserException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void parsingRoll12() throws RollParserException {
		// DefaultRollParser throw an error if it has nothing to parse
		try {
			new DefaultRollParser().parseLines();
		} catch (RollParserException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
}
