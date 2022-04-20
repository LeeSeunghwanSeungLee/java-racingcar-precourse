package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarCandidates {
    private List<Car> cars;

    public CarCandidates() {
        this.cars = new ArrayList<>();
    }

    public CarCandidates(List<Car> carCandidate) {
        cars = carCandidate;
    }

    public void addCar(Car newCar) {
        cars.add(newCar);
    }

    public int getSize() {
        return cars.size();
    }

    public void clear() {
        cars.clear();
    }
}
