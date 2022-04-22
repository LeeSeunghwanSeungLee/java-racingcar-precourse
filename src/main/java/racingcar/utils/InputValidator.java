package racingcar.utils;

import org.junit.jupiter.params.ParameterizedTest;
import racingcar.config.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private static InputValidator inputHandler;
    private static int MAX_LENGTH = 5;
    private static int EMPTY_LENGTH = 0;

    private InputValidator() {} // 싱글톤 구현

    public synchronized static InputValidator getInstance() {
        if (inputHandler == null)
            inputHandler = new InputValidator();
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
        if (name.length() <= EMPTY_LENGTH)
            throw new IllegalArgumentException(ErrorMessage.EmptyName.toString());
    }

    public void validateNameLimit(String name) {
        if (name.length() > MAX_LENGTH)
            throw new IllegalArgumentException(ErrorMessage.ExceedCount.toString());
    }

    public void validateNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NotNumber.toString());
        }
    }

    public void validateNumberRange(String number) {
        try {
            int num = Integer.parseInt(number);
            validateNotPlus(num);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.ExceedNumber.toString());
        }
    }

    private void validateNotPlus(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.ExceedNumber.toString());
        }
    }
}
