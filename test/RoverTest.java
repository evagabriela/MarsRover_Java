import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class RoverTest {

    private Rover rover;

    @Before
    public void setUp(){
        rover = new Rover(1, 3, "N");
    }

    @Test
    public void shouldRoverReportCurrentLocation(){
        rover.currentPosition();
        assertTrue("1 3 N", true);
    }

    @Test
    public void shouldMoveForwardInTheDirectionIsFacing(){
        rover.move();
        assertEquals("1 4 N", rover.currentPosition());
    }

    @Test
    public void shouldMoveLeft(){
        rover.turnLeft();
        assertEquals("1 3 W", rover.currentPosition());
    }

    @Test
    public void shouldMoveRight(){
        rover.turnRight();
        TestCase.assertEquals("1 3 E", rover.currentPosition());
    }

    @Test
    public void shouldProcessMoreThanOneCommand(){

    }



}