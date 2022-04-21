package racingcar.utils;

import racingcar.config.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class InputHandler {
    private static InputHandler inputHandler;

    private InputHandler() {} // 싱글톤 구현

    public synchronized static InputHandler getInstance() {
        if (inputHandler == null)
            inputHandler = new InputHandler();
        return inputHandler;
    }

    public void validateEmpty(String input) {
        if (input.length() <= 0)
            throw new IllegalArgumentException(ErrorMessage.EmptyValue.toString());
    }


    public void validateLeastCandidate(String input) {
        if (input.split(",").length <= 1)
            throw new IllegalArgumentException(ErrorMessage.LeastCandidate.toString());
    }

    public void validateSameName(String input) {
        String[] users = input.split(",");
        List<String> userList = Arrays.asList(users);
        for (int i = 0; i < users.length; i++)
            doubleCheck(users[i], userList);
    }

    private void doubleCheck(String user, List<String> userList) {
        if (userList.contains(user))
            throw new IllegalArgumentException(ErrorMessage.SameName.toString());
    }

    public void validateEmptyName(String name) {

    }

    public void validateNameLimit(String name) {

    }

    public void validateNotNumber(String number) {

    }

}
