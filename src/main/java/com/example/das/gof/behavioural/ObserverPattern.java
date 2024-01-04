package com.example.das.gof.behavioural;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    interface Subscriber {
        void update(String post);
    }

    static class Blogger {
        private List<Subscriber> subscribers = new ArrayList<>();

        void addSubscriber(Subscriber subscriber) {
            subscribers.add(subscriber);
        }

        void postUpdate(String post) {
            for (Subscriber subscriber : subscribers) {
                subscriber.update(post);
            }
        }
    }

    static class InstagramSubscriber implements Subscriber {
        public void update(String post) {
            System.out.println("New Instagram post: " + post);
        }
    }

    public static void main(String[] args) {
        Blogger blogger = new Blogger();
        Subscriber follower1 = new InstagramSubscriber();
        Subscriber follower2 = new InstagramSubscriber();

        blogger.addSubscriber(follower1);
        blogger.addSubscriber(follower2);

        blogger.postUpdate("Exploring the Observer pattern in Java");
    }
}
