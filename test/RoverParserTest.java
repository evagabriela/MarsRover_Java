import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RoverParserTest {
    private String fileName;
    private RoverParser roverparser;

    @Before
    public void setUp() throws IOException {
       fileName = "resources/sampleInput.txt";
       roverparser = new RoverParser(fileName);
       roverparser.parseFile();
    }

    @Test
    public void shouldExtractPlateauCoordinates() throws IOException {
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("5 5");
        String line = bufferedReader.readLine();

        String plateauCoordinates = roverparser.getPlateauCoordinates();

        assertEquals(line, plateauCoordinates);
    }

    @Test
    public void shouldExtractRoverInitialLocationAndDirection() throws IOException {
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("1 3 N");
        String line = bufferedReader.readLine();

        String roverInitialLocationAndDirection = roverparser.getRoverInitialLocationDirection();

        assertEquals(line, roverInitialLocationAndDirection);
    }



    @Test
    public void shouldCreateARoverObject(){
        ArrayList<String> instructions = new ArrayList<String>(Arrays.asList("L", "M", "L"));
        Rover rover = new Rover(1, 2, "N", instructions);

        assertEquals(rover, roverparser.createRover("1 2 N", "L,M,L"));
    }

    @Test
    public void shouldCreatePlateauObject() throws IOException {
        Plateau plateau = new Plateau(5, 5);

        assertEquals(plateau,roverparser.createPlateau());
    }


}