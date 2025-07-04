package ec.edu.ups.modelo;

public class PreguntaRespondida {
    private Preguntas preguntas;
    private Respuesta respuesta;

    public PreguntaRespondida(Preguntas preguntas, Respuesta respuesta) {
        this.preguntas = preguntas;
        this.respuesta = respuesta;
    }

    public Preguntas getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Preguntas preguntas) {
        this.preguntas = preguntas;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return getPreguntas().getEnunciado();
    }
}