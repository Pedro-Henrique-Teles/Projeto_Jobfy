package com.jobfy.validador;

public class CpfValidator {
    public static boolean isValid(String cpf) {
        if (cpf == null || cpf.length() != 11 || cpf.chars().allMatch(x -> x == cpf.charAt(0))) {
            return false;
        }

        String digitos = cpf.substring(0, 9);
        String dvs = cpf.substring(9, 11);

        String dv1 = calcularDV(digitos);
        String dv2 = calcularDV(digitos + dv1);

        return dvs.equals(dv1 + dv2);
    }

    private static String calcularDV(String str) {
        int peso = str.length() + 1;
        int soma = 0;
        for (char c : str.toCharArray()) {
            soma += Character.getNumericValue(c) * peso;
            peso--;
        }
        int dv = 11 - (soma % 11);

        return (dv == 10 || dv == 11) ? "0" : String.valueOf(dv);
    }
}
