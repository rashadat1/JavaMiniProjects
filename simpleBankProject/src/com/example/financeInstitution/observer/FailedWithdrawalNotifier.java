package observer;
import notification.NotificationService;
import utils.EventType;
public class FailedWithdrawalNotifier implements AccountObserver {
    private final String recipient;
    private final NotificationService notificationService;

    public FailedWithdrawalNotifier(String recipient, NotificationService notificationService) {
        this.recipient = recipient;
        this.notificationService = notificationService;
    }
    @Override
    public void update(EventType eventType, String message) {
        if (eventType == EventType.FAILED_WITHDRAWAL_EVENT) {
            this.notificationService.sendNotification(this.recipient, "Failed Withdrawal Alert: " + message);
        }
    }
}
