package br.jcwoos.model;

import java.util.ArrayList;
import java.util.List;

import br.jcwoos.exceptions.WrongNumberOfFramesException;
import br.jcwoos.exceptions.WrongNumberOfRollsException;

public class PlayerResult {

	private String playerName;

	private List<Frame> frames = new ArrayList<>();

	private Frame actualFrame;

	public PlayerResult(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public List<Frame> getFrames() {
		return List.copyOf(frames);
	}

	public Frame getActualFrame() {
		return actualFrame;
	}

	public static PlayerResult build(String playerName, List<Roll> rolls) throws WrongNumberOfFramesException, WrongNumberOfRollsException {
		List<Frame> frames = new ArrayList<>();
		Frame actualFrame = new Frame(1);
		frames.add(actualFrame);
		Roll lastRoll = null;
		for (Roll roll : rolls) {
			if ((actualFrame.getFrameNumber() < 10) && ((actualFrame.getRowsCount() == 2) || (actualFrame.getTotalPinsDown() == 10))) {
				Frame newOne = new Frame(frames.size() + 1);
				frames.add(newOne);
				newOne.setPreviousFrame(actualFrame);
				actualFrame = newOne;
			}

			if (((actualFrame.getFrameNumber() == 10) && (actualFrame.getRolls().size() > 3))) { throw new WrongNumberOfRollsException("Until the tenth frame, only two rolls are accepted and on the tenth frame, only three rolls are accepted"); }

			if (actualFrame.getFrameNumber() > 10) { throw new WrongNumberOfFramesException("The bowling match contains only 10 frames"); }

			actualFrame.addRoll(roll);
			if (lastRoll != null) {
				lastRoll.setNextRoll(roll);
			}
			lastRoll = roll;
		}
		PlayerResult result = new PlayerResult(playerName);
		result.playerName = playerName;
		result.frames = frames;
		return result;
	}
}
