package com.example.das.gof.creational;

// Client code
public class AbstractFactory {
    private VehicleFactory factory;

    public AbstractFactory(VehicleFactory factory) {
        this.factory = factory;
    }

    void assembleVehicle() {
        Engine engine = factory.getEngine();
        Suspension suspension = factory.getSuspension();
        Interior interior = factory.getInterior();
        // assemble the vehicle using these components
    }

    // Abstract Factory Interface
    interface VehicleFactory {
        Engine getEngine();
        Suspension getSuspension();
        Interior getInterior();
    }

    // Concrete Factories
    class SedanFactory implements VehicleFactory {
        public Engine getEngine() { return new SedanEngine(); }
        public Suspension getSuspension() { return new SedanSuspension(); }
        public Interior getInterior() { return new SedanInterior(); }
    }

    class SUVFactory implements VehicleFactory {
        public Engine getEngine() { return new SUVEngine(); }
        public Suspension getSuspension() { return new SUVSuspension(); }
        public Interior getInterior() { return new SUVInterior(); }
    }

    // Product Interfaces
    interface Engine { /* Engine methods */ }
    interface Suspension { /* Suspension methods */ }
    interface Interior { /* Interior methods */ }

    // Concrete Products
    class SedanEngine implements Engine { /* Implementation */ }
    class SedanSuspension implements Suspension { /* Implementation */ }
    class SedanInterior implements Interior { /* Implementation */ }
// ...similarly for SUV components...
}
