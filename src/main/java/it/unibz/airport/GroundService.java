package it.unibz.airport;

import java.util.HashMap;

public class GroundService implements Subscriber {

    private HashMap<String, Boolean> runwayStatus;

    public GroundService() {
        this.runwayStatus = new HashMap<String, Boolean>();
    }

    public int getNumberOfAvailableRunways() {
        int numberOfAvailableRunways = this.runwayStatus.entrySet().stream().mapToInt(status -> status.getValue() ? 1 : 0).reduce(0, (left, right) -> left + right);
        return numberOfAvailableRunways;
    }

    public void displayMessage() {
        System.out.printf("GROUND SERVICE: Number of free runways: %d%n", getNumberOfAvailableRunways());
    }

    @Override
    public void update(Publisher runway) {
        this.runwayStatus.put(runway.getName(), runway.isClear());
    }

}
