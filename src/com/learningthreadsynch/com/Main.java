package com.learningthreadsynch.com;

import javax.sql.rowset.FilteredRowSet;

public class Main {
    public static void main(String[] args) {
        First first = new First();
        Second one = new Second(first, "welcome");
        Second two = new Second(first, "new");
        Second three = new Second(first, "programmer");


    }
}

class First {
    synchronized void display(String msg) { // Only one thread can execute at a time.
        System.out.print(" [ " + msg);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(" ] ");
    }

}

class Second extends Thread {
    String msg;
    First fobj;
    Second (First fb, String str) {
        fobj = fb;
        msg = str;
        start();
    }
    public void run() {
        fobj.display(msg);
    }

}

/*
synchronized(fobj) { this synchronization is implemented in Java with a concept called monitors
    fobj.display(msg)
}

without key word 'synchronized' in display method
 */