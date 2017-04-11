package Jogo;

import Contratos.Embaralhador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Daniel on 01/04/2017.
 */
public class FabricaDeEmbaralhadores {
    private List<Embaralhador> embaralhadores;

    public FabricaDeEmbaralhadores() {
        embaralhadores = new ArrayList<>();
        embaralhadores.add(new EmbaralhadorFacil());
        embaralhadores.add(new EmbaralhadorMedio());
        embaralhadores.add(new EmbaralhadorDificil());
    }

    public Embaralhador RetornoAleatorio() {
        return embaralhadores.get(Retorno());
    }

    public int Retorno() {
        Random gerador = new Random();
        return gerador.nextInt(3);
    }
}
