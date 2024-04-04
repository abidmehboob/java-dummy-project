package org.example;

public class Service {
    public static void main(String[] args) {
        Service service = new Service();
        service.testAssertion(); // Calling the method to trigger assertion
    }

    public void testAssertion() {
        assert false : "Assertion failed";
    }
}
