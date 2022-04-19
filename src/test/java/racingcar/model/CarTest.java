package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
class CarTest {
    @Test
    @DisplayName("Car 객체 생성 및 전진 테스트")
    void Car객체테스트() {
        String name_1 = "name_1";
        String name_2 = "name_2";

        Car car = new Car(name_1);
        Car car2 = new Car(name_2);

        for (int i = 0; i < 10; i++)
            car.go();

        for (int i = 0; i < 3; i++)
            car2.go();

        assertThat(car.getDistance()).isEqualTo(10);
        assertThat(car.getName()).isEqualTo("name_1");
        assertThat(car2.getDistance()).isEqualTo(3);
        assertThat(car2.getName()).isEqualTo("name_2");
    }

    @ValueSource(strings = {"name_1", "name_2"})
    @ParameterizedTest
    @DisplayName("차에 이름을 부여하는 기능 테스트")
    void 차이름(String name) {
        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
    }
}