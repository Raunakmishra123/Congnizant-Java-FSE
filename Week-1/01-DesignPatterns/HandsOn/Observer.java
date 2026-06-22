package com.cognizant.designpatterns;

import java.util.ArrayList;
import java.util.List;

// Observer Pattern - When one object changes, all its "watchers" get notified.
// Real-world example: YouTube channel notifications.
// When a YouTuber uploads, all subscribers get notified automatically.

// Observer = subscriber who wants to be notified
public interface Observer {
    void update(String message);
}

class EmailObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Email Notification sent: " + message);
    }
}

class SMSObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("SMS Notification sent: " + message);
    }
}

class AppPushObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("App Push Notification sent: " + message);
    }
}

// NotificationService = the YouTube channel that sends notifications
class NotificationService {

    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
        System.out.println("New subscriber added!");
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
        System.out.println("Subscriber removed.");
    }

    // Notify all observers when something happens
    public void notifyAll(String message) {
        System.out.println("\nBroadcasting: " + message);
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

class ObserverTest {

    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        Observer email = new EmailObserver();
        Observer sms   = new SMSObserver();
        Observer app   = new AppPushObserver();

        service.subscribe(email);
        service.subscribe(sms);
        service.subscribe(app);

        service.notifyAll("New order placed - Order #1234");

        // Remove SMS observer and send another notification
        service.unsubscribe(sms);
        service.notifyAll("Order #1234 shipped!");
    }
}
