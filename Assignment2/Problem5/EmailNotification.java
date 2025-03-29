package Assignment2.Problem5;

/* Nick McCullough */

// Email
public class EmailNotification implements Notification 
{
    @Override
    public void send(String message) 
    {
        System.out.println("Email: " + message);
        // send email etc
    }
}
