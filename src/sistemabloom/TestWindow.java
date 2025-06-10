package sistemabloom;
import java.util.List;
import java.util.Arrays;
import sistemabloom.Item;

public class TestWindow extends javax.swing.JFrame {
    private String nombre;
    private String rut;
    private String fecha;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TestWindow.class.getName());
    private List<Item> items;
    private int indiceActual = 0;
    private int[] respuestasUsuario;
    
public TestWindow(List<Item> items, String nombre, String rut, String fecha) {
    this.items = items;
    this.nombre = nombre;
    this.rut = rut;
    this.fecha = fecha;
    this.respuestasUsuario = new int[items.size()];
    Arrays.fill(this.respuestasUsuario, -1); 
    initComponents();

    if (!items.isEmpty()) {
        mostrarItem();
    } else {
        lblPregunta.setText("No hay ítems cargados.");
        btnAnterior.setEnabled(false);
        btnSiguiente.setEnabled(false);
        btnEnviar.setEnabled(false);
    }
}

private void mostrarItem() {
    Item item = items.get(indiceActual);
    lblPregunta.setText(item.getPregunta());

    buttonGroup1.clearSelection();

    if ("VF".equalsIgnoreCase(item.getTipoItem())) {
        opcion1.setText("Verdadero");
        opcion2.setText("Falso");
        opcion3.setVisible(false); 
    } else {
        opcion1.setText(item.getOpcion1());
        opcion2.setText(item.getOpcion2());
        opcion3.setText(item.getOpcion3());
        opcion3.setVisible(true);  
    }

    int respuestaGuardada = respuestasUsuario[indiceActual];
    if (respuestaGuardada == 0) opcion1.setSelected(true);
    if (respuestaGuardada == 1) opcion2.setSelected(true);
    if (respuestaGuardada == 2) opcion3.setSelected(true);

    btnAnterior.setEnabled(indiceActual > 0);
    btnSiguiente.setEnabled(indiceActual < items.size() - 1);
    btnEnviar.setEnabled(indiceActual == items.size() - 1);
}

    @SuppressWarnings("unchecked")
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblPregunta = new javax.swing.JLabel();
        opcion1 = new javax.swing.JRadioButton();
        opcion2 = new javax.swing.JRadioButton();
        opcion3 = new javax.swing.JRadioButton();
        btnSiguiente = new javax.swing.JToggleButton();
        btnAnterior = new javax.swing.JToggleButton();
        btnEnviar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblPregunta.setText("Pregunta");

        buttonGroup1.add(opcion1);
        opcion1.setText("Opción 1");
        opcion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(opcion2);
        opcion2.setText("Opción 2");

        buttonGroup1.add(opcion3);
        opcion3.setText("Opción 3");

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnEnviar.setText("Enviar respuestas");
        btnEnviar.setEnabled(false);
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblPregunta)
                .addGap(166, 166, 166))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opcion3)
                    .addComponent(opcion2)
                    .addComponent(opcion1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnterior)
                        .addGap(27, 27, 27)
                        .addComponent(btnEnviar)
                        .addGap(29, 29, 29)
                        .addComponent(btnSiguiente)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblPregunta)
                .addGap(27, 27, 27)
                .addComponent(opcion1)
                .addGap(29, 29, 29)
                .addComponent(opcion2)
                .addGap(34, 34, 34)
                .addComponent(opcion3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguiente)
                    .addComponent(btnAnterior)
                    .addComponent(btnEnviar))
                .addGap(35, 35, 35))
        );

        pack();
    }

    private void opcion1ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {
      guardarRespuestaSeleccionada();
    if (indiceActual > 0) {
        indiceActual--;
        mostrarItem();
    }    
    }
    private void guardarRespuestaSeleccionada() {
     Item item = items.get(indiceActual);
    if (opcion1.isSelected()) {
        respuestasUsuario[indiceActual] = 0;
    } else if (opcion2.isSelected()) {
        respuestasUsuario[indiceActual] = 1;
    } else if ("OM".equalsIgnoreCase(item.getTipoItem()) && opcion3.isSelected()) {
        respuestasUsuario[indiceActual] = 2;
    } else {
        respuestasUsuario[indiceActual] = -1;
    }
    }
    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {
        guardarRespuestaSeleccionada();
        if (indiceActual < items.size() - 1) {
            indiceActual++;
            mostrarItem();
        }
    }

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {
    guardarRespuestaSeleccionada();
    VentanaResultados resultados = new VentanaResultados(items, respuestasUsuario, nombre, rut, fecha);
    resultados.setVisible(true);
    this.dispose();
    }


    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }

    private javax.swing.JToggleButton btnAnterior;
    private javax.swing.JToggleButton btnEnviar;
    private javax.swing.JToggleButton btnSiguiente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JRadioButton opcion1;
    private javax.swing.JRadioButton opcion2;
    private javax.swing.JRadioButton opcion3;
}
