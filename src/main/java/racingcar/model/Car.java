package racingcar.model;

public class Car {
    private int distance = 0;

    public void go() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }
}
