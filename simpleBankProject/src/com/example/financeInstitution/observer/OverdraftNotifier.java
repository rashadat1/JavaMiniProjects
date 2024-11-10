package observer;
import notification.NotificationService;
import utils.EventType;
public class OverdraftNotifier implements AccountObserver {
    private final NotificationService notificationService;
    private final String recipient;

    public OverdraftNotifier(NotificationService notificationService, String recipient) {
        this.notificationService = notificationService;
        this.recipient = recipient;
    }
    @Override
    public void update(EventType eventType, String message) {
        if (eventType == EventType.OVERDRAFT_EVENT) {
            this.notificationService.sendNotification(this.recipient, "Overdraft alert: " + message);
        }
    }
    
}
