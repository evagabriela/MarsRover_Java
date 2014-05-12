import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RoverTest {

    private Rover rover;

    @Before
    public void setUp(){
        rover = new Rover(1, 3, "N");
    }

    @Test
    public void shouldRoverReportCurrentLocation(){
        assertEquals(rover.currentPosition(), "1 3 N");
    }

    @Test
    public void shouldMoveForwardInTheDirectionIsFacing(){
        rover.move();
        assertEquals(rover.currentPosition(), "1 4 N");
    }

    @Test
    public void shouldMoveLeft(){
        rover.turnLeft();
        assertEquals(rover.currentPosition(), "1 3 W");
    }

    @Test
    public void shouldMoveRight(){
        rover.turnRight();
        assertEquals(rover.currentPosition(), "1 3 E");
    }

}