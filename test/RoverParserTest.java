import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RoverParserTest {


    @Test
    public void shouldExtractXCoordinateFromFileAsString(){
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        String fileName = "resources/sampleInput.txt";

        coordinates = new RoverParser(fileName).getCoordinates();
        assertEquals(coordinates.get(0).x, "1");
    }

    @Test
    public void shouldExtractYCoordinateFromFileAsString(){
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        String fileName = "resources/sampleInput.txt";

        coordinates = new RoverParser(fileName).getCoordinates();
        assertEquals(coordinates.get(0).y, "3");
    }

    @Test
    public void shouldExtractDirectionFromFileAsString(){
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        String fileName = "resources/sampleInput.txt";

        coordinates = new RoverParser(fileName).getCoordinates();
        assertEquals(coordinates.get(0).direction, "N");
    }

}