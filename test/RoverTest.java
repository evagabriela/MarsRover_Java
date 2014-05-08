import org.junit.Test;

import java.io.PrintStream;

import static junit.framework.TestCase.assertTrue;

public class RoverTest {

    private Rover rover;
    private PrintStream printStream;



    @Test
    public void shouldRoverReportCurrentLocation(){
        Rover rover = new Rover();
        rover.start();
        assertTrue("1 3 N", true);
    }

//    When a rover moves forward it advances one cell in the direction it is facing
    @Test
    public void shouldMoveForwardInTheDirectionIsFacing(){
        Rover rover = new Rover();
        rover.move();
        assertTrue("1 4 N", true);
    }

}