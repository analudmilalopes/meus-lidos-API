package meus_lidos_list.livro;

import lombok.RequiredArgsConstructor;
import meus_lidos_list.livro.dto.LivroRequestDTO;
import meus_lidos_list.livro.dto.LivroResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return ResponseEntity.ok(livroService.listarLivros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> buscarLivroPorId(@PathVariable Long id) {
        LivroResponseDTO livros = livroService.listarLivrosPorId(id);
        return ResponseEntity.ok(livros);
    }

    @GetMapping("autor/{autorId}")
    public ResponseEntity<List<LivroResponseDTO>> buscarLivroPorAutor(@PathVariable Long autorId) {
        return ResponseEntity.ok(livroService.listarLivrosPorAutorId(autorId));
    }

    @PutMapping("/{id}")
    public ResponseEntity <LivroResponseDTO> atualizarLivroPorId(@PathVariable Long id, @RequestBody LivroRequestDTO livroDTO) {
        LivroResponseDTO livros = livroService.alterarLivroPorId(id,  livroDTO);

        return ResponseEntity.ok(livros);

    }
}