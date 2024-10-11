package beatrizbonatto.com.service.util;

import java.util.Date;

public class ClienteValidator {
    public static void validacaoCPF(Double cpf) {
        if (cpf.toString().length() != 11) {
            throw new IllegalArgumentException("CPF invalido!");
        }
    }

    public static void validacaoDataNascimento(Date dataNascimento) {
        if (dataNascimento == null) {
            throw new IllegalArgumentException("Data de nascimento invalida!");
        }
        if (dataNascimento.after(new Date())) {
            throw new IllegalArgumentException("Data de nascimento invalida!");
        }
    }

    public static void validacaoEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email invalido!");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email invalido!");
        }
        if (!email.contains(".")) {
            throw new IllegalArgumentException("Email invalido!");
        }
    }

    public static void validacaoCelular(String celular) {
        if (celular == null) {
            throw new IllegalArgumentException("Celular invalido!");
        }
        if (celular.length() != 11) {
            throw new IllegalArgumentException("Celular invalido!");
        }
        if (celular.matches("[0-9]{10}")) {
            throw new IllegalArgumentException("Celular invalido!");
        }
    }
}
