package Repositorio;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Daniel on 01/04/2017.
 */
public class BancoDePalavras {

    private ArrayList<String> lista;
    private final String aquivo = "palavras.txt";
    private static String palavra;

    public BancoDePalavras() {
        lista = new ArrayList<>();
        preecherLista();
    }

    private void preecherLista() {
        try {
            File file = new File(aquivo);
            FileReader reader = null;
            BufferedReader bufferReader = null;
            if (file.exists()) {
                reader = new FileReader(aquivo);
                bufferReader = new BufferedReader(reader);
                String text = null;

                while ((text = bufferReader.readLine()) != null) {
                    lista.add(text.replace(',', ' ').trim());
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPalavraCreta() {
        return palavra;
    }

    public ArrayList<String> getPalavras() {
        return lista;
    }

    public String getAleatorio() {
        Random random = new Random();
        int posicao = random.nextInt(lista.size());

        palavra = lista.get(posicao);
        return palavra;
    }
}