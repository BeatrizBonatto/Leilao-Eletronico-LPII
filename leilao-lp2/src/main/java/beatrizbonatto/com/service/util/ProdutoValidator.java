package beatrizbonatto.com.service.util;

import beatrizbonatto.com.model.Leilao;
import beatrizbonatto.com.model.Produto;

import java.util.Date;

public class ProdutoValidator {
    public static void validacaoLeilao(Leilao leilao){
        if (leilao.getId() == null){
            throw new IllegalArgumentException("Leilão invalido!");
        }
    }

    public static void validacaoData(Date data){
        if (data == null){
            throw new IllegalArgumentException("Data invalida!");
        }
        if (data.before(new Date())){
            throw new IllegalArgumentException("Data invalida!");
        }
    }
}
