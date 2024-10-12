package beatrizbonatto.com.service.util;

public class InstFinanceitaValidator {
    public static void validacaoCnpj(String cnpj) {
        if (cnpj.length() != 11) {
            throw new IllegalArgumentException("CNPJ invalido");
        }
    }
}
