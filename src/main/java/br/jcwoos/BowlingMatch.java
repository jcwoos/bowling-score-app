package br.jcwoos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import br.jcwoos.model.PlayerResult;
import br.jcwoos.model.Roll;
import br.jcwoos.model.WrongNumberOfFramesException;
import br.jcwoos.model.WrongNumberOfRollsException;

public class BowlingMatch {

	private List<PlayerResult> results = new ArrayList<>();

	public static BowlingMatch build(List<Roll> matchRolls) throws WrongNumberOfFramesException, WrongNumberOfRollsException {
		BowlingMatch bowlingMatch = new BowlingMatch();

		Map<String, List<Roll>> groupedRolls = matchRolls.stream().collect(Collectors.groupingBy(Roll::getPlayer));

		Set<Entry<String, List<Roll>>> set = groupedRolls.entrySet();
		for (Entry<String, List<Roll>> entry : set) {
			bowlingMatch.results.add(PlayerResult.build(entry.getKey(), entry.getValue()));
		}
		return bowlingMatch;
	}

	public List<PlayerResult> getPlayerResults() {
		return results;
	}
}
