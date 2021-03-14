package br.jcwoos.model;

import java.util.ArrayList;
import java.util.List;

import br.jcwoos.exception.InvalidScoreException;
import br.jcwoos.exception.WrongNumberOfRollsException;

public class PlayerResult {

	private String playerName;

	private List<Frame> frames;

	private PlayerResult(Builder builder) {
		playerName = builder.playerName;
		frames = builder.frames;
	}

	public String getPlayerName() {
		return playerName;
	}

	public List<Frame> getFrames() {
		return List.copyOf(frames);
	}

	public static class Builder {

		private String playerName;

		private List<Frame> frames;

		List<Roll> rolls;

		public Builder(String playerName, List<Roll> rolls) {
			this.playerName = playerName;
			this.rolls = rolls;
		}

		private Frame startNewFrame(Frame currentFrame) {
			Frame newOne = new Frame(frames.size() + 1);
			frames.add(newOne);
			newOne.setPreviousFrame(currentFrame);
			currentFrame = newOne;
			return currentFrame;
		}

		public PlayerResult build() throws InvalidScoreException, WrongNumberOfRollsException {
			frames = new ArrayList<>();
			Frame currentFrame = new Frame(1);
			frames.add(currentFrame);
			Roll lastRoll = null;
			for (Roll roll : rolls) {
				if ((currentFrame.getFrameNumber() < 10) && ((currentFrame.getRollsCount() == 2) || (currentFrame.getTotalPinsDown() == 10))) {
					currentFrame = startNewFrame(currentFrame);
				}

				if ((currentFrame.getFrameNumber() == 10)) {
					if ((currentFrame.getRollsCount() == 1)
					        && (lastRoll.getPinfalls() < 10)
					        && ((roll.getPinfalls() + lastRoll.getPinfalls()) > 10)) { throw new InvalidScoreException("The sum of the first two rows on the frame can't be greater than 10"); }
					if ((currentFrame.getRollsCount() == 2) && (currentFrame.getTotalPinsDown() < 10)) { throw new WrongNumberOfRollsException("The bonus roll will be available only if there are more than nine pins knocked down on the previous rolls"); }
					if (currentFrame.getRollsCount() == 3) { throw new WrongNumberOfRollsException("Until the tenth frame, only two rolls are accepted and on the tenth frame, only three rolls are accepted"); }
				} else {
					if ((currentFrame.getRollsCount() == 1) && ((roll.getPinfalls() + lastRoll.getPinfalls()) > 10)) { throw new InvalidScoreException("The sum of the first two rows on the frame can't be greater than 10"); }
				}
				currentFrame.addRoll(roll);
				if (lastRoll != null) {
					lastRoll.setNextRoll(roll);
				}
				lastRoll = roll;
			}
			return new PlayerResult(this);
		}
	}
}