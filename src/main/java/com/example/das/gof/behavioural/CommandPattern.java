package com.example.das.gof.behavioural;

public class CommandPattern {
    interface Command {
        void execute();
    }

    static class Chef {
        void prepareMeal(String order) {
            System.out.println("Preparing " + order);
        }
    }

    static class OrderCommand implements Command {
        private Chef chef;
        private String order;

        OrderCommand(Chef chef, String order) {
            this.chef = chef;
            this.order = order;
        }

        public void execute() {
            chef.prepareMeal(order);
        }
    }

    public static void main(String[] args) {
        Chef chef = new Chef();
        Command order = new OrderCommand(chef, "pizza");

        order.execute();
    }
}
