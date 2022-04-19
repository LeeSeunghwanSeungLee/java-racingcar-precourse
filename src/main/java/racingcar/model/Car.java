package racingcar.model;

public class Car {
    public static final int MOVEBOUNDARY = 4;
    private int distance = 0;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public void moveOrNot(int number) {
        if (number >= Car.MOVEBOUNDARY)
            distance++;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
