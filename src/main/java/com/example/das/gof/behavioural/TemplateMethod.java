package com.example.das.gof.behavioural;

public class TemplateMethod {
    abstract static class MealPreparation {
        abstract void prepareIngredients();
        abstract void cook();
        abstract void serve();

        // Template method
        final void prepareMeal() {
            prepareIngredients();
            cook();
            serve();
        }
    }

    static class PastaMeal extends MealPreparation {
        void prepareIngredients() { System.out.println("Preparing pasta ingredients."); }
        void cook() { System.out.println("Cooking pasta."); }
        void serve() { System.out.println("Serving pasta."); }
    }

    public static void main(String[] args) {
        MealPreparation meal = new PastaMeal();
        meal.prepareMeal();
    }
}
