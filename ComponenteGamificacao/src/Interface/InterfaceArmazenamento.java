package Interface;

import models.PontosPorTipo;
import models.Usuario;

import java.util.ArrayList;

/**
 * Created by Daniel on 11/02/2017.
 */
public interface InterfaceArmazenamento {

    public void ArmazenarUsuario(Usuario usuario);

    public int obterPontoPorTipo(String usuario, String tipo);

    public ArrayList<PontosPorTipo> obterListaPorUsuario(String usuario);

    public ArrayList<PontosPorTipo> obterListaTipoPonto(String tipo);
}

