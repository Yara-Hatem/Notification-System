/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import Server.Notification_Interface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import javax.swing.*;
/**
 *
 * @author user
 */
public class MyClient {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);

            System.out.println("Enter your name:");
            String name = input.nextLine();

            System.out.println("Enter your ID:");
            int id = input.nextInt();
            input.nextLine(); 

            System.out.println("Enter your major:");
            String major = input.nextLine();

            JTextArea notificationArea = new JTextArea();
            

            Subscriber subscriber = new Subscriber(name, id, major, notificationArea);
            

            Registry r = LocateRegistry.getRegistry("localhost", 1099);
            Notification_Interface server = (Notification_Interface) r.lookup("Notification");

           
            server.registerCourse(subscriber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
