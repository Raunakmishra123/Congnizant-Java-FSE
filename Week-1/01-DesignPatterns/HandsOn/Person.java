package com.cognizant.designpatterns;

// Builder Pattern - Used when creating an object needs many steps or optional fields.
// Instead of a constructor with 10 parameters, we build it step by step.
// Example: Building a burger - you choose bun, patty, toppings one by one.

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phone;
    private String address;

    // Constructor is private - only PersonBuilder can create a Person
    private Person(PersonBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName  = builder.lastName;
        this.age       = builder.age;
        this.email     = builder.email;
        this.phone     = builder.phone;
        this.address   = builder.address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + firstName + " " + lastName + "'" +
                ", age=" + age +
                ", email='" + email + "'" +
                ", phone='" + phone + "'" +
                ", address='" + address + "'" +
                "}";
    }

    // Builder class - helps us set only the fields we want
    public static class PersonBuilder {

        private String firstName;
        private String lastName;
        private int    age;
        private String email;
        private String phone;
        private String address;

        // First name and last name are required
        public PersonBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName  = lastName;
        }

        // Each method sets one field and returns "this" so we can chain calls
        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder email(String email) {
            this.email = email;
            return this;
        }

        public PersonBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public PersonBuilder address(String address) {
            this.address = address;
            return this;
        }

        // Final step - creates the Person object
        public Person build() {
            return new Person(this);
        }
    }
}

class BuilderTest {

    public static void main(String[] args) {
        // Build a person step by step
        Person person = new Person.PersonBuilder("Raunak", "Mishra")
                .age(21)
                .email("raunak@example.com")
                .phone("9876543210")
                .address("Bangalore, India")
                .build();

        System.out.println(person);
    }
}
