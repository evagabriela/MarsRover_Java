import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

public class PlateauTest {

    private Plateau plateau;
    private Rover rover;
    private PrintStream out;

    @Before
    public void setUp(){
        out = Mockito.mock(PrintStream.class);
        plateau = new Plateau(5,5, out);
        rover = mock(Rover.class);
    }

    @Test
    public void shouldReturnTrueIfSpaceValid(){
        assertTrue(plateau.isSpaceValid(3, 2));
    }

    @Test
    public void shouldReturnFalseIFSpaceIsOutsideOfBoundaries(){
       assertFalse(plateau.isSpaceValid(7, 9));
    }

    @Test
    public void shouldRoverMoveForwardInTheDirectionIsFacing()  {
        rover = new Rover(2, 3, "N", "M",plateau);
        plateau.addRover(rover);

        plateau.runRoverInstructions();
        plateau.showRoverFinalPositions();

        verify(out).println("Rover final position: 2 4 N" + "\n");
    }

    @Test
    public void shouldReturnFalseIFSpaceIsNegative(){
        assertFalse(plateau.isSpaceValid(-2, 9));
    }

    @Test
    public void shouldAddRoverIfSpaceIsAvailable(){
        when(rover.currentPosition()).thenReturn("1 2 N");

        assertEquals(plateau.addRover(rover), true);
    }

    @Test
    public void shouldNotAddRoverIfSpaceIsNotAvailable() {
        when(rover.currentPosition()).thenReturn("1 2 N");
        plateau.addRover(rover);

        Rover rover2 = mock(Rover.class);
        when(rover2.currentPosition()).thenReturn("1 2 N");

        assertEquals(plateau.addRover(rover2), false);
    }

     @Test
    public void shouldTellEachRoverToRunItsInstructions() {
         plateau.addRover(rover);
         plateau.runRoverInstructions();
         verify(rover).runInstruction();
     }

     @Test
    public void shouldTellEachRoverToRunItsFinalPosition(){
         plateau.addRover(rover);
         plateau.showRoverFinalPositions();

         verify(rover).currentPosition();
     }

    @Test
    public void shouldReturnMessageForInvalidRoverInstructions(){
        when(rover.getError()).thenReturn(true);
        plateau.addRover(rover);

        plateau.showRoverFinalPositions();

        verify(out).println("Rover final position: This rover has invalid instructions" + "\n");
    }

}