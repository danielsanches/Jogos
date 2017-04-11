package Jogo;

import Contratos.MecanicaDoJogo;
import Repositorio.BancoDePalavras;

/**
 * Created by Daniel on 01/04/2017.
 * O jogador começa com 3 tentativas caso alcance os 5 pontos ele ganhara
 * mais 2 tentativas para chegar ao final do jogo com os 20 pontos.
 * Cada palavar errada perde 1 tentativa.
 */
public class MecanicaJogoB extends MecanicaDoJogo {
    private int pontuacaoMaxima;
    private boolean errouPalavra = false;
    private BancoDePalavras bancoDePalavras;

    public MecanicaJogoB(BancoDePalavras bancoDePalavras) {
        this.bancoDePalavras = bancoDePalavras;
        pontuacaoMaxima = 20;
        numeroTentativas = 3;
    }

    public boolean jogoAbabou() {
        if (numeroTentativas == 0) {
            setMensagem("Suas tentativas acabaram, comece um novo jogo! \n");
            return true;
        } else if (numeroTentativas > 0 && errouPalavra) {
            setMensagem("Palavra incorreta, tente novamente, você aninda tem " + numeroTentativas + " tentativas! \n");
            errouPalavra = false;
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
            if (pontuacao == 5)
                numeroTentativas += 2;

            errouPalavra = false;
            return true;
        }

        numeroTentativas -= 1;
        errouPalavra = true;
        return false;
    }

    public boolean podeTentarNovamente() {
        if (numeroTentativas > 0 && pontuacaoMaxima >= pontuacao)
            return true;

        return false;
    }
}