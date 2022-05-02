package instructions;

import model.Coordinates;
import model.Rover;

public class RoverMoveCommand implements IRoverCommand {

    @Override
    public void execute(Rover rover) {
        Coordinates mCoordinates = new Coordinates(rover.getRoverCoordinates().getGridX() + rover.getRoverDirection().getxGridStep(),
                rover.getRoverCoordinates().getGridY() + rover.getRoverDirection().getyGridStep());
        if(mCoordinates.isOnPlateau(rover.MIN_VALUE_COORDINATES, rover.MAX_VALUE_COORDINATES)) {
            rover.setRoverCoordinates(mCoordinates);
        }
    }
}
