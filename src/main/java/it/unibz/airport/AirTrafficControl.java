package it.unibz.airport;

import java.util.HashMap;
import java.util.Optional;
import java.util.Map.Entry;

public class AirTrafficControl implements Subscriber{
    private HashMap<String, Boolean> runwayStatus;

    public AirTrafficControl() {
        this.runwayStatus = new HashMap<String, Boolean>();
    }

    public String findAvailableRunway() {
        Optional<Entry<String, Boolean>> result = this.runwayStatus.entrySet().stream().filter(runwayStatus -> runwayStatus.getValue()).findAny();
        if (result.isPresent()) {
            return result.get().getKey();
        }
        return null;
    }

    public void displayMessage() {

        String availableRunway = findAvailableRunway();
        if (availableRunway == null) {
            System.out.println("AIR TRAFFIC CONTROL: no runways available!");
        } else {
            System.out.printf("AIR TRAFFIC CONTROL: next available runway %s%n", availableRunway);
        }
    }

    @Override
    public void update(Publisher runway) {
        this.runwayStatus.put(runway.getName(), runway.isClear());
    }

}
