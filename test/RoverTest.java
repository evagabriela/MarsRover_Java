import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RoverTest {

    private Rover rover;

    @Test
    public void shouldRoverReportCurrentLocation(){
        Rover rover = new Rover();
        assertEquals("1 3 N", rover.finalLocation());
    }

}