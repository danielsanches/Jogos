package Jogo;

import Contratos.MecanicaDoJogo;

/**
 * Created by Daniel on 01/04/2017.
 */
public class FabricaDaMecanidaDoJogo {
    private MecanicaDoJogo mecanicaDoJogo;

    public FabricaDaMecanidaDoJogo(MecanicaDoJogo mecanicaDoJogo) {
        this.mecanicaDoJogo = mecanicaDoJogo;
    }

    public  MecanicaDoJogo RetornaMecanicaJogo(){
        return  mecanicaDoJogo;
    }
}
