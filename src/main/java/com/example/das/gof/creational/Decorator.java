package com.example.das.gof.creational;

public class Decorator {
    interface Drink {
        String getDescription();
        double cost();
    }

    static class Coffee implements Drink {
        public String getDescription() {
            return "Coffee";
        }
        public double cost() {
            return 1.00;
        }
    }

    static class DrinkDecorator implements Drink {
        protected Drink decoratedDrink;

        public DrinkDecorator(Drink decoratedDrink) {
            this.decoratedDrink = decoratedDrink;
        }

        public String getDescription() {
            return decoratedDrink.getDescription();
        }

        public double cost() {
            return decoratedDrink.cost();
        }
    }

    static class MilkDecorator extends DrinkDecorator {
        public MilkDecorator(Drink decoratedDrink) {
            super(decoratedDrink);
        }

        public String getDescription() {
            return super.getDescription() + ", with Milk";
        }

        public double cost() {
            return super.cost() + 0.20;
        }
    }

    static class SyrupDecorator extends DrinkDecorator {
        public SyrupDecorator(Drink decoratedDrink) {
            super(decoratedDrink);
        }

        public String getDescription() {
            return super.getDescription() + ", with Syrup";
        }

        public double cost() {
            return super.cost() + 0.15;
        }
    }

    public static void main(String[] args) {
        Drink myDrink = new Coffee();
        myDrink = new MilkDecorator(myDrink);
        myDrink = new SyrupDecorator(myDrink);

        System.out.println(myDrink.getDescription() + " - $" + myDrink.cost());
    }
}
