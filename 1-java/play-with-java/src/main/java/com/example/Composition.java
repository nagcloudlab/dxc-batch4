package com.example;

class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;

    // Constructor
    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // Getters and setters
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}

class Person{
    private String name;
    private int age;
    private Address address;
    // Constructor
    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

public class Composition {
    public static void main(String[] args) {

        // Create a new Address object
        Address address = new Address("123 Main St", "Anytown", "CA", "12345");

        // Create a new Person object using the Address object
        Person person = new Person("John Doe", 30, address);

        // Access the name, age, and address of the Person object
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Address: " + person.getAddress().getStreet() + ", " +
                person.getAddress().getCity() + ", " +
                person.getAddress().getState() + " " +
                person.getAddress().getZipCode());

    }
}
