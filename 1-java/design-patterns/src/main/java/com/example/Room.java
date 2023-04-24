package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

interface DoorListener {
    void on();

    void off();
}

class Light implements DoorListener {
    public void on() {
        System.out.println("com.example.Light On");
    }

    public void off() {
        System.out.println("com.example.Light Off");
    }
}

class Fan implements DoorListener {
    public void on() {
        System.out.println("com.example.Fan On");
    }

    public void off() {
        System.out.println("com.example.Fan Off");
    }
}

class AC implements DoorListener {
    public void on() {
        System.out.println("com.example.AC On");
    }

    public void off() {
        System.out.println("com.example.AC Off");
    }
}

class Door {
    private final List<DoorListener> doorListeners = new ArrayList<>();

    public void addListener(DoorListener doorListener) {
        doorListeners.add(doorListener);
    }

    public void removeListener(DoorListener doorListener) {
        doorListeners.remove(doorListener);
    }

    public void open() {
        System.out.println("com.example.Door Opened");
        for (DoorListener doorListener : doorListeners) {
            doorListener.on();
        }
    }

    public void close() {
        System.out.println("com.example.Door Closed");
        for (DoorListener doorListener : doorListeners) {
            doorListener.off();
        }
    }
}


// Ex : Observer/Listener pattern
public class Room {
    public static void main(String[] args) throws InterruptedException {

        Door door = new Door();

        Light light = new Light();
        Fan fan = new Fan();
        AC ac = new AC();

        door.addListener(light);
        door.addListener(fan);
        door.addListener(ac);

        TimeUnit.SECONDS.sleep(3);
        door.open();
        TimeUnit.SECONDS.sleep(3);
        door.close();


    }
}
