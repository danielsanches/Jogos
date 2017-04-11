package models;

import Interface.InterfaceArmazenamento;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Formatter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by Daniel on 11/02/2017.
 */
public class Armazenamento implements InterfaceArmazenamento {

    private ArrayList<Usuario> _listaUsuarios = new ArrayList<Usuario>();
    private static final String _baseDados = "baseDados.json";

    @Override
    public void ArmazenarUsuario(Usuario usuario) {
        try {
            if (usuario.getUsuario().isEmpty())
                throw new InvalidObjectException("Favor informar o usuario.");

            _listaUsuarios.add(usuario);
            cadastrar();

        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int obterPontoPorTipo(String usuario, String tipo) {
        obter();
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
        obter();
        ArrayList<PontosPorTipo> novaLista = new ArrayList<>();
        for (Usuario item : _listaUsuarios) {
            if (item.getUsuario().equals(usuario))
                novaLista.addAll(item.getPontosPorTipo());
        }
        return novaLista;
    }

    @Override
    public ArrayList<PontosPorTipo> obterListaTipoPonto(String tipo) {
        obter();

        ArrayList<PontosPorTipo> novaLista = new ArrayList<>();
        for (Usuario item : _listaUsuarios) {
            for (PontosPorTipo item1 : item.getPontosPorTipo()) {
                if (item1.getTipo().equals(tipo))
                    novaLista.add(item1);
            }
        }

        return novaLista;
    }

    private void cadastrar() {
        try {
            File file = new File(_baseDados);
            if (file.exists()) {
                Inserir();
                return;
            }

            Gson gson = new Gson();
            Formatter formatter = new Formatter(_baseDados);
            String userJSONString = gson.toJson(_listaUsuarios);
            formatter.format(userJSONString);
            formatter.close();

        } catch (Exception ex) {
            System.out.println("Arquivo não encontrado.");
        }
    }

    public void Inserir() {
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(_baseDados);
            if (file.exists()) {
                writer = new FileWriter(_baseDados);
                bufferedWriter = new BufferedWriter(writer);
                Gson gson = new Gson();
                String userJSONString = gson.toJson(_listaUsuarios);
                bufferedWriter.write(userJSONString);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();

                if (writer != null)
                    writer.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void obter() {
        try {
            File file = new File(_baseDados);

            if (file.exists()) {

                Type listType = new TypeToken<ArrayList<Usuario>>() {
                }.getType();
                ArrayList<Usuario> yourClassList = new Gson().fromJson(new FileReader(_baseDados), listType);

                _listaUsuarios.addAll(yourClassList);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}