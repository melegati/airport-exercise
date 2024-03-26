package it.unibz.airport;

import java.util.ArrayList;
import java.util.List;


public class App {

    public static void main(String[] args) {
        System.out.println("Welcome to the Airport System!\n");

        AirTrafficControl trafficControl = new AirTrafficControl();
        GroundService groundService = new GroundService();
        List<Runway> runways = createRunways(trafficControl, groundService);

        startRunways(runways);

        groundService.displayMessage();
        trafficControl.displayMessage();
        System.out.println("\n");

        for (int i = 0; i < 10; i++) {
            performRandomRunwayEvent(runways);
            groundService.displayMessage();
            trafficControl.displayMessage();
            System.out.println();
        }

    }

    private static List<Runway> createRunways(AirTrafficControl trafficControl, GroundService groundService) {
        List<Runway> runways = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            Runway runway = new Runway("Runway " + i);
            runways.add(runway);
            trafficControl.subscribeToRunway(runway);
            groundService.subscribeToRunway(runway);
        }
        return runways;
    }

    private static void startRunways(List<Runway> runways) {
        for (Runway runway : runways) {
            runway.setClear(true);
        }
    }

    public static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min));
    }

    private static void performRandomRunwayEvent(List<Runway> runways) {
        int changingRunwayIndex = getRandomNumber(0, 2);
        Runway runway = runways.get(changingRunwayIndex);
        System.out.println("Changing " + runway.getName());
        runway.setClear(!runway.isClear());
    }

}
