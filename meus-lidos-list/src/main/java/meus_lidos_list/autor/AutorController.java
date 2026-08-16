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

    @GetMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> buscarAutorPorId(@PathVariable Long id){

        AutorResponseDTO autor = autorService.listaAutorPorId(id);

        return ResponseEntity.ok(autor);
    }

    @GetMapping("/{nome}")
    public ResponseEntity <AutorResponseDTO> buscarAutorPorNome(@PathVariable String nome){

       AutorResponseDTO autor = autorService.listarAutorPorNome(nome);

        return ResponseEntity.ok(autor);
    }

    @PutMapping
    public ResponseEntity <AutorResponseDTO> atualizarAutor(@PathVariable Long id, @RequestBody AutorRequestDTO autorDTO){
        AutorResponseDTO autor = autorService.alterarAutorPorId(id, autorDTO);

        return ResponseEntity.ok(autor);
    }
}
