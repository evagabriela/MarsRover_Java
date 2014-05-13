import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlateauTest {
    @Test
    public void shouldAddRoverToPlateau(){
        Rover rover1 = mock(Rover.class);
        when(rover1.currentPosition()).thenReturn("1 3 N");

//        Plateau plateau = new Plateau();
//        plateau.add(rover1);
//
//        assertEquals(plateau.roverInPlateau(), "1 3 N");
    }
}