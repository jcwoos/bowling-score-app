package br.jcwoos;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import br.jcwoos.filereaders.FileReadExpection;
import br.jcwoos.filereaders.FileReaderNio;
import br.jcwoos.model.BowlingMatch;
import br.jcwoos.model.WrongNumberOfRollsException;
import br.jcwoos.printer.BowlingMatchResultsPrinterStandardOut;
import br.jcwoos.rollparser.DefaultRollParser;
import br.jcwoos.rollparser.RollParser;
import br.jcwoos.rollparser.RollParserException;

public class BowlingMatchResultsPrinterStandardOutTest {

	@Test
	public void shouldAnswerWithTrue() throws FileReadExpection, WrongNumberOfRollsException, RollParserException, UnsupportedEncodingException {
		RollParser rollParser = new DefaultRollParser(new FileReaderNio("perfect_score.txt"));
		String expected = "Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10\n" +
		        "Carl\n" +
		        "Pinfalls\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\tX\tX\n" +
		        "Score\t\t30\t\t60\t\t90\t\t120\t\t150\t\t180\t\t210\t\t240\t\t270\t\t300\n";
		BowlingMatch match = BowlingMatch.build(rollParser.parseLines());

		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		final String utf8 = StandardCharsets.UTF_8.name();
		try (PrintStream ps = new PrintStream(baos, true, utf8)) {
			BowlingMatchResultsPrinterStandardOut printer = new BowlingMatchResultsPrinterStandardOut();
			// using my print stream to capture what will be printed
			printer.setOutput(ps);

			printer.printResults(match);
		}
		// retrieving the printed data
		String data = baos.toString(utf8);

		// verifying ..
		assertEquals(expected, data);
	}
}
