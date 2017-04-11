import mock.MockArmazenamento;
import models.Placar;
import models.PontosPorTipo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Daniel on 11/02/2017.
 */
public class PlacarTest {

    private Placar placar;

    @Before
    public void initializer() {
        placar = new Placar(new MockArmazenamento());
        placar.RegistrarTipoDePontoPorUsuario("Joaquim", "estrela", 44);
        placar.RegistrarTipoDePontoPorUsuario("Joao", "estrela", 35);
        placar.RegistrarTipoDePontoPorUsuario("Patricia", "like", 45);
        placar.RegistrarTipoDePontoPorUsuario("Leticia", "ponto", 10);
        placar.RegistrarTipoDePontoPorUsuario("Maria", "ponto", 17);
        placar.RegistrarTipoDePontoPorUsuario("Carlos", "like", 163);
        placar.RegistrarTipoDePontoPorUsuario("Daniel", "curtida", 90);
        placar.RegistrarTipoDePontoPorUsuario("Daniel", "like", 901);
        placar.RegistrarTipoDePontoPorUsuario("Jhenni", "curtida", 54);
        placar.RegistrarTipoDePontoPorUsuario("Jhenni", "estrela", 254);
        placar.RegistrarTipoDePontoPorUsuario("Marina", "estrela", 524);

        ArrayList<PontosPorTipo> pontos = placar.ObterPontosPorUsuario("Daniel");
        assertTrue(!pontos.isEmpty());
    }

    @Test
    public void registrarTipoDePontoPorUsuarioTest() {
        placar.RegistrarTipoDePontoPorUsuario("Daniel", "curtida", 91);
        ArrayList<PontosPorTipo> pontos = placar.ObterPontosPorUsuario("Daniel");
        assertTrue(!pontos.isEmpty());

        for (PontosPorTipo item : pontos)
            System.out.print("Usuario registrado: " + item.getUsuario() + " - Tipo: " + item.getTipo() + " - Pontos: " + item.getPonto() + "\n");
    }

    @Test
    public void obterPontosPorUsuarioTest() {
        ArrayList<PontosPorTipo> pontos = placar.ObterPontosPorUsuario("Leticia");

        for (PontosPorTipo item : pontos)
            System.out.print(item.getPonto() + " pontos - Tipo: " + item.getTipo() + "\n");
    }

    @Test
    public void obterRankingPorUsuarioTipoPontoTest() {
        ArrayList<PontosPorTipo> pontos = placar.ObterRankingPorTipoPonto("estrela");
        pontos.sort(Comparator.comparing(PontosPorTipo::getPonto, Collections.reverseOrder()));

        System.out.print("Ranking por tipo \n");
        int i = 1;
        for (PontosPorTipo item : pontos) {
            System.out.print(i++ + "º " + item.getUsuario() + "-" + item.getPonto() + "\n");
        }
    }
}
