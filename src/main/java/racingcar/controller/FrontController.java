package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.CarRepository;
import racingcar.model.Winner;
import racingcar.resolver.ArgumentResolver;
import racingcar.resolver.IntegerArgumentResolver;
import racingcar.resolver.StringArrayArgumentResolver;
import racingcar.view.View;

import java.util.Iterator;

public class FrontController {
    private PlayController playController;
    private ArgumentResolver<String[]> stringArrayArgumentResolver;
    private ArgumentResolver<Integer> integerArgumentResolver;
    private CarRepository carRepository;

    public FrontController() {
        playController = PlayController.getInstance();
        stringArrayArgumentResolver = StringArrayArgumentResolver.getInstance();
        integerArgumentResolver = IntegerArgumentResolver.getInstance();
        carRepository = CarRepository.getInstance();
    }

    public void start() {
        View.printInputCarNames();
        String[] carNames = getNameInput();

        View.printInputCount();
        Integer roundCount = getRound();

        playController.insertCarInRepository(carNames, carRepository);

        for (int i = 0; i < roundCount; i++) {
            Iterator<Car> carIt = playController.progressRound(carRepository);
            showProgressInScreen(carIt);
        }

        showWinner();
    }

    private String[] getNameInput() {
        try {
            String input = Console.readLine();
            return stringArrayArgumentResolver.convert(input);
        } catch (Exception e) {
            View.printSubtitleln(e.getMessage());
            return getNameInput();
        }
    }

    private Integer getRound() {
        try{
            String count = Console.readLine();
            return integerArgumentResolver.convert(count);
        } catch (IllegalArgumentException e){
            View.printSubtitleln(e.getMessage());
            return getRound();
        }
    }

    private void showProgressInScreen(Iterator<Car> carIt) {
        while (carIt.hasNext()) {
            Car nowCar = carIt.next();
            View.printSubtitleln(nowCar.getName() + " : " + nowCar.getDistanceByString());
        }
        View.printSubtitleln("");
    }

    private void showWinner() {
        Winner winner = playController.findWinner(carRepository);
        View.printWinners(winner.toString());
        carRepository.clear();
    }
}
