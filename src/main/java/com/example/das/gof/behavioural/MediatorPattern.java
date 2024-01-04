package com.example.das.gof.behavioural;

public class MediatorPattern {
    interface Mediator {
        void sendMessage(String message, Colleague colleague);
    }

    static abstract class Colleague {
        Mediator mediator;
        public Colleague(Mediator m) { this.mediator = m; }
        abstract void send(String message);
        abstract void receive(String message);
    }

    static class ConcreteColleague1 extends Colleague {
        public ConcreteColleague1(Mediator m) { super(m); }
        void send(String message) { mediator.sendMessage(message, this); }
        void receive(String message) { System.out.println("Colleague1 received: " + message); }
    }

    static class ConcreteColleague2 extends Colleague {
        public ConcreteColleague2(Mediator m) { super(m); }
        void send(String message) { mediator.sendMessage(message, this); }
        void receive(String message) { System.out.println("Colleague2 received: " + message); }
    }

    static class ConcreteMediator implements Mediator {
        private ConcreteColleague1 colleague1;
        private ConcreteColleague2 colleague2;
        void setColleague1(ConcreteColleague1 c) { this.colleague1 = c; }
        void setColleague2(ConcreteColleague2 c) { this.colleague2 = c; }
        public void sendMessage(String message, Colleague colleague) {
            if (colleague == colleague1) { colleague2.receive(message); }
            else { colleague1.receive(message); }
        }
    }

    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleague1 colleague1 = new ConcreteColleague1(mediator);
        ConcreteColleague2 colleague2 = new ConcreteColleague2(mediator);
        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        colleague1.send("Hello");
        colleague2.send("Hi there");
    }
}
