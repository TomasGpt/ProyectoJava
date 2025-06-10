package sistemabloom;

public class Item {
    private String pregunta;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String respuestaCorrecta;
    private String tipoItem;
    private String nivelBloom;
    private int tiempoEstimado;

    public Item(String pregunta, String opcion1, String opcion2, String opcion3,
                String respuestaCorrecta, String tipoItem, String nivelBloom, int tiempoEstimado) {
        this.pregunta = pregunta;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.respuestaCorrecta = respuestaCorrecta;
        this.tipoItem = tipoItem;
        this.nivelBloom = nivelBloom;
        this.tiempoEstimado = tiempoEstimado;
    }

    public String getPregunta() { return pregunta; }
    public String getOpcion1() { return opcion1; }
    public String getOpcion2() { return opcion2; }
    public String getOpcion3() { return opcion3; }
    public String getRespuestaCorrecta() { return respuestaCorrecta; }
    public String getTipoItem() { return tipoItem; }
    public String getNivelBloom() { return nivelBloom; }
    public int getTiempoEstimado() { return tiempoEstimado; }
    public String getOpcionPorIndice(int indice) {
        switch (indice) {
            case 0: return opcion1;
            case 1: return opcion2;
            case 2: return opcion3;
            default: return "";
        }
    }
}
