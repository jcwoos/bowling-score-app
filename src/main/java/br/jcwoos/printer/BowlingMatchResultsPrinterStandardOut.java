package br.jcwoos.printer;

import java.io.PrintStream;

import br.jcwoos.constants.Score;
import br.jcwoos.model.BowlingMatch;
import br.jcwoos.model.Frame;
import br.jcwoos.model.PlayerResult;
import br.jcwoos.model.Roll;

public class BowlingMatchResultsPrinterStandardOut implements BowlingMatchResultsPrinter {

	private static final String TAB = "\t";

	private static final String NEW_LINE = "\n";

	private PrintStream output = System.out;

	public void setOutput(PrintStream output) {
		this.output = output;
	}

	@Override
	public void printResults(BowlingMatch match) {
		print("Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10\n");
		match.getPlayerResults().forEach(result -> {
			print(result.getPlayerName(), NEW_LINE);
			printPinFallLine(result);
			printScoreLine(result);
		});
	}

	private void printScoreLine(PlayerResult result) {
		print("Score");
		result.getFrames().forEach(frame -> {
			print(TAB);
			printFrameScore(frame);
		});
		print(NEW_LINE);
	}

	private void printPinFallLine(PlayerResult result) {
		print("Pinfalls");
		result.getFrames().forEach(frame -> {
			print(TAB);
			printFramePinfalls(frame);
		});
		print(NEW_LINE);
	}

	private void printFrameScore(Frame frame) {
		print(TAB, frame.getScore().toString());
	}

	private void printFramePinfalls(Frame frame) {
		if (frame.getFrameNumber() == 10) {
			printLastFramePinfalls(frame);
			return;
		}

		Roll r1 = frame.getRolls().get(0);
		if (r1.getPinfalls() == 10) {
			print(TAB, Score.STRIKE);
			return;
		}

		Roll r2 = frame.getRolls().get(1);
		print(r1.isFoul() ? Score.FOUL : r1.getPinfalls().toString());

		if ((r1.getPinfalls() + r2.getPinfalls()) == 10) {
			print(TAB, Score.SPARE);
		} else {
			print(TAB, r2.isFoul() ? Score.FOUL : r2.getPinfalls().toString());
		}
	}

	private void printLastFramePinfalls(Frame frame) {
		Roll r1 = frame.getRolls().get(0);
		Roll r2 = frame.getRolls().get(1);
		if ((r1.getPinfalls() + r1.getNextTwoRollsPinFalls()) == 30) {
			print(Score.STRIKE, TAB, Score.STRIKE, TAB, Score.STRIKE);
			return;
		}
		if (r1.getPinfalls() == 10) {
			print(Score.STRIKE);
		} else {
			print(r1.isFoul() ? Score.FOUL : r1.getPinfalls().toString());
		}
		if ((r2.getPinfalls() > 0) && ((r1.getPinfalls() + r2.getPinfalls()) == 10)) {
			print(TAB, Score.SPARE);
		} else {
			print(TAB, r2.isFoul() ? Score.FOUL : r2.getPinfalls().toString());
		}

		if ((r1.getPinfalls() + r2.getPinfalls()) < 10) { return; }

		Roll r3 = frame.getRolls().get(2);
		if (r3.getPinfalls() == 10) {
			print(TAB, Score.STRIKE);
		} else {
			print(TAB, r3.isFoul() ? Score.FOUL : r3.getPinfalls().toString());
		}
	}

	private void print(String... something) {
		for (String string : something) {
			output.print(string);
		}
	}

}
