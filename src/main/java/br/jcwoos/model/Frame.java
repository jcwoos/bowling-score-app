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

	public int getRowsCount() {
		return rolls == null ? 0 : rolls.size();
	}

	public int getTotalPinsDown() {
		int totalPinsDown = 0;
		for (Roll roll : rolls) {
			totalPinsDown += roll.getPinFalls();
		}
		return totalPinsDown;
	}

	public Integer getScore() {
		Integer previousScore = previousFrame == null ? 0 : previousFrame.getScore();
		Roll r1 = rolls.get(0);
		if (frameNumber < 10) {
			if (r1.getPinFalls() == 10) { return previousScore + r1.getPinFalls() + r1.getNextTwoRollsPinFalls(); }
			Roll r2 = rolls.get(1);
			if ((r1.getPinFalls() + r2.getPinFalls()) == 10) {
				return previousScore + r1.getPinFalls() + r2.getPinFalls() + r2.getNextRollPinFalls();
			} else {
				return previousScore + r1.getPinFalls() + r2.getPinFalls();
			}
		} else {
			return previousScore + r1.getPinFalls() + r1.getNextTwoRollsPinFalls();
		}
	}

	public void setPreviousFrame(Frame previousFrame) {
		this.previousFrame = previousFrame;
	}
}
