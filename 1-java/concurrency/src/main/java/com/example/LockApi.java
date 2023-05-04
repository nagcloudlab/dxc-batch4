package com.example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Office {
    private ReentrantLock reentrantLock=new ReentrantLock();
    public void room1() {
        try {
            reentrantLock.tryLock(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String tName = Thread.currentThread().getName();
        System.out.println(tName + " entering in room-1");
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(tName + " exiting in room-1");
        reentrantLock.unlock();
    }
    public void room2() {
        String tName = Thread.currentThread().getName();
        System.out.println(tName + " entering in room-2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(tName + " exiting in room-2");
    }
}


public class LockApi {
    public static void main(String[] args) {

        Office office = new Office();
        Thread t1 = new Thread(office::room1,"T1");
        Thread t2 = new Thread(office::room1,"T2");
        t1.start();
        t2.start();

    }
}
