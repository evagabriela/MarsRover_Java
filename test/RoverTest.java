import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RoverTest {

    private Rover rover;

    @Before
    public void setUp(){
        rover = new Rover(1, 3, "N", "LMLM");
    }

    @Test
    public void shouldRoverReportCurrentLocation(){
        assertEquals("1 3 N",rover.currentPosition());
    }

    @Test
    public void shouldMoveForwardInTheDirectionIsFacing(){
        rover.move();
        assertEquals("1 4 N",rover.currentPosition());
    }

    @Test
    public void shouldMoveLeft(){
        rover.turnLeft();
        assertEquals("1 3 W",rover.currentPosition());
    }

    @Test
    public void shouldMoveRight(){
        rover.turnRight();
        assertEquals("1 3 E",rover.currentPosition());
    }

    @Test
    public void shouldProcessMoreThanOneCommand(){
        rover.move();
        rover.turnLeft();
        rover.move();
        assertEquals("0 4 W", rover.currentPosition());
    }

    @Test
    public void shouldExecuteEachRoverInstruction(){
        rover.runInstruction();
        assertEquals("0 2 S", rover.currentPosition());

    }
}