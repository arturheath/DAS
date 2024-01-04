package com.example.das.gof.behavioural;

public class ChainOfResponsibility {
    interface Handler {
        void setNext(Handler next);
        void handleRequest(String request);
    }

    static class CustomerServiceHandler implements Handler {
        private Handler next;

        public void setNext(Handler next) {
            this.next = next;
        }

        public void handleRequest(String request) {
            if ("basic".equals(request)) {
                System.out.println("Handled by Customer Service");
            } else if (next != null) {
                next.handleRequest(request);
            }
        }
    }

    static class ManagerHandler implements Handler {
        private Handler next;

        public void setNext(Handler next) {
            this.next = next;
        }

        public void handleRequest(String request) {
            if ("complex".equals(request)) {
                System.out.println("Handled by Manager");
            } else if (next != null) {
                next.handleRequest(request);
            }
        }
    }

    public static void main(String[] args) {
        Handler customerService = new CustomerServiceHandler();
        Handler manager = new ManagerHandler();
        
        customerService.setNext(manager);

        customerService.handleRequest("basic");
        customerService.handleRequest("complex");
    }
}
