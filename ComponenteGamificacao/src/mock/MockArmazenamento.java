package mock;

import Interface.InterfaceArmazenamento;
import models.PontosPorTipo;
import models.Usuario;

import java.io.InvalidObjectException;
import java.util.ArrayList;

/**
 * Created by Daniel on 11/02/2017.
 */
public class MockArmazenamento implements InterfaceArmazenamento {

    private Usuario _usuario;
    private ArrayList<Usuario> _listaUsuarios = new ArrayList<>();

    @Override
    public void ArmazenarUsuario(Usuario usuario) {
        try {
            if (usuario.getUsuario().isEmpty())
                throw new InvalidObjectException("Favor informar o usuario.");

            _listaUsuarios.add(usuario);

        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int obterPontoPorTipo(String usuario, String tipo) {
        int ponto = 0;

        for (Usuario item : _listaUsuarios) {
            if (item.getUsuario().equals(usuario)) {
                for (PontosPorTipo item1 : item.getPontosPorTipo()) {
                    if (item1.getTipo().equals(tipo)) {
                        ponto = item1.getPonto();
                        break;
                    }
                }
            }
        }

        return ponto;
    }

    @Override
    public ArrayList<PontosPorTipo> obterListaPorUsuario(String usuario) {

        ArrayList<PontosPorTipo> novaLista = new ArrayList<>();
        for (Usuario item : _listaUsuarios) {
            if (item.getUsuario().equals(usuario))
                novaLista.addAll(item.getPontosPorTipo());
        }

        return novaLista;
    }

    @Override
    public ArrayList<PontosPorTipo> obterListaTipoPonto(String tipo) {
        ArrayList<PontosPorTipo> novaLista = new ArrayList<>();
        for (Usuario item : _listaUsuarios) {
            for (PontosPorTipo item1 : item.getPontosPorTipo()) {
                if (item1.getTipo().equals(tipo))
                    novaLista.add(item1);
            }
        }

        return novaLista;
    }
}
