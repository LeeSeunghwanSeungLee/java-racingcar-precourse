package racingcar.utils;

import java.lang.reflect.Type;
import java.util.List;

public class ArgumentResolver {
    private static ArgumentResolver argumentResolver;

    private ArgumentResolver() {}

    public synchronized ArgumentResolver getInstance() {
        if (argumentResolver == null)
            argumentResolver = new ArgumentResolver();
        return argumentResolver;
    }

    public void validate(String input) {
        // input으로 벨리테이터

        // TypeTransformer를 활용한 분리기

        // 이름 벨리데이터 진행
    }
}
