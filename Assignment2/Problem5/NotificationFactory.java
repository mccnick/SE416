package Assignment2.Problem5;

/* Nick McCullough - SE416 */

// Factory
public class NotificationFactory 
{
    public static Notification createNotification(NotificationChannelType channelType) 
    {
        switch (channelType) 
        {
            case EMAIL:
                return new EmailNotification();
            case SMS:
                return new SMSNotification();
            case PUSH:
                return new PushNotification();
            
            // error handling
            default:
                throw new IllegalArgumentException("Unknown channel type: " + channelType);
        }
    }
}

