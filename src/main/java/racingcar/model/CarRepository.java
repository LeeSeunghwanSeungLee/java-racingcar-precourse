package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private List<Car> cars;

    public CarRepository() {
        this.cars = new ArrayList<>();
    }

    public CarRepository(List<Car> carCandidate) {
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
