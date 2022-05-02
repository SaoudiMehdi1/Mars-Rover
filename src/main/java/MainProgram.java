import directiontype.RoverDirection;
import exceptions.DeclareException;
import exceptions.RoverException;
import model.Coordinates;
import model.Rover;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainProgram {
    public static void main(String[] args) throws RoverException {
        //need to get lines from file and store it into a list
        InputStream is = MainProgram.class.getResourceAsStream("/input.txt");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            List<String> commands = new ArrayList<>();
            List<String> finPositions = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    commands.add(line);
                }
            }
            if (!commands.isEmpty()) {
                initPlateau(commands.get(0));
                for (int i = 1, j = 1; i < commands.size(); i += 2, j++) {
                    try {
                        String finalPosition = putRover(commands.get(i), commands.get(i + 1), j);
                        finPositions.add(finalPosition);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Incorrect Rover's position");
                        throw new RoverException(DeclareException.INVALID_INPUT);
                    }
                }
            }
            System.out.println("Output");
            finPositions.forEach(finalPosition -> System.out.println(finalPosition));
        }catch(IOException e){
            throw new RoverException(DeclareException.READING_CURRENT_FILE);
        }
    }

    private static void initPlateau(String initPosition) throws RoverException{
        List<String> plateauCoordinates = Arrays.asList(initPosition.split("\\s+"));
        try{
            Rover.MAX_VALUE_COORDINATES = new Coordinates(Integer.parseInt(plateauCoordinates.get(0)), Integer.parseInt(plateauCoordinates.get(1)));

        }catch(ArrayIndexOutOfBoundsException | NumberFormatException e){
            System.out.println(DeclareException.INVALID_INPUT.getMessage());
            throw new RoverException(DeclareException.CURRENT_ERROR);
        }
    }

    public static String putRover(String initPosition, String Command, int number){
        String finPosition = initPosition;
        List<String> plateauCoordinates = Arrays.asList(initPosition.split("\\s+"));
        try {
            RoverDirection initDirection = RoverDirection.findDirection(plateauCoordinates.get(2));
            Coordinates roverCoordinates = new Coordinates(Integer.parseInt(plateauCoordinates.get(0)), Integer.parseInt(plateauCoordinates.get(1)));
            Rover rover = new Rover(initDirection, roverCoordinates);
            if (rover.getRoverCoordinates().isOnPlateau(rover.MIN_VALUE_COORDINATES, rover.MAX_VALUE_COORDINATES)) {
                rover.exploreRover(Command);
                finPosition = rover.toString();
            }
        }catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Input for Rover" + number);
        }
        return finPosition;
    }
}
