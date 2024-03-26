package it.unibz.airport;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AirTrafficControl {
    private List<Runway> runways;

    public AirTrafficControl() {
        this.runways = new ArrayList<>();
    }

    public void subscribeToRunway(Runway runway) {
        this.runways.add(runway);
    }

    public String findAvailableRunway() {
        Optional<Runway> result = this.runways.stream().filter(runway -> runway.isClear()).findFirst();
        if (result.isPresent()) {
            return result.get().getName();
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

}
