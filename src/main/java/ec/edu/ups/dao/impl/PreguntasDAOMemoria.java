package ec.edu.ups.dao.impl;

import ec.edu.ups.dao.PreguntasDAO;
import ec.edu.ups.modelo.Preguntas;

import java.util.ArrayList;
import java.util.List;

public class PreguntasDAOMemoria implements PreguntasDAO {
    private List<Preguntas> preguntas;

    public PreguntasDAOMemoria() {
        this.preguntas = new ArrayList<Preguntas>();
        crear(new Preguntas("01", "Cual es el nombre de tu mascota"));
        crear(new Preguntas("02", "¿Cuál es tu comida favorita?"));
        crear(new Preguntas("03", "¿Cuál es tu color favorito?"));
        crear(new Preguntas("04", "¿Cómo se llama tu mejor amigo de la infancia?"));
        crear(new Preguntas("05", "¿Cuál es el nombre de tu primer maestro?"));
        crear(new Preguntas("06", "¿Cuál es el nombre de tu abuela materna?"));
        crear(new Preguntas("07", "¿En qué ciudad naciste?"));
        crear(new Preguntas("08", "¿Cuál fue tu primer trabajo?"));
        crear(new Preguntas("09", "¿Cuál es el segundo nombre de tu padre?"));
        crear(new Preguntas("10", "¿Cuál es tu deporte favorito?"));
        crear(new Preguntas("11", "¿Cómo se llamaba tu primer amor?"));

    }

    @Override
    public void crear(Preguntas pregunta) {
        preguntas.add(pregunta);
    }

    @Override
    public List<Preguntas> listarPreguntas() {
        return preguntas;
    }

    @Override
    public List<Preguntas> listarPreguntasEnunciado() {
        return preguntas;
    }
}
