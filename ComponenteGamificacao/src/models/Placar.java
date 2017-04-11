package models;

import Interface.InterfaceArmazenamento;

import java.util.ArrayList;

/**
 * Created by Daniel on 11/02/2017.
 */
public class Placar {

    private InterfaceArmazenamento armazenamento;

    public Placar(InterfaceArmazenamento armazenamento) {
        this.armazenamento = armazenamento;
    }

    public void RegistrarTipoDePontoPorUsuario(String usuario, String tipo, int ponto) {
        armazenamento.ArmazenarUsuario(new Usuario(usuario, tipo, ponto));
    }

    public ArrayList<PontosPorTipo> ObterPontosPorUsuario(String usuario) {
        return armazenamento.obterListaPorUsuario(usuario);
    }

    public ArrayList<PontosPorTipo> ObterRankingPorTipoPonto(String tipo) {
        return armazenamento.obterListaTipoPonto(tipo);
    }
}
