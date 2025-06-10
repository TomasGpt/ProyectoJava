package sistemabloom;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaResultados extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaResultados.class.getName());
    
public VentanaResultados(List<Item> items, int[] respuestasUsuario, String nombre, String rut, String fecha) {
    setTitle("Resumen de Resultados");
    setSize(500, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLayout(new BorderLayout());

    int[] conteo = new int[6];
    int correctas = 0, incorrectas = 0;

    for (int i = 0; i < items.size(); i++) {
        if (respuestasUsuario[i] != -1) {
            Item item = items.get(i);
            if (item.getRespuestaCorrecta().equalsIgnoreCase(
                    item.getOpcionPorIndice(respuestasUsuario[i]))) {
                correctas++;
            } else {
                incorrectas++;
            }

            String nivelTexto = item.getNivelBloom().toLowerCase().trim();
int nivel = switch (nivelTexto) {
    case "recordar" -> 0;
    case "comprender" -> 1;
    case "aplicar" -> 2;
    case "analizar" -> 3;
    case "evaluar" -> 4;
    case "crear" -> 5;
    default -> -1; 
};
if (nivel >= 0 && nivel <= 5) {
    conteo[nivel]++;
}
            if (nivel >= 0 && nivel <= 5) conteo[nivel]++;
        }
    }

    JTextArea areaResumen = new JTextArea();
    areaResumen.setEditable(false);
    areaResumen.append("Nombre: " + nombre + "\n");
    areaResumen.append("RUT: " + rut + "\n");
    areaResumen.append("Fecha: " + fecha + "\n\n");
    areaResumen.append("Resumen por niveles de Bloom:\n");
    areaResumen.append("Recordar: " + conteo[0] + "\n");
    areaResumen.append("Comprender: " + conteo[1] + "\n");
    areaResumen.append("Aplicar: " + conteo[2] + "\n");
    areaResumen.append("Analizar: " + conteo[3] + "\n");
    areaResumen.append("Evaluar: " + conteo[4] + "\n");
    areaResumen.append("Crear: " + conteo[5] + "\n\n");
    areaResumen.append("Correctas: " + correctas + "\n");
    areaResumen.append("Incorrectas: " + incorrectas + "\n");

    JButton btnCerrar = new JButton("Cerrar");
    btnCerrar.addActionListener(e -> dispose());

    add(new JScrollPane(areaResumen), BorderLayout.CENTER);
    add(btnCerrar, BorderLayout.SOUTH);
}

    @SuppressWarnings("unchecked")
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }
}
