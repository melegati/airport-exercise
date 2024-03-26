package it.unibz.airport;

public class GroundService {

    private int numberOfAvailableRunways = 0;

    public int getNumberOfAvailableRunways() {
        return numberOfAvailableRunways;
    }
    
    public void displayMessage() {
        System.out.printf("GROUND SERVICE: Number of free runways: %d%n", getNumberOfAvailableRunways());
    }

}
