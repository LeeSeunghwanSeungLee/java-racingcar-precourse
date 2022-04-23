package racingcar.utils;

import java.lang.reflect.Type;
import java.util.List;

public class ArgumentResolver {
    private static ArgumentResolver argumentResolver;
    private InputValidator inputValidator = InputValidator.getInstance();

    private ArgumentResolver() {}

    public synchronized static ArgumentResolver getInstance() {
        if (argumentResolver == null)
            argumentResolver = new ArgumentResolver();
        return argumentResolver;
    }

    public String[] converterStringInput(String input) {
        return validate(input);
    }

    private String[] validate(String input) {
        inputValidator.validateEmpty(input);
        inputValidator.validateLeastCandidate(input);
        inputValidator.validateSameName(input);
        String[] cars = TypeTransformer.changeString2Array(input);
        for (String car : cars) {
            inputValidator.validateEmptyName(car);
            inputValidator.validateNameLimit(car);
        }
        return cars;
    }

    public Integer convertNumberInput(String count) {
        inputValidator.validateNumber(count);
        inputValidator.validateNumberRange(count);
        return Integer.parseInt(count);
    }
}
