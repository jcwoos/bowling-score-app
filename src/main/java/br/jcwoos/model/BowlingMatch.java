package br.jcwoos.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import br.jcwoos.exception.InvalidScoreException;
import br.jcwoos.exception.WrongNumberOfRollsException;

public class BowlingMatch {

	private List<PlayerResult> results;

	private BowlingMatch(Builder builder) {
		results = builder.results;
	}

	public List<PlayerResult> getPlayerResults() {
		return results;
	}

	public static class Builder {

		private List<PlayerResult> results;

		public Builder(List<Roll> matchRolls) throws WrongNumberOfRollsException, InvalidScoreException {
			results = new ArrayList<>();
			Map<String, List<Roll>> groupedRolls = matchRolls.stream().collect(Collectors.groupingBy(Roll::getPlayer, LinkedHashMap::new, Collectors.toList()));

			for (Entry<String, List<Roll>> entry : groupedRolls.entrySet()) {
				results.add(new PlayerResult.Builder(entry.getKey(), entry.getValue()).build());
			}
		}

		public BowlingMatch build() {
			return new BowlingMatch(this);
		}
	}
}
