package com.cognizant.designpatterns;

// Singleton Pattern makes sure only ONE object of a class is ever created.
// Think of it like a country's President - there can only be one at a time.

public class Singleton {

    // This holds the single instance. "final" means it won't change.
    private static final Singleton INSTANCE = new Singleton();

    // Private constructor stops anyone from doing "new Singleton()" outside
    private Singleton() {
        System.out.println("Singleton created!");
    }

    // Everyone calls this method to get the same single object
    public static Singleton getInstance() {
        return INSTANCE;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}


// Lazy Singleton - creates the object only when someone first asks for it
class SingletonLazy {

    private static SingletonLazy instance;

    private SingletonLazy() {
        System.out.println("Lazy Singleton created!");
    }

    // "synchronized" makes this thread-safe (safe when multiple threads run at once)
    public static synchronized SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}


// Bill Pugh Singleton - best practice. Uses a nested helper class.
// The helper class is only loaded when getInstance() is called.
class SingletonBillPugh {

    private SingletonBillPugh() {
        System.out.println("Bill Pugh Singleton created!");
    }

    private static class SingletonHelper {
        private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
    }

    public static SingletonBillPugh getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}


// Main class to test all three singleton types
class SingletonTest {

    public static void main(String[] args) {
        // Both s1 and s2 should point to the same object
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("Are s1 and s2 the same? " + (s1 == s2)); // true

        SingletonLazy sl1 = SingletonLazy.getInstance();
        SingletonLazy sl2 = SingletonLazy.getInstance();
        System.out.println("Are sl1 and sl2 the same? " + (sl1 == sl2)); // true

        SingletonBillPugh sb1 = SingletonBillPugh.getInstance();
        SingletonBillPugh sb2 = SingletonBillPugh.getInstance();
        System.out.println("Are sb1 and sb2 the same? " + (sb1 == sb2)); // true
    }
}
