package br.jcwoos.model;

public class Roll {

	private String player;

	private Integer pinFalls;

	private Roll nextRoll;

	private boolean foul;

	public Roll(String player, Integer pinFalls, boolean foul) {
		this.player = player;
		this.pinFalls = pinFalls;
		this.foul = foul;
	}

	public String getPlayer() {
		return player;
	}

	public Integer getPinFalls() {
		return pinFalls;
	}

	public boolean isFoul() {
		return foul;
	}

	public Roll getNextRoll() {
		return nextRoll;
	}

	public void setNextRoll(Roll delivery) {
		nextRoll = delivery;
	}

	public Integer getNextTwoRollsPinFalls() {
		if (nextRoll == null) { return 0; }
		Integer firstNextRollPinFalls = nextRoll.pinFalls;
		if (nextRoll.nextRoll == null) { return firstNextRollPinFalls; }
		Integer secondNextRollPinFalls = nextRoll.nextRoll.pinFalls;
		return firstNextRollPinFalls + secondNextRollPinFalls;
	}

	public Integer getNextRollPinFalls() {
		return (nextRoll == null) ? 0 : nextRoll.pinFalls;
	}

}
