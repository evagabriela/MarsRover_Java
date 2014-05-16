import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RoverParserTest {
    private String fileName;
    private RoverParser roverparser;

    @Before
    public void setUp() throws IOException {
        fileName = "abc";
        roverparser = new RoverParser(fileName);
    }

    @Test
    public void shouldCreatePlateauWithParsingInput() throws Exception {
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("5 5").thenReturn("1 2 N").thenReturn("LMLML").thenReturn(null);
        RoverParser spy = spy(roverparser);
        spy.parseFile(bufferedReader);

        verify(spy).createPlateau("5 5");
    }

    @Test
    public void shouldCreateRoverWithParsingInput() throws IOException {
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("5 5").thenReturn("1 2 N").thenReturn("LMLML").thenReturn(null);
        RoverParser spy = spy(roverparser);

        spy.parseFile(bufferedReader);
        verify(spy).createRover("1 2 N", "LMLML");
    }

    @Test
    public void shouldCreateMultipleRovers() throws IOException {
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("5 5").thenReturn("1 2 N").thenReturn("LMLML").thenReturn("2 3 N").thenReturn("MMMMM").thenReturn(null);
        RoverParser spy = spy(roverparser);

        spy.parseFile(bufferedReader);
        verify(spy).createRover("1 2 N", "LMLML");
        verify(spy).createRover("2 3 N", "MMMMM");

    }

    @Test
    public void shouldCreateARoverObject() throws IOException {
        Rover rover = new Rover(1, 2, "N", "LMLM");

        assertEquals(rover, roverparser.createRover("1 2 N", "LMLM"));
    }

    @Test
    public void shouldCreatePlateauObject() throws IOException {
        Plateau plateau = new Plateau(5, 5);

        assertEquals(plateau, roverparser.createPlateau("5 5"));
    }


}