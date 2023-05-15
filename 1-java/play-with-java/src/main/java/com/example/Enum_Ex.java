package com.example;

/*

    group of related constants under One Type ( enum )

    e.g

    HttpMethod
        GET,POST,PUT,DELETE

    Gender
        MALE,FEMALE

    WeekDays
        MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY

    Month
        JANUARY,FEBRUARY,MARCH,APRIL,MAY,JUNE,JULY,AUGUST,SEPTEMBER,OCTOBER,NOVEMBER,DECEMBER

 */

import java.util.concurrent.TimeUnit;

enum Gender{
    MALE,FEMALE
}

class Employee{
    private String name;
    private Gender gender;
    private int age;
    Employee(String name, Gender gender, int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}



public class Enum_Ex {
    public static void main(String[] args) {

        Employee e1 = new Employee("John", Gender.MALE, 20);
        Employee e2 = new Employee("Jane", Gender.FEMALE, 30);
        Employee e3 = new Employee("Mary", Gender.FEMALE, 25);


    }
}
