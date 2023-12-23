package com.globant.utils;

import java.security.SecureRandom;

public class CredentialsGenerator {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final SecureRandom RANDOM = new SecureRandom();

    private static String generateName(int length) {
        StringBuilder builder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(ALPHABET.length());
            builder.append(ALPHABET.charAt(index));
        }

        return builder.toString();
    }

    public static String generateEmail() {
        String domain = (System.currentTimeMillis() % 2 == 0) ? "gmail.com" : "outlook.com";
        String name = generateName(10);  // Genera un nombre aleatorio de 10 caracteres
        return name + "@" + domain;
    }

    public static String generatePassword() {
        return "p@ssw0rd!";
    }
}