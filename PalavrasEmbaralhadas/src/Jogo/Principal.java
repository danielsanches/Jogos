package Jogo;

import Contratos.Embaralhador;
import Contratos.MecanicaDoJogo;
import Repositorio.BancoDePalavras;

import java.util.Scanner;

/**
 * Created by Daniel on 01/04/2017.
 */
public class Principal {

    public static void main(String[] args) {

        BancoDePalavras bancoDePalavras = new BancoDePalavras();

        FabricaDeEmbaralhadores fabricaEmbraralhador = new FabricaDeEmbaralhadores();
        Embaralhador embaralhador = fabricaEmbraralhador.RetornoAleatorio();

        System.out.print("NÍVEL: " + embaralhador.getClass().getName() + "\n");

        FabricaDaMecanidaDoJogo fabrica = new FabricaDaMecanidaDoJogo(new MecanicaJogoB(bancoDePalavras));
        MecanicaDoJogo mecanica = fabrica.RetornaMecanicaJogo();

        String palavra = "";
        try {
            int contador = 0;
            do {

                if (palavra == "")
                    palavra = bancoDePalavras.getAleatorio();

                System.out.print(contador + 1 + "º palavra: " + embaralhador.embaralhar(palavra) + "\n");
                Scanner reader = new Scanner(System.in);
                System.out.println("Informe a palavra: ");

                if (mecanica.palavraEstaCerta(reader.next().toLowerCase())) {
                    palavra = "";
                    contador++;
                }

                if (mecanica.jogoAbabou()) {
                    System.out.print(mecanica.getMensagem());
                    break;
                } else {
                    System.out.print(mecanica.getMensagem());
                    continue;
                }

            } while (mecanica.podeTentarNovamente());
            System.out.print(mecanica.pontuacaoFinal());

        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }
}
