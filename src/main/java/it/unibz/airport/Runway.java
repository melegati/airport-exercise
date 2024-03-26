package it.unibz.airport;

import java.util.ArrayList;
import java.util.List;

public class Runway implements Publisher {
    
    private boolean isClear;
    private String name;
    private List<Subscriber> subscribers;

    public Runway(String name){
        this.name = name;
        this.isClear = true;
        this.subscribers = new ArrayList<Subscriber>();
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public boolean isClear() {
        return isClear;
    }

    public void setClear(boolean isClear) {
        this.isClear = isClear;
        this.notifySubscribers();
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
        this.notifySubscribers();
    }

    @Override
    public void notifySubscribers() {
        this.subscribers.forEach(subscriber -> subscriber.update(this));
    }

}
