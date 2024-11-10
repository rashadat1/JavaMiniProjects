package observer;
import notification.NotificationService;
import utils.EventType;
public class LowBalanceNotifier implements AccountObserver {
    private final double threshold;
    private final NotificationService notificationService;
    private final String recipient;

    public LowBalanceNotifier(double threshold, NotificationService notificationService, String recipient) {
        this.threshold = threshold;
        this.notificationService = notificationService;
        this.recipient = recipient;
    }
    @Override
    public void update(EventType eventType, String message) {
        if (eventType == EventType.BALANCE_ALERT) {
            this.notificationService.sendNotification(this.recipient, "Low Balance Alert: " + message);
        }
    }
    public void CheckBalance(double balance) {
        if (balance < this.threshold) {
            this.update(EventType.BALANCE_ALERT, "Balance is below the threshold of $" + this.threshold);
        }
    }
}