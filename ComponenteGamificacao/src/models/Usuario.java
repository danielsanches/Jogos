package models;

import java.util.ArrayList;

/**
 * Created by Daniel on 11/02/2017.
 */
public class Usuario {
    private String usuario;
    private ArrayList<PontosPorTipo> pontosPorTipo = new ArrayList<>();

    public Usuario(String usuario, String tipo, int ponto) {
        this.usuario = usuario;
        this.pontosPorTipo.add(new PontosPorTipo(usuario,tipo,ponto));
    }

    public String getUsuario() {
        return usuario;
    }

    public ArrayList<PontosPorTipo> getPontosPorTipo() {
        return pontosPorTipo;
    }
}