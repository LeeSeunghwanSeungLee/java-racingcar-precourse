package racingcar.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Winner {
    private List<Car> roundWinner;

    public Winner(CarRepository carRepository) {
        roundWinner = new ArrayList<>();
        selectWinner(carRepository);
    }

    private void selectWinner(CarRepository carRepository) {
        int maxDistance = carRepository.getMaxDistance();
        Iterator<Car> carIt = carRepository.asIterator();
        while (carIt.hasNext()) {
            Car nowCar = carIt.next();
            checkAddOrNot(maxDistance, nowCar);
        }
    }

    private void checkAddOrNot(Integer maxDistnace, Car car) {
        if (maxDistnace.equals(car.getDistance()))
            roundWinner.add(car);
    }

    public int getSize() {
        return roundWinner.size();
    }
}
