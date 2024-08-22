package com.example.teste;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.teste.dto.ClienteDTO;
import com.example.teste.util.ValidaEmail;

public class ValidaEmailTest {
   private String emailValido = "marcu@gmail.com";
   private String emailInvalido = "marcus.gmail.com";
   private String emailNull = null;

   private ClienteDTO clienteDTO;

   @BeforeEach
   void setUp() {
        clienteDTO = new ClienteDTO();
        clienteDTO.setEmail("marcu@gmail.com");
   }
    @Test
    void confimaEmail() {
        String emailAntigo = "dadadd@gmail.com";

        assertEquals(emailValido, clienteDTO.getEmail(), " Os e-mails devem ser iguais.");

        assertNotEquals(clienteDTO.getEmail(), emailAntigo, " Os e-mails devem ser distintos.");

        assertNull(emailNull);

        assertNotNull(clienteDTO);

        assertAll("Valida e-mail",
        () -> assertEquals(emailValido, clienteDTO.getEmail()),
        () -> assertTrue(ValidaEmail.validarCaracterArroba(emailValido)));
    }

     @Test
     void caracterArroba() {

        assertTrue(ValidaEmail.validarCaracterArroba(emailValido), "O email valido deve conter '@'");
        assertFalse(ValidaEmail.validarCaracterArroba(emailInvalido), "O email invalido não deve conter '@'");
        assertFalse(ValidaEmail.validarCaracterArroba(emailNull), "O email nulo não deve conter '@'");

     }


}