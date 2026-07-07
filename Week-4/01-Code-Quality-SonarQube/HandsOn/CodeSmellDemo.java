package com.cognizant.quality;

import java.util.List;

// This class contains bad code smells that SonarQube would flag:
// 1. Magic numbers
// 2. High cognitive complexity (deeply nested loops/conditions)
// 3. Unused variables and dead code
// 4. Bad naming conventions

public class CodeSmellDemo {

    // Code smell: Unused field (dead code)
    private int unusedField = 100;

    // Code smell: Bad method name (should be camelCase)
    // Code smell: High cognitive complexity (too many nested blocks)
    // Code smell: Magic numbers (10, 18, 50, 0.05, 0.1)
    public double CalculateDiscount(double amt, int age, boolean VIP) {
        double d = 0;
        
        if (amt > 10) {
            if (age >= 18) {
                if (VIP) {
                    if (amt > 50) {
                        d = amt * 0.1; // Magic number
                    } else {
                        d = amt * 0.05; // Magic number
                    }
                } else {
                    d = amt * 0.02; // Magic number
                }
            } else {
                d = 0; // No discount for minors
            }
        } else {
            d = 0;
        }

        return d;
    }

    // Code smell: Duplicate Code (almost identical logic to CalculateDiscount)
    public double CalculateDiscountForBusiness(double amt, boolean VIP) {
        double d = 0;
        if (amt > 10) {
            if (VIP) {
                if (amt > 50) {
                    d = amt * 0.15; // Magic number
                } else {
                    d = amt * 0.08; // Magic number
                }
            } else {
                d = amt * 0.04; // Magic number
            }
        }
        return d;
    }
}
