import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

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
    public void shouldCreateARoverObject(){
        ArrayList<String> direction = new ArrayList<String>(Arrays.asList("L", "M", "L"));
        Rover rover = new Rover(1, 2, "N", direction);

        assertEquals(rover, roverparser.createRover("1 2 N", "LML"));
    }

    @Test
    public void shouldCreatePlateauObject(){
        Plateau plateau = new Plateau(5, 5);

        assertEquals(plateau,roverparser.createPlateau("5 5"));
    }

}