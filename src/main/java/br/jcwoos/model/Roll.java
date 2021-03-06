package br.jcwoos.model;

public class Roll {

	private String player;

	private Integer pinfalls;

	private Roll nextRoll;

	private boolean foul;

	public Roll(String player, Integer pinfalls, boolean foul) {
		this.player = player;
		this.pinfalls = pinfalls;
		this.foul = foul;
	}

	public String getPlayer() {
		return player;
	}

	public Integer getPinfalls() {
		return pinfalls;
	}

	public boolean isFoul() {
		return foul;
	}

	public Roll getNextRoll() {
		return nextRoll;
	}

	public void setNextRoll(Roll nextRoll) {
		this.nextRoll = nextRoll;
	}

	public Integer getNextTwoRollsPinFalls() {
		if (nextRoll == null) { return 0; }
		Integer firstNextRollPinFalls = nextRoll.pinfalls;
		if (nextRoll.nextRoll == null) { return firstNextRollPinFalls; }
		Integer secondNextRollPinFalls = nextRoll.nextRoll.pinfalls;
		return firstNextRollPinFalls + secondNextRollPinFalls;
	}

	public Integer getNextRollPinFalls() {
		return (nextRoll == null) ? 0 : nextRoll.pinfalls;
	}

}
