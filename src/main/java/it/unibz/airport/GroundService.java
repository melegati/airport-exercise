package it.unibz.airport;

import java.util.ArrayList;
import java.util.List;

public class GroundService {

    private List<Runway> runways;

    public GroundService() {
        this.runways = new ArrayList<>();
    }

    public void subscribeToRunway(Runway runway) {
        this.runways.add(runway);
    }

    public int getNumberOfAvailableRunways() {
        int numberOfAvailableRunways = this.runways.stream().mapToInt(runway -> runway.isClear() ? 1 : 0).reduce(0,
                (left, right) -> left + right);
        return numberOfAvailableRunways;
    }

    public void displayMessage() {
        System.out.printf("GROUND SERVICE: Number of free runways: %d%n", getNumberOfAvailableRunways());
    }

}
