import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.verify;
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
    public void shouldReturnTrueIfRoverHasInvalidInstructions()  {
        rover.runInstruction();

        assertTrue(rover.hasError());
    }

    @Test
    public void shouldTurnLeftWhenCommandIsL() {
        Rover rover1 = new Rover(1, 3, "E", "L", plateau);
        rover1.runInstruction();

        assertEquals("1 3 N", rover1.currentPosition());
    }

    @Test
    public void shouldTurnRightWhenCommandIsR() {
        Rover rover2 = new Rover(2, 2, "E", "R", plateau);
        rover2.runInstruction();

        assertEquals("2 2 S", rover2.currentPosition());
    }

    @Test
    public void shouldTurnRightWhenCommandExecuteIsR(){
        rover = new Rover(1, 1, "N", "R", plateau);
        TurnRightCommand turnRight = mock(TurnRightCommand.class);
        rover.getCommandMapper().put("R", turnRight);
        rover.runInstruction();

        verify(turnRight).execute();
    }

    @Test
    public void shouldTurnLeftWhenCommandExecuteIsL(){
        rover = new Rover(1, 1, "N", "L", plateau);
        TurnLeftCommand turnLeft = mock(TurnLeftCommand.class);
        rover.getCommandMapper().put("L", turnLeft);
        rover.runInstruction();

        verify(turnLeft).execute();
    }

    @Test
    public void shouldMoveWhenCommandExecuteIsM(){
        rover = new Rover(1, 1, "N", "M", plateau);
        MoveCommand moveCommand = mock(MoveCommand.class);
        rover.getCommandMapper().put("M", moveCommand);
        rover.runInstruction();

        verify(moveCommand).execute();
    }

//    @Test
//    public void shouldSomething(){
//        rover = new Rover(1, 1, "N", "R", plateau);
//
//        HashMap<String, Command>  myMapper = mock(HashMap.class);
//
//        TurnRightCommand turnRight = mock(TurnRightCommand.class);
//
//        when(myMapper.get("R")).thenReturn(turnRight);
//
//
//        rover.runInstruction();
//
//        verify(turnRight).execute();
//
//    }


}