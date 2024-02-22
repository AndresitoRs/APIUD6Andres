package api.apiud6andres.controlador;

import api.apiud6andres.modelo.Juego;
import api.apiud6andres.modelo.Puntuacion;
import api.apiud6andres.repositorio.JuegoRepositorio;
import api.apiud6andres.repositorio.PuntuacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/puntuacion")
public class ControladorPuntuacion {

    @Autowired
    private PuntuacionRepositorio puntuacionRepositorio;

    @Autowired
    private JuegoRepositorio juegoRepositorio;

    //Obtener todas las puntuaciones
    @GetMapping
    public List<Puntuacion> obtenerPuntuacion(){
        return puntuacionRepositorio.findAll();
    }


    //Obtener puntuacion por id
    @GetMapping("/{id}")
    public Puntuacion obtenerPuntuacion(@PathVariable long id){
        Optional<Puntuacion> resultado=puntuacionRepositorio.findById(id);
        return resultado.orElseThrow(() ->
                new RuntimeException("Puntuacion no encontrada"));
    }

    //Crear Puntuacion, con POST
    @PostMapping("/juego/{id}")
    public Puntuacion crearPuntuacion(@PathVariable long id,@RequestBody Puntuacion puntuacion){
        Puntuacion puntuacionTempo = juegoRepositorio.findById(id).map(juego -> {
            puntuacion.setJuego(juego);
            return puntuacionRepositorio.save(puntuacion);
        }).orElseThrow(() -> new RuntimeException("Juego no encontrado"));
        return puntuacionTempo;
    }

    //actualizar  un recurso con PUT
    @PutMapping("/{id}")
    public Puntuacion actualizarPuntuacion(@PathVariable long id, @RequestBody Puntuacion puntuacion){
        return puntuacionRepositorio.findById(id).map(puntuacionTempo -> {
            puntuacionTempo.setNombreJugador((puntuacion.getNombreJugador()!= null)? puntuacion.getNombreJugador(): puntuacionTempo.getNombreJugador());
            puntuacionTempo.setPuntuacion(puntuacion.getPuntuacion());
            return puntuacionRepositorio.save(puntuacionTempo);
        }).orElseThrow(()-> new RuntimeException("Puntuación no encontrada"));
    }

    //Eliminar  un recurso con DELETE
    @DeleteMapping("{id}")
    public void eliminarPuntuacion(@PathVariable long id) {
        puntuacionRepositorio.deleteById(id);
    }
}
