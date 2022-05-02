package directiontype;

import model.Rover;

public enum RoverDirection {
    N(0, 1),
    E(1, 0),
    S(0, -1),
    W(-1, 0);

    private int xGridStep;
    private int yGridStep;

    RoverDirection(int xGridStep, int yGridStep) {
        this.xGridStep = xGridStep;
        this.yGridStep = yGridStep;
    }

    public RoverDirection getLeftDirection() {
        switch (this) {
            case E:
                return N;
            case W:
                return S;
            case N:
                return W;
            case S:
                return E;
            default:
                throw new RuntimeException("It's impossible to get there");
        }

    }

    public RoverDirection getRightDirection() {
        switch (this) {
            case E:
                return S;
            case W:
                return N;
            case N:
                return E;
            case S:
                return W;
            default:
                throw new RuntimeException("It's impossible to get there");
        }

    }

    public int getxGridStep() {
        return xGridStep;
    }

    public void setxGridStep(int xGridStep) {
        this.xGridStep = xGridStep;
    }

    public int getyGridStep() {
        return yGridStep;
    }

    public void setyGridStep(int yGridStep) {
        this.yGridStep = yGridStep;
    }

    public static RoverDirection findDirection(String str) {
        for (RoverDirection rd : RoverDirection.values()) {
            if (rd.name().equals(str)) {
                return rd;
            }
        }
        return null;
    }
}
