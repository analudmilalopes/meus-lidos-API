package meus_lidos_list.autor;

import lombok.RequiredArgsConstructor;
import meus_lidos_list.autor.dto.AutorRequestDTO;
import meus_lidos_list.autor.dto.AutorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
@RequiredArgsConstructor
public class AutorController {

    private final AutorRepository autorRepository;
    private final AutorService autorService;

    @PostMapping
    public ResponseEntity<AutorResponseDTO> adicionarAutor(@RequestBody AutorRequestDTO autorDTO){
        AutorResponseDTO autorNovo = autorService.cadastrar(autorDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(autorNovo);
    }

    @GetMapping
    public ResponseEntity<List<AutorResponseDTO>> listarAutores(){
        List<AutorResponseDTO> autores = autorService.listarAutores();
        return ResponseEntity.ok(autores);
    }
}
