package Assignment2.Problem5;

/* Nick McCullough - SE416 */

public class NotificationService 
{
    public void notifyUser(NotificationChannelType channelType, String message) 
    {
        // new notification
        Notification notification = NotificationFactory.createNotification(channelType);
        notification.send(message);
    }
}

