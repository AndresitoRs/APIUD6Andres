package api.apiud6andres.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "juego")

public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String nombre;

    String puntuacion;

    public Juego(){

    }

    public Juego(String nombre){
        this.nombre=nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }
}