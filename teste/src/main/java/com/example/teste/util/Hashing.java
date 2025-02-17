package com.example.teste.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Hashing {

    public static String hash(String data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = digest.digest(data.getBytes());
        return Base64.getEncoder().encodeToString(hashedBytes);
    }
    
}
