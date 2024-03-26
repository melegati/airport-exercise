package it.unibz.airport;

public class Runway {
    
    private boolean isClear;
    private String name;

    public Runway(String name){
        this.name = name;
        this.isClear = true;
    }

    public String getName() {
        return name;
    }

    public boolean isClear() {
        return isClear;
    }

    public void setClear(boolean isClear) {
        this.isClear = isClear;
    }

}
