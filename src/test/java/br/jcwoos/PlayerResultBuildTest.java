package br.jcwoos;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.jcwoos.exception.BowlingException;
import br.jcwoos.exception.WrongNumberOfRollsException;
import br.jcwoos.model.PlayerResult;
import br.jcwoos.model.Roll;

public class PlayerResultBuildTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void shouldNotAllowMoreThan12Rolls() throws BowlingException {

		List<Roll> rolls = new ArrayList<>();
		for (int i = 0; i < 23; i++) {
			rolls.add(new Roll("Player", 10, false));
		}
		exceptionRule.expect(WrongNumberOfRollsException.class);
		new PlayerResult.Builder("Player", rolls).build();
	}

	@Test
	public void shouldAllow12Rolls() {

		List<Roll> rolls = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			rolls.add(new Roll("Player", 10, false));
		}
		try {
			new PlayerResult.Builder("Player", rolls).build();
		} catch (BowlingException e) {
			fail();
		}
	}

	@Test
	public void shouldNotAllowMoreThan21Rolls() throws BowlingException {
		List<Roll> rolls = new ArrayList<>();
		for (int i = 0; i < 21; i++) {
			rolls.add(new Roll("Player", 1, false));
		}
		exceptionRule.expect(WrongNumberOfRollsException.class);
		new PlayerResult.Builder("Player", rolls).build();
	}

	@Test
	public void shouldAllow20Rolls() {

		List<Roll> rolls = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			rolls.add(new Roll("Player", 1, false));
		}
		try {
			new PlayerResult.Builder("Player", rolls).build();
		} catch (BowlingException e) {
			fail();
		}
	}
}