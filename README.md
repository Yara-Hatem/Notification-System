# 📢 Distributed Notification System (Java RMI)

## Overview

This project implements a distributed **Notification System** using Java RMI (Remote Method Invocation), designed for use in a university environment. It follows a **publish-subscribe** model, where a central server sends **channel-based notifications** to registered student clients based on their **major**.

Both client and server interfaces provide a graphical user interface (GUI) to enhance user experience.

---

## Features

### ✅ Subscriber Registration
- Clients (students) register using name, ID, and major.
- Successful registration is confirmed and logged on the server GUI.

### 📡 Channel-based Messaging
- Server supports the following channels:
  - Algorithms
  - Distributed Systems
  - Student Services
  - Software Engineering
  - Information System
  - Computer Graphics

### 🔍 Message Filtering by Major
- `isAllowedToReceive()` filters messages based on student major:
  - **AI**: Algorithms, Student Services, Distributed Systems
  - **SE**: Algorithms, Student Services, Software Engineering, Computer Graphics
  - **IS**: Algorithms, Student Services, Information System
  - **CS**: Algorithms, Student Services, Distributed Systems, Computer Graphics

---

## System Architecture

### 🖥 Server Side
- `NotificationServer`: Core RMI implementation handling registration and broadcasting.
- `MainServerGUI`: Swing-based GUI for server admin to send notifications and view connections.

### 👤 Client Side
- `MyClient`: CLI-based registration client.
- `SubscribersGui`: GUI-based client for registration and receiving messages.
- `Subscriber`: RMI interface implementation that displays received messages on the client GUI.

### 🔗 Interfaces
- `Notification_Interface`: For server-side registration and broadcasting.
- `Subscriber_Interface`: For server-to-client remote messaging.

---

## Technologies Used

- **Java RMI** – for remote communication
- **Java Swing** – for GUI components
- **Serializable Interfaces** – for object passing over network

---

## How to Run

1. **Start the Server**
   - Run `MainServerGUI.java`.
   - RMI server binds `NotificationServer` to registry as `"Notification"`.

2. **Start a Client**
   - Run `SubscribersGui.java`.
   - Enter student name, ID, and major to register.

3. **Send Notifications**
   - Server admin selects a channel and writes a message in the GUI.
   - Clicks **"Send Notification"**.
   - Message is broadcast only to subscribers whose majors match the channel policy.