package org.example;

public class Client {
   public static void main(String[] args) {
        Client client = new Client();
        client.testAssertion(); // Calling the method to trigger assertion
    }

    public void testAssertion() {
        assert false : "Assertion failed";
    }
}
