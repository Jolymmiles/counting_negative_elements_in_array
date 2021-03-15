import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public TestMain() {
        Locale.setDefault(new Locale("en", "US"));
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainFirst() {
        String data = "1 3 -1 -10 0";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "2 -11";
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testMainSecond() {
        String data = "-1 -2 -3 -4 0 -10 -11 -12 14";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "7 -43";
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testMainThird() {
        String data = "0 0 0 0 0 0";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "0 0";
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testMainForth() {
        String data = "0";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "0 0";
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testMainFifth() {
        String data = "100 1240 94 985 34 883 438 434 34388 23 8483 4388 213 34834 3843 4384 2388 434";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "0 0";
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }
}