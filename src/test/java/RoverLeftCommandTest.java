import directiontype.RoverDirection;
import instructions.IRoverCommand;
import instructions.RoverLeftCommand;
import model.Coordinates;
import model.Rover;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RoverLeftCommandTest {

    private IRoverCommand roverCommand;
    private Coordinates c;

    @Before
    public void initialise(){
        roverCommand = new RoverLeftCommand();
        c = new Coordinates(1, 1);
    }

    @Test
    public void testRoverLeftCommandToNorth(){
            Rover r =new Rover(RoverDirection.N, c);
            roverCommand.execute(r);
            assertEquals(r.getRoverDirection(), RoverDirection.W);
    }

    @Test
    public void testRoverLeftCommandToSouth(){
        Rover r =new Rover(RoverDirection.S, c);
        roverCommand.execute(r);
        assertEquals(r.getRoverDirection(), RoverDirection.E);
    }

    @Test
    public void testRoverLeftCommandToEast(){
        Rover r =new Rover(RoverDirection.E, c);
        roverCommand.execute(r);
        assertEquals(r.getRoverDirection(), RoverDirection.N);
    }

    @Test
    public void testRoverLeftCommandToWest(){
        Rover r =new Rover(RoverDirection.W, c);
        roverCommand.execute(r);
        assertEquals(r.getRoverDirection(), RoverDirection.S);
    }
}
