package api.apiud6andres.repositorio;

import api.apiud6andres.modelo.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
public interface JuegoRepositorio extends JpaRepository<Juego,Long> {
}