import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

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

    }

    @Test
    public void shouldNotAddRoverIfSpaceIsNotAvailable() {

    }


}