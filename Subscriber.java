/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import javax.swing.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author user
 */
public class Subscriber extends UnicastRemoteObject implements Subscriber_Interface {
    private String name;
    private int id;
    private String major;
    private JTextArea notificationArea;

    public Subscriber(String name, int id, String major, JTextArea notificationArea) throws RemoteException {
        this.name = name;
        this.id = id;
        this.major = major;
        this.notificationArea = notificationArea;
    }

    @Override
    public void receiveMessage(String msg) throws RemoteException {
        SwingUtilities.invokeLater(() -> notificationArea.append("Notification: " + msg + "\n"));
    }

    @Override
    public String getMajor() throws RemoteException {
        return this.major;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    
    
}
