package com.example.das.gof.behavioural;

public class MementoPattern {
    static class Game {
        private String state;

        void setState(String state) {
            this.state = state;
        }

        Memento saveState() {
            return new Memento(state);
        }

        void restoreState(Memento memento) {
            this.state = memento.getState();
        }
    }

    static class Memento {
        private final String state;

        Memento(String state) {
            this.state = state;
        }

        String getState() {
            return state;
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.setState("Level 1");
        Memento savedState = game.saveState();

        game.setState("Level 2");
        game.restoreState(savedState); // Back to "Level 1"
    }
}
