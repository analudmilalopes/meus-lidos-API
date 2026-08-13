package meus_lidos_list.livro;

import lombok.RequiredArgsConstructor;
import meus_lidos_list.livro.dto.LivroRequestDTO;
import meus_lidos_list.livro.dto.LivroResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroResponseDTO> adicionarLivro(@RequestBody LivroRequestDTO livroDTO) {
       LivroResponseDTO livroNovo = livroService.cadastrar(livroDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(livroNovo);
    }

    @GetMapping
    public ResponseEntity<List<LivroResponseDTO>> listarLivros() {
        List<LivroResponseDTO> livros = livroService.listarLivros();
        return ResponseEntity.ok(livros);
    }

    @GetMapping
    public ResponseEntity<?> buscarLivroPorId(@PathVariable Long id) {
        LivroResponseDTO livros = livroService.listarLivrosPorId(id);
        if (livros != null) {
            return ResponseEntity.ok(livros);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Livro nao encontrado!");
        }

    }

    @GetMapping
    public ResponseEntity<List<LivroResponseDTO>> buscarLivroPorAutor(@PathVariable Long autorId) {
        List<LivroResponseDTO> livros = livroService.listarLivrosPorAutorId(autorId);
        if (!livros.isEmpty()) {
            return ResponseEntity.ok(livros);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(livros);
        }
    }

    @PutMapping
    public ResponseEntity <LivroResponseDTO> atualizarLivroPorId(@PathVariable Long id, @RequestBody LivroRequestDTO livroDTO) {
        LivroResponseDTO livros = livroService.alterarLivroPorId(id, livroDTO);

        return ResponseEntity.ok(livros);

    }
}