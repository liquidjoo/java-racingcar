package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGameWin {

    private final static String SEPARATOR = ",";
    private int time;
    private List<Car> cars;
    private String[] carNames;

    public RacingGameWin(int time, String carNames) {
        this.time = time;
        this.carNames = carNames.split(SEPARATOR);
        this.cars = new ArrayList<>();
    }

    public List<Car> initiateCar() {
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    public void execute() {
        for (int i = 0; i < time; i++) {
            move();
        }
    }

    private int getRandomNumber() {
        return new Random().nextInt(10);
    }

    public int moveCheck() {
        if (getRandomNumber() >= 4) {
            return 1;
        }
        return 0;
    }

    private void move() {
        for (Car car : cars) {
            int position = updatePosition(car.getPosition());
            car.setPosition(position);
        }
        ResultView.printResultView(cars);
    }

    public int updatePosition(int currentPosition) {
        return currentPosition + moveCheck();
    }

    public void winner() {
        int winnerPosition = 0;
        for (Car car : cars) {
            winnerPosition = sortWinner(car, winnerPosition);
        }
        ResultView.winner(cars, winnerPosition);
    }

    private int sortWinner(Car car, int winnerPosition) {
        if (winnerPosition <= car.getPosition()) {
            return winnerPosition = car.getPosition();
        }
        return winnerPosition;
    }
}
