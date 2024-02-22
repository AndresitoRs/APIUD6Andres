package api.apiud6andres.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "puntuacion")

public class Puntuacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotBlank(message = "El nombre del jugador no puede estar vacío")
    String nombreJugador;

    long puntuacion;

    @ManyToOne
    @JoinColumn (name = "id_juego")
    private Juego juego;

    public Puntuacion() {

    }

    public Puntuacion(String nombreJugador, long puntuacion, Juego juego) {
        this.nombreJugador = nombreJugador;
        this.puntuacion = puntuacion;
        this.juego = juego;
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

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }
}
