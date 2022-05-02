import directiontype.RoverDirection;
import instructions.IRoverCommand;
import instructions.RoverMoveCommand;
import model.Coordinates;
import model.Rover;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RoverMoveCommandTest {
    private IRoverCommand roverCommand;
    private Coordinates c;

    @Before
    public void initialise(){
        roverCommand = new RoverMoveCommand();
        c = new Coordinates(4, 3);
    }

    @Test
    public void testRoverMoveCommandToNorth(){
        Rover r =new Rover(RoverDirection.N, c);
        r.MAX_VALUE_COORDINATES = new Coordinates(5, 5);
        roverCommand.execute(r);
        Coordinates finalCoordinates = new Coordinates(4, 4);
        assertEquals(r.getRoverDirection(), RoverDirection.N);
        assertEquals(finalCoordinates.getGridX(), r.getRoverCoordinates().getGridX());
        assertEquals(finalCoordinates.getGridY(), r.getRoverCoordinates().getGridY());
    }

    @Test
    public void testRoverMoveCommandToSouth(){
        Rover r =new Rover(RoverDirection.S, c);
        r.MAX_VALUE_COORDINATES = new Coordinates(5, 5);
        roverCommand.execute(r);
        Coordinates finalCoordinates = new Coordinates(4, 2);
        assertEquals(r.getRoverDirection(), RoverDirection.S);
        assertEquals(finalCoordinates.getGridX(), r.getRoverCoordinates().getGridX());
        assertEquals(finalCoordinates.getGridY(), r.getRoverCoordinates().getGridY());

    }

    @Test
    public void testRoverMoveCommandToEst(){
        Rover r =new Rover(RoverDirection.E, c);
        r.MAX_VALUE_COORDINATES = new Coordinates(5, 5);
        roverCommand.execute(r);
        Coordinates finalCoordinates = new Coordinates(5, 3);
        assertEquals(r.getRoverDirection(), RoverDirection.E);
        assertEquals(finalCoordinates.getGridX(), r.getRoverCoordinates().getGridX());
        assertEquals(finalCoordinates.getGridY(), r.getRoverCoordinates().getGridY());
    }

    @Test
    public void testRoverMoveCommandToWest(){
        Rover r =new Rover(RoverDirection.W, c);
        r.MAX_VALUE_COORDINATES = new Coordinates(5, 5);
        roverCommand.execute(r);
        Coordinates finalCoordinates = new Coordinates(3, 3);
        assertEquals(r.getRoverDirection(), RoverDirection.W);
        assertEquals(finalCoordinates.getGridX(), r.getRoverCoordinates().getGridX());
        assertEquals(finalCoordinates.getGridY(), r.getRoverCoordinates().getGridY());
    }


}
