package br.jcwoos;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.jcwoos.rollparser.DefaultRollParser;
import br.jcwoos.rollparser.RollParserException;

@RunWith(Parameterized.class)
public class DefaultRollParserParametrizedTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	private final String invalidInput;

	@Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] {
		        { null }, { "" }, { "Name1" },
		        { "Name 1" }, { "Name\t\t1" }, { "Name\t1\t12" },
		        { "Name\t-1" }, { "Name\t11" } });
	}

	public DefaultRollParserParametrizedTest(String invalidInput) {
		this.invalidInput = invalidInput;
	}

	@Test
	public void parsingInvalidData() throws RollParserException {
		// DefaultRollParser don't accept space as separator

		exceptionRule.expect(RollParserException.class);

		new DefaultRollParser().parseLine(invalidInput);

	}
}
