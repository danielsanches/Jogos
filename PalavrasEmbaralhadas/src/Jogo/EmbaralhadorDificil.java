package Jogo;

import Exceptions.EmbaralhadorException;
import Contratos.Embaralhador;
import com.sun.javafx.scene.layout.region.Margins;
import sun.plugin.javascript.navig.Array;

/**
 * Created by Daniel on 01/04/2017.
 */
public class EmbaralhadorDificil extends Embaralhador {

    private final String consonanticos = "bcdfgptv";
    private final String semivogais = "iu";
    private final String vogais = "aeo";

    @Override
    public String embaralhar(String palavra) throws EmbaralhadorException {

        Validar(palavra);

        int tamanho = palavra.length();
        char[] lista = palavra.toCharArray();
        String embaralhada1 = "";
        String embaralhada2 = "";

        for (int i = 0; i < tamanho; i++) {
            if (semivogais.contains(lista[i] + ""))
                embaralhada1 += lista[i];
            else if (consonanticos.contains((lista[i] + "")))
                embaralhada2 = lista[i] + embaralhada2;
            else if (vogais.contains((lista[i] + "")))
                embaralhada2 = lista[i] + embaralhada2;
            else
                embaralhada2 += lista[i];
        }

        return embaralhada1 + embaralhada2;
    }
}
