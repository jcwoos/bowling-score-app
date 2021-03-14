package br.jcwoos.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class BowlingMatch {

	private List<PlayerResult> results = new ArrayList<>();

	public static BowlingMatch build(List<Roll> matchRolls) throws WrongNumberOfRollsException, InvalidScoreException {
		BowlingMatch bowlingMatch = new BowlingMatch();

		Map<String, List<Roll>> groupedRolls = matchRolls.stream().collect(Collectors.groupingBy(Roll::getPlayer));

		for (Entry<String, List<Roll>> entry : groupedRolls.entrySet()) {
			bowlingMatch.results.add(PlayerResult.build(entry.getKey(), entry.getValue()));
		}

		return bowlingMatch;
	}

	public List<PlayerResult> getPlayerResults() {
		return results;
	}
}
