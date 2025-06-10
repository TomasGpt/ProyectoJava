package sistemabloom;

import java.io.*;
import java.util.*;

public class ItemLoader {

    public static List<Item> cargarDesdeArchivo(String rutaArchivo) throws Exception {
        List<Item> lista = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        String linea;
        boolean primera = true;

        while ((linea = br.readLine()) != null) {
            if (primera) {
                primera = false;
                continue;
            }

            String[] partes = linea.split(";");
            if (partes.length != 8) continue;

            String pregunta = partes[0];
            String opcion1 = partes[1];
            String opcion2 = partes[2];
            String opcion3 = partes[3];
            String respuesta = partes[4];
            String tipo = partes[5];
            String nivel = partes[6];
            int tiempo = Integer.parseInt(partes[7]);

            lista.add(new Item(pregunta, opcion1, opcion2, opcion3, respuesta, tipo, nivel, tiempo));
        }

        br.close();
        return lista;
    }
}
