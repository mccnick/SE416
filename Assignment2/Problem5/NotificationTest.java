package Assignment2.Problem5;

/* Nick McCullough - SE416 */

// test case class
public class NotificationTest 
{
    public static void main(String[] args) 
    {
        // new service to notify user of an EMAIL saying "Hello!"
        NotificationService service = new NotificationService();
        service.notifyUser(NotificationChannelType.EMAIL, "Hello!");
    }
}


