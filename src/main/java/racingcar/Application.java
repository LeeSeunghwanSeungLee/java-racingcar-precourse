package racingcar;

import racingcar.controller.PlayController;

public class Application {
    public static void main(String[] args) {
        PlayController pc = new PlayController();
        pc.start();
    }
}
