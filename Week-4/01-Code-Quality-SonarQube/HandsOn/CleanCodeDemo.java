package com.cognizant.quality;

// This class demonstrates clean refactoring of CodeSmellDemo:
// 1. Replaced magic numbers with named constants
// 2. Used guard clauses to reduce cognitive complexity (nesting level)
// 3. Descriptive, camelCase naming conventions
// 4. Extracted reusable business rules to avoid duplicate code

public class CleanCodeDemo {

    // Replaced magic numbers with clear constants
    private static final double MINIMUM_AMOUNT_FOR_DISCOUNT = 10.0;
    private static final double BULK_AMOUNT_THRESHOLD = 50.0;

    private static final double VIP_BULK_DISCOUNT_RATE = 0.10;
    private static final double VIP_STANDARD_DISCOUNT_RATE = 0.05;
    private static final double REGULAR_DISCOUNT_RATE = 0.02;

    private static final double BUSINESS_VIP_BULK_RATE = 0.15;
    private static final double BUSINESS_VIP_STANDARD_RATE = 0.08;
    private static final double BUSINESS_REGULAR_RATE = 0.04;

    private static final int ADULT_AGE_THRESHOLD = 18;

    // Refactored method: simplified logic flow using guard clauses
    public double calculateDiscount(double amount, int age, boolean isVip) {
        // Guard clause: no discount for low amounts or minors
        if (amount <= MINIMUM_AMOUNT_FOR_DISCOUNT || age < ADULT_AGE_THRESHOLD) {
            return 0.0;
        }

        if (isVip) {
            return amount * getVipDiscountRate(amount);
        }

        return amount * REGULAR_DISCOUNT_RATE;
    }

    // Helper method to keep main method clean
    private double getVipDiscountRate(double amount) {
        return amount > BULK_AMOUNT_THRESHOLD ? VIP_BULK_DISCOUNT_RATE : VIP_STANDARD_DISCOUNT_RATE;
    }

    // Cleaned up duplicate code method
    public double calculateDiscountForBusiness(double amount, boolean isVip) {
        if (amount <= MINIMUM_AMOUNT_FOR_DISCOUNT) {
            return 0.0;
        }

        if (isVip) {
            return amount * (amount > BULK_AMOUNT_THRESHOLD ? BUSINESS_VIP_BULK_RATE : BUSINESS_VIP_STANDARD_RATE);
        }

        return amount * BUSINESS_REGULAR_RATE;
    }
}
