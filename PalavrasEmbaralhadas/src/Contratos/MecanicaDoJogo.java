package Contratos;

/**
 * Created by Daniel on 01/04/2017.
 */
public abstract class MecanicaDoJogo {
    protected int pontuacao = 0;
    protected int numeroTentativas = 0;
    private String mensagem = "";

    public void  setMensagem(String mensagem){
        this.mensagem = mensagem;
    }

    public  String getMensagem(){
        return  this.mensagem;
    }

    public abstract boolean jogoAbabou();

    public abstract boolean palavraEstaCerta(String palavra);

    public abstract boolean podeTentarNovamente();

    public String pontuacaoFinal() {
        return "Você conseguiu: " + pontuacao + " pontos. \n";
    }
}
