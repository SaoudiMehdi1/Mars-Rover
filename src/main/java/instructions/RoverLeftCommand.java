package instructions;

import model.Rover;

public class RoverLeftCommand implements IRoverCommand {

    @Override
    public void execute(Rover rover) {
        rover.setRoverDirection(rover.getRoverDirection().getLeftDirection());
    }
}
