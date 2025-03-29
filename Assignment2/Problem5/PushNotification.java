package Assignment2.Problem5;

/* Nick McCullough - SE416 */

// push
public class PushNotification implements Notification 
{
    @Override
    public void send(String message) 
    {
        System.out.println("Push: " + message);
        // send push etc
    }
}