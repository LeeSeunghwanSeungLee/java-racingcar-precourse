package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
class CarRepositoryTest {
    private CarRepository carCandidates = new CarRepository();

    @BeforeEach
    void getReadyCarCandidates() {
        carCandidates.clear();
    }

    @Test
    @DisplayName("일급 컬렉션 형태의 경주 참가 차 리스트 생성")
    void 일급컬렉션테스트() {
        int carNum = 10;
        for (int i = 0; i < carNum; i++)
            carCandidates.addCar(new Car("test_" + i));

        assertThat(carCandidates.getSize()).isEqualTo(carNum);
    }

    @Test
    @DisplayName("일급 컬렉션 형태의 경주 참가 차 리스트 생성")
    void 일급컬렉션테스트2() {
        int carNum = 3;
        for (int i = 0; i < carNum; i++)
            carCandidates.addCar(new Car("test_" + i));

        assertThat(carCandidates.getSize()).isEqualTo(carNum);
    }
}