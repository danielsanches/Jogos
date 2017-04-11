package models;

/**
 * Created by Daniel on 11/02/2017.
 */
public class PontosPorTipo {
    private String usuario;
    private String tipo;
    private int ponto;

    public PontosPorTipo(String usuario, String tipo, int ponto) {
        this.usuario = usuario;
        this.tipo = tipo;
        this.ponto = ponto;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPonto() {
        return ponto;
    }
}
