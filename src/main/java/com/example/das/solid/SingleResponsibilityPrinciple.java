package com.example.das.solid;

public class SingleResponsibilityPrinciple {
    // Class adhering to SRP
    class UserRepository {
        // Responsible only for user-related database operations
        public void saveUser(User user) {
            // Save the user to the database
        }

        public User findUserById(int id) {
            // Find and return the user
            return new User();
        }
    }

    // Class violating SRP
    static class UserManagement {
        public void saveUser(User user) {
            // Save the user to the database
        }

        public void sendUserEmail(User user) {
            // Send an email to the user (violates SRP)
        }
    }

    static class User {
        // User class implementation
    }
}


