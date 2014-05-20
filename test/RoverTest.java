import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mock;

public class RoverTest {

    private Rover rover;
    private Plateau plateau;

    @Before
    public void setUp(){
        plateau = mock(Plateau.class);
        rover = new Rover(1, 3, "N", "LMLM",plateau);
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
    public void shouldMoveLeftFourTimes(){
        rover.turnLeft();
        rover.turnLeft();
        rover.turnLeft();
        rover.turnLeft();
        assertEquals("1 3 N",rover.currentPosition());
    }

    @Test
    public void shouldFaceNorthIfTurnLeft(){
        rover = new Rover(1, 3, "E", "LMLM", plateau);
        rover.turnLeft();
        assertEquals("1 3 N",rover.currentPosition());
    }

    @Test
    public void shouldFaceWestIfTurnLeft(){
        rover.turnLeft();
        assertEquals("1 3 W",rover.currentPosition());
    }

    @Test
    public void shouldFaceSouthIfTurnLeft(){
        rover = new Rover(1, 3, "W", "LMLM", plateau);
        rover.turnLeft();
        assertEquals("1 3 S",rover.currentPosition());
    }

    @Test
    public void shouldFaceEastIfTurnLeft(){
        rover = new Rover(1, 3, "S", "LMLM", plateau);
        rover.turnLeft();
        assertEquals("1 3 E",rover.currentPosition());
    }

    @Test
    public void shouldMoveRight(){
        rover.turnRight();
        assertEquals("1 3 E",rover.currentPosition());
    }

    @Test
    public void shouldFaceNorthIfTurnRight(){
        rover = new Rover(1, 3, "E", "LMLM", plateau);
        rover.turnRight();
        assertEquals("1 3 S",rover.currentPosition());
    }

    @Test
    public void shouldFaceWestIfTurnRight(){
        rover.turnRight();
        assertEquals("1 3 E",rover.currentPosition());
    }

    @Test
    public void shouldFaceSouthIfTurnRight(){
        rover = new Rover(1, 3, "W", "LMLM", plateau);
        rover.turnRight();
        assertEquals("1 3 N",rover.currentPosition());
    }

    @Test
    public void shouldFaceEastIfTurnRight(){
        rover = new Rover(1, 3, "S", "LMLM", plateau);
        rover.turnRight();
        assertEquals("1 3 W",rover.currentPosition());
    }

    @Test
    public void shouldMoveRightTwoTimes(){
        rover.turnRight();
        rover.turnRight();
        rover.turnRight();
        rover.turnRight();
        assertEquals("1 3 N",rover.currentPosition());
    }


    @Test
    public void shouldExecuteEachRoverInstruction(){
        rover.runInstruction();
        assertEquals("0 2 S", rover.currentPosition());
    }

//    Need to add interface Command and create a class for each command.
//    Therefore, Needs similar tests as below
//    it test each command execution

//    @Test
//    public void shouldTurnRightWhenCommandIsR(){
//        Rover rover1 = new Rover(0, 0, "N", "R");
//
//        rover1.runInstruction();

//        verify(turnRightCommand).execute();
//    }
}