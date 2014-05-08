import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
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
        assertEquals("1 4 N", rover.currentPosition());
    }

    @Test
    public void shouldMoveLeft(){
        Rover rover = new Rover(1, 3, "N");
        rover.turnLeft();
        assertEquals("1 3 W", rover.currentPosition());
    }

    @Test
    public void shouldMoveRight(){
        Rover rover = new Rover(1, 3, "N");
        rover.turnRight();
        TestCase.assertEquals("1 3 E", rover.currentPosition());
    }


}