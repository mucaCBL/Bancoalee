package com.controle.notebooks.Service;

public class NumberCleaner {

    public static String cleanNumber(String num) {
        // Remove caracteres, apenas os dígitos serão mantidos
        return num.replaceAll("[^0-9]", "");
    }
}
