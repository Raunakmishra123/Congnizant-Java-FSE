package com.cognizant.designpatterns;

// Strategy Pattern - Allows switching between different algorithms at runtime.
// Example: An online store that supports multiple payment methods.
// The checkout process stays the same, but the payment "strategy" can change.

// Strategy interface - defines what a payment method must be able to do
public interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {

    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card ending in " + cardNumber.substring(cardNumber.length() - 4));
    }
}

class PayPalPayment implements PaymentStrategy {

    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " via PayPal account: " + email);
    }
}

class UPIPayment implements PaymentStrategy {

    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " via UPI ID: " + upiId);
    }
}

// PaymentProcessor = the shopping cart that uses whichever strategy is set
class PaymentProcessor {

    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void processPayment(double amount) {
        if (strategy == null) {
            System.out.println("Please select a payment method first!");
            return;
        }
        strategy.pay(amount);
    }
}

class StrategyTest {

    public static void main(String[] args) {
        PaymentProcessor cart = new PaymentProcessor();

        // Customer chooses Credit Card
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        cart.processPayment(999.0);

        // Customer switches to PayPal
        cart.setPaymentStrategy(new PayPalPayment("raunak@paypal.com"));
        cart.processPayment(450.0);

        // Customer switches to UPI
        cart.setPaymentStrategy(new UPIPayment("raunak@upi"));
        cart.processPayment(200.0);
    }
}
