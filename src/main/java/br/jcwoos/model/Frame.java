package br.jcwoos.model;

import java.util.ArrayList;
import java.util.List;

public class Frame {

	private List<Roll> rolls;

	private int frameNumber;

	private Frame previousFrame;

	public Frame(int number) {
		frameNumber = number;
		rolls = new ArrayList<>();
	}

	public void addRoll(Roll roll) {
		rolls.add(roll);
	}

	public List<Roll> getRolls() {
		return rolls;
	}

	public int getFrameNumber() {
		return frameNumber;
	}

	public int getRollsCount() {
		return rolls == null ? 0 : rolls.size();
	}

	public int getTotalPinsDown() {
		return rolls.stream().map(Roll::getPinfalls).reduce(0, Integer::sum);
	}

	public Integer getScore() {
		Integer previousScore = previousFrame == null ? 0 : previousFrame.getScore();
		Roll r1 = rolls.get(0);
		if (frameNumber == 10) { return previousScore + r1.getPinfalls() + r1.getNextTwoRollsPinFalls(); }
		if (r1.getPinfalls() == 10) { return previousScore + r1.getPinfalls() + r1.getNextTwoRollsPinFalls(); }
		Roll r2 = rolls.get(1);
		if ((r1.getPinfalls() + r2.getPinfalls()) == 10) {
			return previousScore + r1.getPinfalls() + r2.getPinfalls() + r2.getNextRollPinFalls();
		} else {
			return previousScore + r1.getPinfalls() + r2.getPinfalls();
		}
	}

	public void setPreviousFrame(Frame previousFrame) {
		this.previousFrame = previousFrame;
	}
}
