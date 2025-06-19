/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Server;

import Client.Subscriber_Interface;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author user
 */
public interface Notification_Interface extends Remote{
    
    void registerCourse(Subscriber_Interface subscriber) throws RemoteException;
void broadcastMessage(String msg, String channel) throws RemoteException;

}

