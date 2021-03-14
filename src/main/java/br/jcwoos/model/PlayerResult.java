package br.jcwoos.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerResult {

	private String playerName;

	private List<Frame> frames = new ArrayList<>();

	public PlayerResult(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public List<Frame> getFrames() {
		return List.copyOf(frames);
	}

	public static PlayerResult build(String playerName, List<Roll> rolls) throws WrongNumberOfRollsException {
		List<Frame> frames = new ArrayList<>();
		Frame actualFrame = new Frame(1);
		frames.add(actualFrame);
		Roll lastRoll = null;
		for (Roll roll : rolls) {
			if ((actualFrame.getFrameNumber() < 10) && ((actualFrame.getRollsCount() == 2) || (actualFrame.getTotalPinsDown() == 10))) {
				Frame newOne = new Frame(frames.size() + 1);
				frames.add(newOne);
				newOne.setPreviousFrame(actualFrame);
				actualFrame = newOne;
			}
			if ((actualFrame.getFrameNumber() == 10)) {
				if ((actualFrame.getRollsCount() == 2) && (actualFrame.getTotalPinsDown() < 10)) { throw new WrongNumberOfRollsException("The bonus roll will be available only if there are more than nine pins knocked down on the previous rolls"); }
				if (actualFrame.getRollsCount() == 3) { throw new WrongNumberOfRollsException("Until the tenth frame, only two rolls are accepted and on the tenth frame, only three rolls are accepted"); }
			}
			actualFrame.addRoll(roll);
			if (lastRoll != null) {
				lastRoll.setNextRoll(roll);
			}
			lastRoll = roll;
		}

		PlayerResult result = new PlayerResult(playerName);
		result.frames = frames;
		return result;
	}
}
