package Jogo;

import Contratos.Embaralhador;
import Exceptions.EmbaralhadorException;

/**
 * Created by Daniel on 01/04/2017.
 */
public class EmbaralhadorMedio extends Embaralhador {

    private final String vogais = "aeiou";

    @Override
    public String embaralhar(String palavra) throws EmbaralhadorException {

        Validar(palavra);

        int tamanho = palavra.length();
        char[] lista = palavra.toCharArray();
        String embaralhada1 = "";
        String embaralhada2 = "";

        for (int i = 0; i < tamanho; i++) {
            if (vogais.contains((lista[i] + "")))
                embaralhada1 += lista[i];
            else
                embaralhada2 += lista[i];
        }

        return embaralhada1 + embaralhada2;
    }
}
