package instructions;

public class RoverCommandFactory {
    
    public static IRoverCommand createRoverCommand(char rc){
        IRoverCommand roverCommandI;
        switch (rc){
            case 'L' : 
                roverCommandI = new RoverLeftCommand();
                break;
            case 'R' :
                roverCommandI =new RoverRightCommand();
                break;
            case 'M' :
                roverCommandI = new RoverMoveCommand();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + rc);
        }

        return roverCommandI;
    }
}
