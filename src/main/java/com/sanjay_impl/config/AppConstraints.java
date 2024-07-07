package com.sanjay_impl.config;

public class AppConstraints {

    public enum UserRole {
        ROLE_PASSENGER("USER"),
        ROLE_ADMIN("ADMIN");

        private String role;

        private UserRole(String role) {
            this.role = role;
        }

        public String value() {
            return this.role;
        }
    }
}