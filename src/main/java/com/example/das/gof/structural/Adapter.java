package com.example.das.gof.structural;

public class Adapter {
    // Common interface
    interface EuropeanSocket {
        void provideElectricity();
    }

    // Adaptee class
    static class AmericanSocket {
        void providePower() {
            System.out.println("Providing electricity from American socket.");
        }
    }

    // Class Adapter: uses inheritance
    static class ClassAdapter extends AmericanSocket implements EuropeanSocket {
        public void provideElectricity() {
            providePower(); // Calling method from AmericanSocket
        }
    }

    // Object Adapter: uses composition
    static class ObjectAdapter implements EuropeanSocket {
        private AmericanSocket americanSocket;

        public ObjectAdapter(AmericanSocket socket) {
            this.americanSocket = socket;
        }

        public void provideElectricity() {
            americanSocket.providePower(); // Delegating call to the AmericanSocket instance
        }
    }

    public static void main(String[] args) {
        // Using Class Adapter
        EuropeanSocket classAdapter = new ClassAdapter();
        classAdapter.provideElectricity();

        // Using Object Adapter
        AmericanSocket americanSocket = new AmericanSocket();
        EuropeanSocket objectAdapter = new ObjectAdapter(americanSocket);
        objectAdapter.provideElectricity();
    }
}
