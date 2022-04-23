package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.CarRepository;
import racingcar.model.Winner;
import racingcar.resolver.ArgumentResolver;
import racingcar.resolver.IntegerArgumentResolver;
import racingcar.resolver.StringArrayArgumentResolver;
import racingcar.utils.TypeTransformer;
import racingcar.view.View;

import java.util.Iterator;

public class PlayController {
    private CarRepository carRepository;
    private StringArrayArgumentResolver stringArrayArgumentResolver;
    private IntegerArgumentResolver integerArgumentResolver;

    public PlayController() {
        stringArrayArgumentResolver = StringArrayArgumentResolver.getInstance();
        integerArgumentResolver = IntegerArgumentResolver.getInstance();
        carRepository = new CarRepository();
    }

    public void start() {
        View.printInputCarNames();
        getNameInput();

        View.printInputCount();
        int round = countInput();

        for (int i = 0; i < round; i++) {
            carRepository.startRound();

            Iterator<Car> carIt = carRepository.asIterator();
            while (carIt.hasNext()) {
                Car nowCar = carIt.next();
                View.printSubtitleln(nowCar.getName() + " : " + nowCar.getDistanceByString());
            }
            View.printSubtitleln("");
        }


        Winner winner = new Winner(carRepository);
        View.printWinners(winner.toString());
    }

    private void getNameInput() {
        try {
            String carNames = Console.readLine();
            ArgumentResolver<String[]> argumentResolver = stringArrayArgumentResolver;
            String[] cars = argumentResolver.convert(carNames);
            for (String car : cars) {
                carRepository.addCar(new Car(car));
            }

        } catch (IllegalArgumentException e) {
            View.printSubtitleln(e.getMessage());
            getNameInput();
        }
    }

    private int countInput() {
        try{
            String count = Console.readLine();
            ArgumentResolver<Integer> argumentResolver = integerArgumentResolver;
            return argumentResolver.convert(count);
        } catch (IllegalArgumentException e){
            View.printSubtitleln(e.getMessage());
            return countInput();
        }
    }

    public void makeReady(String input) {
        String[] names = TypeTransformer.changeString2Array(input);
        for (String name : names)
            carRepository.addCar(new Car(name));
    }

}
