import Repositorio.BancoDePalavras;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by dsanches on 03/04/2017.
 */
public class BancoPalavrasTeste {

    ArrayList<String> lista;
    BancoDePalavras banco;

    @Before
    public void Preencherlista() {

        banco = new BancoDePalavras();
        lista = new ArrayList<>();
        lista.addAll(banco.getPalavras());
    }

    @Test
    public void ObterPalavraAleatoria() {

        String temp = "";
        for (int i = 0; i < 5; i++) {
            String palavra = banco.getAleatorio();

            if (temp != "")
                assertNotEquals(temp, palavra);

            temp = palavra;
        }
    }
}
