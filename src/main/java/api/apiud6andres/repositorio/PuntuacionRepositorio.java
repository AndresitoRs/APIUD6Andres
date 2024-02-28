package api.apiud6andres.repositorio;

import api.apiud6andres.modelo.Juego;
import api.apiud6andres.modelo.Puntuacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PuntuacionRepositorio extends JpaRepository<Puntuacion,Long> {
    List<Puntuacion> findAllByJuego(Optional<Juego> juego);
}
