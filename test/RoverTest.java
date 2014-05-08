import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RoverTest {

    private Rover rover;

    @Test
    public void shouldRoverReportCurrentLocation(){
        Rover rover = new Rover();
        assertEquals("1 3 N", rover.finalLocation());
    }

//    When a rover moves forward it advances one cell in the direction it is facing
    @Test
    public void shouldMoveForwardInTheDirectionIsFacing(){
        Rover rover = new Rover();
        rover.move();
        assertEquals("1 4 N", rover.finalLocation());
    }

}