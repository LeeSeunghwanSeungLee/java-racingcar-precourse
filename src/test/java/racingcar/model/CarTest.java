package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
class CarTest {
    @Test
    @DisplayName("Car 객체 생성 및 전진 테스트")
    void Car객체테스트() {
        Car car = new Car();
        Car car2 = new Car();

        for (int i = 0; i < 10; i++)
            car.go();

        for (int i = 0; i < 3; i++)
            car2.go();

        assertThat(car.getDistance()).isEqualTo(10);
        assertThat(car2.getDistance()).isEqualTo(3);
    }
}