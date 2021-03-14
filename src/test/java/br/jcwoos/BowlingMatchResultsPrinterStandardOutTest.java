package br.jcwoos;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import br.jcwoos.exception.BowlingException;
import br.jcwoos.filereader.FileReaderNio;
import br.jcwoos.model.BowlingMatch;
import br.jcwoos.printer.BowlingMatchResultsPrinterStandardOut;
import br.jcwoos.rollparser.DefaultRollParser;
import br.jcwoos.rollparser.RollParser;

public class BowlingMatchResultsPrinterStandardOutTest {

	@Test
	public void shoulHaveThisOutputForAPerfectScore() throws BowlingException, UnsupportedEncodingException {
		RollParser rollParser = new DefaultRollParser(new FileReaderNio("sample_cases/perfect_score.txt"));
		String expected = "Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10\n" +
		        "Carl\n" +
		        "Pinfalls\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\tX\tX\tX\n" +
		        "Score\t\t30\t\t60\t\t90\t\t120\t\t150\t\t180\t\t210\t\t240\t\t270\t\t300\n";
		BowlingMatch match = new BowlingMatch.Builder(rollParser.parseLines()).build();

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

	@Test
	public void shoulHaveThisOutputForAAllZeros() throws BowlingException, UnsupportedEncodingException {
		RollParser rollParser = new DefaultRollParser(new FileReaderNio("sample_cases/all_zeros.txt"));
		String expected = "Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10\n" +
		        "Newbie\n" +
		        "Pinfalls\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\n" +
		        "Score\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\n";

		BowlingMatch match = new BowlingMatch.Builder(rollParser.parseLines()).build();

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

	@Test
	public void shoulHaveThisOutputForTheSample() throws BowlingException, UnsupportedEncodingException {
		RollParser rollParser = new DefaultRollParser(new FileReaderNio("sample_cases/sample1.txt"));
		String expected = "Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10\n" +
		        "Jeff\n" +
		        "Pinfalls\t\tX\t7\t/\t9\t0\t\tX\t0\t8\t8\t/\tF\t6\t\tX\t\tX\tX\t8\t1\n" +
		        "Score\t\t20\t\t39\t\t48\t\t66\t\t74\t\t84\t\t90\t\t120\t\t148\t\t167\n" +
		        "John\n" +
		        "Pinfalls\t3\t/\t6\t3\t\tX\t8\t1\t\tX\t\tX\t9\t0\t7\t/\t4\t4\tX\t9\t0\n" +
		        "Score\t\t16\t\t25\t\t44\t\t53\t\t82\t\t101\t\t110\t\t124\t\t132\t\t151\n";

		BowlingMatch match = new BowlingMatch.Builder(rollParser.parseLines()).build();

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
