package Jogo;

import Contratos.MecanicaDoJogo;
import Repositorio.BancoDePalavras;

/**
 * Created by Daniel on 01/04/2017.
 * O jogador começa com 5 tentativas, caso alcance os 10 pontos você ganha
 * mais 2 tentativas para tentar chegar ao final do jogo com o máximo de pontos.
 * Cada palavar errada perde 1 tentativa. Se errar 2 vezes consecutivas perde 1 ponto caso tenha
 */
public class MecanicaJogoA extends MecanicaDoJogo {

    private int numeroErro = 0;
    private int pontuacaoMaxima;
    private boolean errouPalavra = false;
    private BancoDePalavras bancoDePalavras;

    public MecanicaJogoA(BancoDePalavras bancoDePalavras) {
        this.bancoDePalavras = bancoDePalavras;
        pontuacaoMaxima = bancoDePalavras.getPalavras().size();
        numeroTentativas = 5;
    }

    public boolean jogoAbabou() {
        String msg = "";
        if (numeroErro == 2) {
            numeroErro = 0;
            msg = "Dois erros seguidos, você perdeu 1 ponto. ";
            pontuacao -= 1;
        }

        if (numeroTentativas == 0) {
            setMensagem("Suas tentativas acabaram, comece um novo jogo! \n");
            return true;
        } else if (numeroTentativas > 0 && errouPalavra) {
            setMensagem(msg + "Palavra incorreta, tente novamente, você aninda tem " + numeroTentativas + " tentativas! \n");
            return false;
        } else if (numeroTentativas >= 0 && pontuacao == pontuacaoMaxima) {
            setMensagem("Parabéns você acertou todas as palavras!!! \n");
            return true;
        }

        setMensagem("");
        return false;
    }

    public boolean palavraEstaCerta(String palavra) {

        if (bancoDePalavras.getPalavraCreta().equals(palavra)) {
            pontuacao++;

            if (pontuacao == 10) {
                numeroTentativas += 3;
            }

            numeroErro = 0;
            errouPalavra = false;
            return true;
        }

        numeroErro += 1;
        numeroTentativas -= 1;
        errouPalavra = true;
        return false;
    }

    public boolean podeTentarNovamente() {
        if (numeroTentativas > 0 && bancoDePalavras.getPalavras().size() >= pontuacao)
            return true;

        return false;
    }
}
