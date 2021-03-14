package br.jcwoos;

import br.jcwoos.filereaders.FileReaderNio;
import br.jcwoos.filereaders.exception.BowlingException;
import br.jcwoos.model.BowlingMatch;
import br.jcwoos.printer.BowlingMatchResultsPrinter;
import br.jcwoos.printer.BowlingMatchResultsPrinterStandardOut;
import br.jcwoos.rollparser.DefaultRollParser;
import br.jcwoos.rollparser.RollParser;

public class App {

	protected static final String[] testCases = {
	        "sample_cases/all_fouls.txt",
	        "sample_cases/all_zeros.txt",
	        "sample_cases/empty.txt",
	        "sample_cases/perfect_score.txt",
	        "sample_cases/sample1.txt",
	        "sample_cases/too_much_frames.txt"
	};

	public static void main(String[] fileNames) {
		if (fileNames.length == 0) {
			fileNames = testCases;
		}

		for (String fileName : fileNames) {
			try {
				if (fileNames.length > 1) {
					System.out.println(fileName);
				}
				RollParser rollParser = new DefaultRollParser(new FileReaderNio(fileName));

				BowlingMatch match = BowlingMatch.build(rollParser.parseLines());

				BowlingMatchResultsPrinter printer = new BowlingMatchResultsPrinterStandardOut();
				printer.printResults(match);

			} catch (Exception e) {
				System.out.println("Error parsing the file: " + fileName);
				System.out.println(e.getMessage());
				if (!(e instanceof BowlingException)) {
					e.printStackTrace();
				}
			}
			if (fileNames.length > 1) {
				System.out.println();
				System.out.println();
			}
		}
	}
}
