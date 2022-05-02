import directiontype.RoverDirection;
import instructions.IRoverCommand;
import instructions.RoverRightCommand;
import model.Coordinates;
import model.Rover;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RoverRightCommandTest {
    private IRoverCommand roverCommand;
    private Coordinates c;

    @Before
    public void initialise(){
        roverCommand = new RoverRightCommand();
        c = new Coordinates(1, 1);
    }

    @Test
    public void testRoverRightCommandToNorth(){
        Rover r =new Rover(RoverDirection.N, c);
        roverCommand.execute(r);
        assertEquals(r.getRoverDirection(), RoverDirection.E);
    }

    @Test
    public void testRoverRightCommandToSouth(){
        Rover r =new Rover(RoverDirection.S, c);
        roverCommand.execute(r);
        assertEquals(r.getRoverDirection(), RoverDirection.W);
    }

    @Test
    public void testRoverRightCommandToEast(){
        Rover r =new Rover(RoverDirection.E, c);
        roverCommand.execute(r);
        assertEquals(r.getRoverDirection(), RoverDirection.S);
    }

    @Test
    public void testRoverRightCommandToWest(){
        Rover r =new Rover(RoverDirection.W, c);
        roverCommand.execute(r);
        assertEquals(r.getRoverDirection(), RoverDirection.N);
    }
}
