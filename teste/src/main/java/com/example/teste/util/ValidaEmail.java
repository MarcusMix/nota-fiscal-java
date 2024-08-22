package com.example.teste.util;

public class ValidaEmail {
    
    public static boolean validarCaracterArroba(String input) {
        return input != null && input.contains("@");
    }

    public boolean isValid(String email) {
        if (email == null) {
            return false;
        }

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }
}
