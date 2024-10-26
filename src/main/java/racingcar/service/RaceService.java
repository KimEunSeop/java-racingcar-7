package racingcar.service;

import java.util.List;
import java.util.Map;

public class RaceService {

    private final CarManager carManager = new CarManager();
    private final Race race = new Race();
    private final WinnerFinder winnerFinder = new WinnerFinder();
    private int attemptCount;
    private List<String> carNames;

    public RaceService(List<String> carNames, int attemptCount) {
         this.attemptCount = attemptCount;
         this.carNames = carNames;
    }

    public void raceStart(){
        carManager.createCars(carNames);
        race.play(attemptCount,carManager.getCarList());
        winnerFinder.findWinner(carManager.getCarList());
    }

    public List<String> getWinners(){
        return winnerFinder.getWinners();
    }

    public List<Map<String, Integer>> getResult() {
        return race.getResult();
    }
}
