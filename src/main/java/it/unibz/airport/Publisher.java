package it.unibz.airport;

public interface Publisher {
  public void subscribe(Subscriber subscriber);
  public void notifySubscribers();
  
  public String getName();
  public boolean isClear();
}
