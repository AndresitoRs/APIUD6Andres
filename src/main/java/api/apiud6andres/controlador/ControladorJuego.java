package api.apiud6andres.controlador;

import api.apiud6andres.modelo.Juego;
import api.apiud6andres.repositorio.JuegoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/juego")
public class ControladorJuego {

    @Autowired
    private JuegoRepositorio juegoRepositorio;

    //Encontrar todos los juegos
    @GetMapping
    public List<Juego> obtenerJuegos(){
        return juegoRepositorio.findAll();
    }

    //Obtener un juego por id con GET
    @GetMapping("/{id}")
    public Juego obtenerJuego(@PathVariable long id){
        Optional<Juego> resultado=juegoRepositorio.findById(id);
        return resultado.orElseThrow(() ->
                new RuntimeException("Juego no encontrado"));
    }

    //Crear Juego, con POST
    @PostMapping
    public Juego crearJuego(@RequestBody Juego juego) {
        return juegoRepositorio.save(juego);
    }

    //Actualizar juego, con PUT
    @PutMapping("/{id}")
    public Juego actualizarJuego(@PathVariable long id, @RequestBody Juego juego){
        return juegoRepositorio.findById(id).map(juegoTempo -> {
            juegoTempo.setNombre(juego.getNombre());
            return juegoRepositorio.save(juegoTempo);
        }).orElseThrow(()-> new RuntimeException("Juego no encontrado"));
    }

    //Eliminar  un juego con DELETE
    @DeleteMapping("{id}")
    public void eliminarJuego(@PathVariable long id) {
        juegoRepositorio.deleteById(id);
    }
}
