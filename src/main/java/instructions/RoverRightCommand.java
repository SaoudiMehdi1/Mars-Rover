package instructions;

import model.Rover;

public class RoverRightCommand implements IRoverCommand {

    @Override
    public void execute(Rover rover) {
        rover.setRoverDirection(rover.getRoverDirection().getRightDirection());
    }
}
