import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

public class PlateauTest {

    private Plateau plateau;

    @Before
    public void setUp(){
        plateau = new Plateau(5,5);

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
        Rover rover = mock(Rover.class);
        when(rover.currentPosition()).thenReturn("1 2 N");

        assertEquals(plateau.addRover(rover), true);

    }

    @Test
    public void shouldNotAddRoverIfSpaceIsNotAvailable() {
        Rover rover = mock(Rover.class);
        when(rover.currentPosition()).thenReturn("1 2 N");
        plateau.addRover(rover);

        Rover rover2 = mock(Rover.class);
        when(rover2.currentPosition()).thenReturn("1 2 N");

        assertEquals(plateau.addRover(rover2), false);
    }


}