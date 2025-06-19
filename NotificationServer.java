package Server;

import Client.Subscriber_Interface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
/**
 *
 * @author user
 */
public class NotificationServer extends UnicastRemoteObject implements Notification_Interface {

    private ArrayList<Subscriber_Interface> subscribers;
    private MainServerGUI gui;

    public NotificationServer(MainServerGUI gui) throws RemoteException {
        this.gui = gui;
        subscribers = new ArrayList<>();
    }

    @Override
    public void registerCourse(Subscriber_Interface subscriber) throws RemoteException {
        subscribers.add(subscriber);
        String info = "Student " + subscriber.getName() + " with ID " + subscriber.getId() + " got connected.";
        System.out.println(info);
        gui.logSubscriber(info);
    }

    @Override
    public void broadcastMessage(String msg, String channel) throws RemoteException {
        for (Subscriber_Interface subscriber : subscribers) {
            String major = subscriber.getMajor();
            if (isAllowedToReceive(major, channel)) {
               subscriber.receiveMessage(msg);

            }
        }
    }

    private boolean isAllowedToReceive(String major, String channel) {
        if (major.equalsIgnoreCase("AI")) {
            return channel.equalsIgnoreCase("Algorithms") || channel.equalsIgnoreCase("StudentServices") || channel.equalsIgnoreCase("Distributed Systems");
        } else if (major.equalsIgnoreCase("SE")) {
            return channel.equalsIgnoreCase("Algorithms") || channel.equalsIgnoreCase("StudentServices") || channel.equalsIgnoreCase("Software Engineering") || channel.equalsIgnoreCase("Computer Graphics");
        } else if (major.equalsIgnoreCase("IS")) {
            return channel.equalsIgnoreCase("Algorithms") || channel.equalsIgnoreCase("StudentServices") || channel.equalsIgnoreCase("Information System");
        } else if (major.equalsIgnoreCase("CS")) {
            return channel.equalsIgnoreCase("Algorithms") || channel.equalsIgnoreCase("StudentServices") || channel.equalsIgnoreCase("Distributed Systems") || channel.equalsIgnoreCase("Computer Graphics");
        }
       return false;
    }
    
}