package com.example.das.gof.structural;

public class Flyweight {
    // Intrinsic state class
    static class BookText {
        String text;

        BookText(String text) {
            this.text = text;
        }
    }

    // Flyweight class
    static class Book {
        private BookText bookText;
        private String borrower;

        Book(BookText text) {
            this.bookText = text;
        }

        void setBorrower(String borrower) {
            this.borrower = borrower;
        }

        void display() {
            System.out.println("Book with Text: " + bookText.text + ", Borrowed by: " + borrower);
        }
    }

    public static void main(String[] args) {
        BookText sharedText = new BookText("Shared Book Text");
        Book book1 = new Book(sharedText);
        Book book2 = new Book(sharedText);

        book1.setBorrower("Alice");
        book2.setBorrower("Bob");

        book1.display();
        book2.display();
    }
}
