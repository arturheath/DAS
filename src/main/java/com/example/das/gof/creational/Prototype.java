package com.example.das.gof.creational;

public class Prototype {
    // Nested Prototype class
    static class Cookie implements Cloneable {
        private String shape;

        public Cookie(String shape) {
            this.shape = shape;
        }

        public Cookie clone() throws CloneNotSupportedException {
            return (Cookie) super.clone();
        }

        public String getShape() {
            return shape;
        }
    }

    // Nested CookieMachine class
    static class CookieMachine {
        private Cookie cookie;

        public CookieMachine(Cookie cookie) {
            this.cookie = cookie;
        }

        public Cookie makeCookie() throws CloneNotSupportedException {
            return cookie.clone();
        }
    }

    public static void main(String[] args) {
        Cookie cookiePrototype = new Cookie("Star");

        CookieMachine machine = new CookieMachine(cookiePrototype);

        try {
            Cookie clonedCookie1 = machine.makeCookie();
            Cookie clonedCookie2 = machine.makeCookie();

            System.out.println("Cloned Cookie 1 Shape: " + clonedCookie1.getShape());
            System.out.println("Cloned Cookie 2 Shape: " + clonedCookie2.getShape());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
