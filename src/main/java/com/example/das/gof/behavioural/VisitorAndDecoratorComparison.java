package com.example.das.gof.behavioural;

public class VisitorAndDecoratorComparison {
    // Common interface for TextElement
    interface TextElement {
        void accept(TextElementVisitor visitor);
        void display();
    }

    // implementation of TextElement
    static class BasicTextElement implements TextElement {
        public void accept(TextElementVisitor visitor) {
            visitor.visit(this);
        }
        public void display() {
            System.out.println("Displaying Basic Text Element");
        }
    }

    // Visitor pattern components
    interface TextElementVisitor {
        void visit(TextElement element);
    }

    static class SpellingCheckVisitor implements TextElementVisitor {
        public void visit(TextElement element) {
            System.out.println("Performing spelling check on " + element.getClass().getSimpleName());
        }
    }

    // Decorator pattern components
    static class BoldDecorator implements TextElement {
        private TextElement decoratedTextElement;
        public BoldDecorator(TextElement decoratedTextElement) {
            this.decoratedTextElement = decoratedTextElement;
        }
        public void accept(TextElementVisitor visitor) {
            decoratedTextElement.accept(visitor);
        }
        public void display() {
            decoratedTextElement.display();
            System.out.println("Applying Bold Decoration");
        }
    }

    public static void main(String[] args) {
        TextElement basicTextElement = new BasicTextElement();
        TextElementVisitor visitor = new SpellingCheckVisitor();

        // Using Visitor
        basicTextElement.accept(visitor);

        // Using Decorator
        TextElement boldTextElement = new BoldDecorator(basicTextElement);
        boldTextElement.display();
    }
}
