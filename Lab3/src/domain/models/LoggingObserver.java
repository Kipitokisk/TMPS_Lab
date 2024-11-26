package domain.models;

public class LoggingObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Log: " + message);
    }
}
