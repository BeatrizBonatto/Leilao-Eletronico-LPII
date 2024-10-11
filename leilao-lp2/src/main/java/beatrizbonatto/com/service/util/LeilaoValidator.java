package beatrizbonatto.com.service.util;

import java.util.Date;

public class LeilaoValidator {
    public static void validacaoData(Date data) {
        if (data == null) {
            throw new IllegalArgumentException("Data invalida!");
        }
        if (data.after(new Date())) {
            throw new IllegalArgumentException("Data invalida!");
        }
    }
}
