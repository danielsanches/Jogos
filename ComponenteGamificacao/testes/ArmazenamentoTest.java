import models.Armazenamento;
import models.Placar;
import models.PontosPorTipo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.Assert.assertTrue;

/**
 * Created by Daniel on 11/02/2017.
 */
public class ArmazenamentoTest {

    private Placar placar;

    @Test
    public void registrarTipoDePontoPorUsuarioTest() {
        placar = new Placar(new Armazenamento());
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
        placar.RegistrarTipoDePontoPorUsuario("Rafael", "ponto", 44);

        ArrayList<PontosPorTipo> pontos = placar.ObterPontosPorUsuario("Daniel");
        assertTrue(!pontos.isEmpty());
    }

    @Test
    public void obterPontosPorUsuarioTest() {
        placar = new Placar(new Armazenamento());
        ArrayList<PontosPorTipo> pontos = placar.ObterPontosPorUsuario("Rafael");

        for (PontosPorTipo item : pontos)
            System.out.print(item.getPonto() + " pontos - Tipo: " + item.getTipo() + "\n");
    }

    @Test
    public void obterRankingPorUsuarioTipoPontoTest() {
        placar = new Placar(new Armazenamento());
        ArrayList<PontosPorTipo> pontos = placar.ObterRankingPorTipoPonto("like");
        pontos.sort(Comparator.comparing(PontosPorTipo::getPonto, Collections.reverseOrder()));

        System.out.print("Ranking por tipo \n");
        int i = 1;
        for (PontosPorTipo item : pontos) {
            System.out.print(i++ + "º " + item.getUsuario() + "-" + item.getPonto() + "\n");
        }
    }
}