package model;

import directiontype.RoverDirection;
import instructions.IRoverCommand;
import instructions.RoverCommandFactory;

public class Rover {

    private RoverDirection roverDirection;
    private Coordinates roverCoordinates;
    public static final Coordinates MIN_VALUE_COORDINATES = new Coordinates(0, 0);
    public static Coordinates MAX_VALUE_COORDINATES;

    public Rover(RoverDirection roverDirection, Coordinates roverCoordinates) {
        this.roverDirection = roverDirection;
        this.roverCoordinates = roverCoordinates;
    }

    public RoverDirection getRoverDirection() {
        return roverDirection;
    }

    public void setRoverDirection(RoverDirection roverDirection) {
        this.roverDirection = roverDirection;
    }

    public Coordinates getRoverCoordinates() {
        return roverCoordinates;
    }

    public void setRoverCoordinates(Coordinates roverCoordinates) {
        this.roverCoordinates = roverCoordinates;
    }

    public void exploreRover(String command) {
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            IRoverCommand executeCommand = RoverCommandFactory.createRoverCommand(c);
            if (executeCommand != null) {
                executeCommand.execute(this);
            }
        }
    }

    @Override
    public String toString() {
        return
                this.getRoverCoordinates().getGridX() + " " +
                this.getRoverCoordinates().getGridY() + " " +
                 this.getRoverDirection();

    }
}
