package Jogo;

import Exceptions.EmbaralhadorException;
import Contratos.Embaralhador;

/**
 * Created by Daniel on 01/04/2017.
 */
public class EmbaralhadorFacil extends Embaralhador {

    @Override
    public String embaralhar(String palavra) throws EmbaralhadorException {

        Validar(palavra);

        int tamanho = palavra.length();
        char[] lista = palavra.toCharArray();
        StringBuilder embaralhado = new StringBuilder(tamanho);

        for (int i = tamanho - 1; i >= 0; i--) {
            embaralhado.append(lista[i]);
        }

        return embaralhado.toString();
    }
}