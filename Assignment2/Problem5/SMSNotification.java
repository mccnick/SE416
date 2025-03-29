package Assignment2.Problem5;

/* Nick McCullough - SE416 */

// SMS
public class SMSNotification implements Notification 
{
    @Override
    public void send(String message) 
    {
        System.out.println("SMS: " + message);
        // send SMS etc
    }
}
