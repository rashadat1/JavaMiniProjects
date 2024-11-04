package observer;
// interface defining a method - update - to handle notifications
// allows decoupling the BankAccount from specific notification mechanisms
import utils.EventType;

public interface AccountObserver {
    void update(EventType eventType, String message);
}
