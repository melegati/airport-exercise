package it.unibz.airport;

public class AirTrafficControl {

    public String findAvailableRunway(){

        return null;
    }

    public void displayMessage() {

        String availableRunway = findAvailableRunway();
        if(availableRunway == null) {
            System.out.println("AIR TRAFFIC CONTROL: no runways available!");
        }
        else {
            System.out.printf("AIR TRAFFIC CONTROL: next available runway %s%n", availableRunway);
        }
    }

}
