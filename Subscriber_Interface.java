/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Client;


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author user
 */
public interface Subscriber_Interface extends Remote {
    String getName() throws RemoteException;
    int getId() throws RemoteException;
    String getMajor() throws RemoteException;
    void receiveMessage(String msg) throws RemoteException;
}
