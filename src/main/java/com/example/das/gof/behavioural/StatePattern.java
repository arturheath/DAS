package com.example.das.gof.behavioural;

public class StatePattern {
    interface BatteryState {
        void handle(Phone phone);
    }

    static class Phone {
        private BatteryState state;

        void setState(BatteryState state) {
            this.state = state;
        }

        void usePhone() {
            state.handle(this);
        }
    }

    static class UnchargedState implements BatteryState {
        public void handle(Phone phone) {
            System.out.println("Phone is uncharged. Please charge the phone.");
            phone.setState(new LowBatteryState());
        }
    }

    static class LowBatteryState implements BatteryState {
        public void handle(Phone phone) {
            System.out.println("Battery is low. Turning on power-saving mode.");
            phone.setState(new OnState());
        }
    }

    static class OnState implements BatteryState {
        public void handle(Phone phone) {
            System.out.println("Phone is on and operational.");
            // The phone could go to a low battery state or remain in the on state based on usage.
        }
    }

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.setState(new UnchargedState());

        phone.usePhone();  // Outputs: Phone is uncharged. Please charge the phone.
        phone.usePhone();  // Outputs: Battery is low. Turning on power-saving mode.
    }
}
