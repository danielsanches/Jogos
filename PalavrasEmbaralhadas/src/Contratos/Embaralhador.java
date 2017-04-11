package Contratos;

import Exceptions.EmbaralhadorException;

/**
 * Created by Daniel on 01/04/2017.
 */
public abstract class Embaralhador {
    private final String numeros = "0123456789";

    private boolean ehVazio(String palavra) {
        return palavra == "" || palavra == null;
    }

    private boolean temNumero(String palavra) {
        char[] lista = palavra.toCharArray();
        for (char p : lista) {
            if (numeros.contains(p + ""))
                return true;
        }

        return false;
    }

    public abstract String embaralhar(String palavra) throws EmbaralhadorException;

    protected void  Validar(String palavra) throws EmbaralhadorException {
        if (ehVazio(palavra))
            throw new EmbaralhadorException("Favor informar uma palavra.");

        if (temNumero(palavra))
            throw new EmbaralhadorException("Favor informar somente letras.");
    }
}
