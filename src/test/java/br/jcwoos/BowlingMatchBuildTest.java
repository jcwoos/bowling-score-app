package br.jcwoos;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.jcwoos.exception.BowlingException;
import br.jcwoos.exception.InvalidScoreException;
import br.jcwoos.exception.WrongNumberOfRollsException;
import br.jcwoos.model.BowlingMatch;
import br.jcwoos.model.Roll;

public class BowlingMatchBuildTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void shouldNotAllowMoreThan12Rolls() throws BowlingException {

		List<Roll> rolls = new ArrayList<>();
		for (int i = 0; i < 13; i++) {
			rolls.add(new Roll("Player", 10, false));
		}
		exceptionRule.expect(WrongNumberOfRollsException.class);
		BowlingMatch.build(rolls);
	}

	@Test
	public void shouldNotAllowMoreThan10PointsInAFrame() throws BowlingException {

		List<Roll> rolls = new ArrayList<>();
		for (int i = 0; i < 13; i++) {
			rolls.add(new Roll("Player", 6, false));
		}
		exceptionRule.expect(InvalidScoreException.class);
		BowlingMatch.build(rolls);
	}

	@Test
	public void shouldNotAllowMoreThan10PointsInTheLastFrame() throws BowlingException {

		List<Roll> rolls = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			rolls.add(new Roll("Player", 10, false));
		}
		rolls.add(new Roll("Player", 6, false));
		rolls.add(new Roll("Player", 6, false));
		exceptionRule.expect(InvalidScoreException.class);
		BowlingMatch.build(rolls);
	}

}