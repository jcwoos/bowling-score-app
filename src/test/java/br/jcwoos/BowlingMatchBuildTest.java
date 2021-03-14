package br.jcwoos;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.jcwoos.model.BowlingMatch;
import br.jcwoos.model.Roll;
import br.jcwoos.model.WrongNumberOfRollsException;

public class BowlingMatchBuildTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void shouldNotAllowMoreThan12Rolls() throws WrongNumberOfRollsException {

		List<Roll> rolls = new ArrayList<>();
		for (int i = 0; i < 13; i++) {
			rolls.add(new Roll("Player", 10, false));
		}
		exceptionRule.expect(WrongNumberOfRollsException.class);
		BowlingMatch.build(rolls);
	}

}