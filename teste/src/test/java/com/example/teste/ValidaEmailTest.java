package com.example.teste;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.teste.util.ValidaEmail;

public class ValidaEmailTest {

     @Test
     void caracterArroba() {
        String emailValido = "marcu@gmail.com";
        String emailInvalido = "marcus.gmail.com";
        String emailNull = null;

        assertTrue(ValidaEmail.validarCaracterArroba(emailValido), "O email valido deve conter '@'");
        assertFalse(ValidaEmail.validarCaracterArroba(emailInvalido), "O email invalido não deve conter '@'");
        assertFalse(ValidaEmail.validarCaracterArroba(emailNull), "O email nulo não deve conter '@'");

     }
}