import exceptions.RoverException;
import model.Coordinates;
import model.Rover;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RoverTest {

    @Test
    public void testPutRoverTestOne() {
        String initialPosition = "1 2 N";
        String commands = "LMLMLMLMM";
        Rover.MAX_VALUE_COORDINATES = new Coordinates(5, 5);
        String finalPosition = MainProgram.putRover(initialPosition, commands, 1);
        assertEquals("1 3 N", finalPosition);

    }

    @Test
    public void testPutRoverTestTwo() {
        String initialPosition = "3 3 E";
        String commands = "MMRMMRMRRM";
        Rover.MAX_VALUE_COORDINATES = new Coordinates(5, 5);
        String finalPosition = MainProgram.putRover(initialPosition, commands, 1);
        assertEquals("5 1 E", finalPosition);

    }
}
