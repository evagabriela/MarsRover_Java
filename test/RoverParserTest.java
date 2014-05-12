import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverParserTest {


    @Test
    public void shouldExtractXCoordinateFromFileAsInteger(){
        String fileName = "resources/sampleInput.txt";

        int xCoordinate = new RoverParser(fileName).getXCoordinate();
        assertEquals(xCoordinate, 1);
    }

    @Test
    public void shouldExtractYCoordinateFromFileAsInteger(){
        String fileName = "resources/sampleInput.txt";

        int yCoordinates = new RoverParser(fileName).getYCoordinate();
        assertEquals(yCoordinates, 3);
    }

    @Test
    public void shouldExtractDirectionFromFileAsString(){
        String fileName = "resources/sampleInput.txt";

        String direction = new RoverParser(fileName).getDirection();
        assertEquals(direction, "N");
    }

}