import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

public class PlateauTest {

    private Plateau plateau;
    private Rover rover;

    @Before
    public void setUp(){
        plateau = new Plateau(5,5);
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
    public void shouldTellEachRoverToRunItsInstructions(){
         plateau.addRover(rover);
         plateau.runRoverInstructions();
         verify(rover).runInstruction();
     }

     @Test
    public void shouldTellEachRoverToRunItsFinalPosition(){
         when(rover.currentPosition()).thenReturn("");
         plateau.addRover(rover);
         plateau.showRoverFinalPositions();

         verify(rover).currentPosition();

     }
}