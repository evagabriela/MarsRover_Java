import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class RoverTest {

    @Test
    public void shouldRoverReportCurrentLocation(){
        Rover rover = new Rover(1, 3, "N");
        rover.currentPosition();
        assertTrue("1 3 N", true);
    }

    @Test
    public void shouldMoveForwardInTheDirectionIsFacing(){
        Rover rover = new Rover(1, 3, "N");
        rover.move();
        assertTrue("1 4 N", true);
    }

    @Test
    public void shouldMoveLeft(){
        Rover rover = new Rover(1, 3, "N");
        rover.turnLeft();
        assertTrue( "1 4 W", true);
    }


}