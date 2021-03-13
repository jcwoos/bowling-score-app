package br.jcwoos;

import br.jcwoos.filereaders.FileReaderNio;

public class App {

	protected static final String[] testCases = {
	        //	        "all_fouls.txt",
	        //	        "all_zeros.txt",
	        "perfect_score.txt",
	        "sample1.txt"
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

				if (fileNames.length > 1) {
					System.out.println();
					System.out.println();
				}
			} catch (Exception e) {
				System.out.println("error " + fileName);
				e.printStackTrace();
			}
		}
	}
}
