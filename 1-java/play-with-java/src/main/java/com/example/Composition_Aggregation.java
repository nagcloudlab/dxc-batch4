package com.example;

// Define the Wheel class
class Wheel {
    // Implementation of the Wheel class
}

// Composition - Car owns the Wheel object
class Car {
    private Wheel wheel;

    public Car() {
        wheel = new Wheel();
    }

    // Other methods of the Car class
}

// Aggregation - Car uses the Wheel object but does not own it
class CarShowroom {
    private Wheel wheel;

    public void addCar(Wheel wheel) {
        this.wheel = wheel;
    }

    // Other methods of the CarShowroom class
}

public class Composition_Aggregation {
    public static void main(String[] args) {

        // Composition example
        Car myCar = new Car();

        // Aggregation example
        Wheel wheel = new Wheel();
        CarShowroom showroom = new CarShowroom();
        showroom.addCar(wheel);

    }
}
