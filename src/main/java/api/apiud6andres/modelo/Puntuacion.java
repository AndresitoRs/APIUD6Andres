package api.apiud6andres.modelo;

import jakarta.persistence.*;

@Entity(name = "puntuacion")

public class Puntuacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String nombreJugador;

    long puntuacion;

    @ManyToOne
    @JoinColumn (name = "id_juego")
    private Juego juego;

    public Puntuacion() {

    }

    public Puntuacion(String nombreJugador, long puntuacion) {
        this.nombreJugador = nombreJugador;
        this.puntuacion = puntuacion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public long getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(long puntuacion) {
        this.puntuacion = puntuacion;
    }
}
