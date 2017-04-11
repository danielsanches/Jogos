import Jogo.EmbaralhadorFacil;
import Jogo.EmbaralhadorDificil;
import Exceptions.EmbaralhadorException;
import Contratos.Embaralhador;
import Jogo.EmbaralhadorMedio;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Daniel on 01/04/2017.
 */
public class EmbaralhadorTest {
    private Embaralhador embaralhador;

    @Test
    public void ConsigoEmbaralharFacilTest() throws Exception {
        embaralhador = new EmbaralhadorFacil();
        String embaralhado = embaralhador.embaralhar("televisao");

        assertEquals("oasivelet", embaralhado);
    }

    @Test(expected = EmbaralhadorException.class)
    public void NaoConsigoEmbaralharFacilSemPalavraTest() throws Exception {
        embaralhador = new EmbaralhadorDificil();
        String embaralhado = embaralhador.embaralhar(null);
    }

    @Test
    public  void  ConsigoEmbaralharMedioTest() throws Exception{
        embaralhador = new EmbaralhadorMedio();
        String embaralhado = embaralhador.embaralhar("elicoptero");

        assertEquals("eioeolcptr", embaralhado);
    }

    @Test(expected = EmbaralhadorException.class)
    public void NaoConsigoEmbaralharMedioTest() throws Exception {
        embaralhador = new EmbaralhadorMedio();
        String embaralhado = embaralhador.embaralhar("");
    }

    @Test
    public void ConsigoEmbaralharDificilTest() throws Exception {
        embaralhador = new EmbaralhadorDificil();
        String embaralhado = embaralhador.embaralhar("helicoptero");

        assertEquals("ioetpocehlr", embaralhado);
    }

    @Test(expected = EmbaralhadorException.class)
    public void NaoConsigoEmbaralharDificilSemPalavraTest() throws Exception {
        embaralhador = new EmbaralhadorDificil();
        String embaralhado = embaralhador.embaralhar("");
    }
}