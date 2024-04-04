package org.example;

public class Alpha {
   public static void main(String[] args) {
        Alpha alpha = new Alpha();
        alpha.testAssertion(); // Calling the method to trigger assertion
    }

    public void testAssertion() {
        assert false : "Assertion failed";
    }

}
