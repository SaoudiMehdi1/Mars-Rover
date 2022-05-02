package instructions;

import model.Rover;

public interface IRoverCommand {
    void execute(Rover rover);
}
