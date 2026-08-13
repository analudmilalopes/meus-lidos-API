package meus_lidos_list.livro;

import lombok.RequiredArgsConstructor;
import meus_lidos_list.autor.AutorModel;
import meus_lidos_list.autor.AutorRepository;
import meus_lidos_list.autor.dto.AutorRequestDTO;
import meus_lidos_list.exception.ParametroNaoEncontrado;
import meus_lidos_list.livro.dto.LivroRequestDTO;
import meus_lidos_list.livro.dto.LivroResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;
    private final LivroMapper livroMapper;

    public LivroResponseDTO cadastrar(LivroRequestDTO livroDTO) {

        AutorModel autor = autorRepository.findById(livroDTO.autorId())
                .orElseThrow(() ->
                        new ParametroNaoEncontrado("Autor nao encontrado."));
        LivroModel livro = livroMapper.map(livroDTO);
        livro.setAutor(autor);
        livro = livroRepository.save(livro);
        return livroMapper.map(livro);
    }

    public List<LivroResponseDTO> listarLivros() {

        List<LivroModel> livros = livroRepository.findAll();
        return livros.stream()
                .map(livroMapper::map)
                .collect(Collectors.toList());
    }

    public LivroResponseDTO listarLivrosPorId (Long id) {

        LivroModel livros = livroRepository.findById(id)
                .orElseThrow(() -> new ParametroNaoEncontrado("Livro nao encontrado."));

        return livroMapper.map(livros);

    }

    public List<LivroResponseDTO> listarLivrosPorAutorId(Long autorId) {

        List<LivroModel> livros = livroRepository.findByAutorId(autorId);

        return  livros.stream()
                .map(livroMapper::map)
                .collect(Collectors.toList());
    }


    public LivroResponseDTO alterarLivroPorId (Long id, LivroRequestDTO livroDTO) {
            LivroModel livros = livroRepository.findById(id)
                    .orElseThrow(() ->
                            new ParametroNaoEncontrado("Livro nao encontrado."));


            LivroModel livroAtualizado = livroMapper.map(livroDTO);

            livroAtualizado.setId(livros.getId());
            livroAtualizado.setAutor(livros.getAutor());

            LivroModel livroSalvo = livroRepository.save(livroAtualizado);

            return livroMapper.map(livroSalvo);
        }
    }
