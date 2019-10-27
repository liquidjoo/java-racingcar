package study.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.RacingGame;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }

    @Test
    void initiateCarObjectTest() {
        int[] cars = racingGame.carPositionsInitiate(3);
        assertThat(cars).contains(0);
        assertThat(cars).hasSize(3);
    }

    @Test
    void RandomCountTest() {
        assertThat(racingGame.getRandomNumber()).isBetween(0, 9);
    }

    @Test
    void moveCarTest() {
        assertThat(racingGame.setTime(4)).isEqualTo(4);
        assertThat(racingGame.carPositionsInitiate(5)).hasSize(5);
    }

    @Test
    void resultViewTest() {
        assertThat(racingGame.setTime(5)).isEqualTo(5);
        assertThat(racingGame.carPositionsInitiate(3)).hasSize(3);
        racingGame.execute();
        racingGame.print();
    }
}
