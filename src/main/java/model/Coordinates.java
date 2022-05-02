package model;

public class Coordinates {
    private int gridX;
    private int gridY;

    public Coordinates(int gridX, int gridY) {
        this.gridX = gridX;
        this.gridY = gridY;
    }

    public int getGridX() {
        return gridX;
    }

    public int getGridY() {
        return gridY;
    }

    public void setGridX(int gridX) {
        this.gridX = gridX;
    }

    public void setGridY(int gridY) {
        this.gridY = gridY;
    }

    public boolean isOnPlateau(Coordinates valueMin, Coordinates valueMax){
        if(gridX <= valueMax.getGridX() && gridY <= valueMax.getGridY()
                && gridX >= valueMin.getGridX() && gridY >= valueMin.getGridY()){
            return true;
        }
        return false;
    }
}
