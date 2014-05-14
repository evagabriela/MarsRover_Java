import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class PlateauTest {
    @Test
    public void shouldInitializeRoverInPlateau(){
        ArrayList<String> instructions = new ArrayList<String>(Arrays.asList("L", "M", "L"));
        Rover rover = new Rover(1, 3, "N", instructions);

    }

}