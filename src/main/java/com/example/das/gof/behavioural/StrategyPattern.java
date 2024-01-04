package com.example.das.gof.behavioural;

public class StrategyPattern {
    interface TravelStrategy {
        void travelTo(String destination);
    }

    static class CarStrategy implements TravelStrategy {
        public void travelTo(String destination) {
            System.out.println("Traveling to " + destination + " by car.");
        }
    }

    static class BusStrategy implements TravelStrategy {
        public void travelTo(String destination) {
            System.out.println("Traveling to " + destination + " by bus.");
        }
    }

    static class TravelContext {
        private TravelStrategy strategy;

        void setTravelStrategy(TravelStrategy strategy) {
            this.strategy = strategy;
        }

        void executeTravelStrategy(String destination) {
            strategy.travelTo(destination);
        }
    }

    public static void main(String[] args) {
        TravelContext context = new TravelContext();
        context.setTravelStrategy(new CarStrategy());
        context.executeTravelStrategy("Beach");
    }
}
