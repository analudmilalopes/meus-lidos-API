package meus_lidos_list.livro;

import lombok.RequiredArgsConstructor;
import meus_lidos_list.autor.AutorMapper;
import meus_lidos_list.autor.dto.AutorResponseDTO;
import meus_lidos_list.livro.dto.LivroRequestDTO;
import meus_lidos_list.livro.dto.LivroResponseDTO;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LivroMapper {

    private final AutorMapper autorMapper;
    public LivroModel mapToEntity(LivroRequestDTO livroDTO) {
        LivroModel livroModel = new LivroModel();
        livroModel.setTitulo(livroDTO.titulo());
        livroModel.setIsbn(livroDTO.isbn());
        livroModel.setAnoPublicacao(livroDTO.anoPublicacao());
        livroModel.setGenero(livroDTO.genero());
        livroModel.setEditora(livroDTO.editora());
        livroModel.setStatusLeitura(livroDTO.statusLeitura());
        livroModel.setNota(livroDTO.nota());

        return livroModel;
    }


    public LivroResponseDTO mapToResponse(LivroModel livroModel) {
            return new LivroResponseDTO(
                    livroModel.getTitulo(),
                    livroModel.getIsbn(),
                    livroModel.getAnoPublicacao(),
                    livroModel.getGenero(),
                    livroModel.getEditora(),
                    livroModel.getStatusLeitura(),
                    livroModel.getNota()
            );
    }

    public void update(LivroModel livro, LivroRequestDTO dto) {

        if (dto.titulo() != null) {
            livro.setTitulo(dto.titulo());
        }

        if (dto.isbn() != null) {
            livro.setIsbn(dto.isbn());
        }

        if (dto.anoPublicacao() != null) {
            livro.setAnoPublicacao(dto.anoPublicacao());
        }

        if (dto.genero() != null) {
            livro.setGenero(dto.genero());
        }

        if (dto.editora() != null) {
            livro.setEditora(dto.editora());
        }

        if (dto.statusLeitura() != null) {
            livro.setStatusLeitura(dto.statusLeitura());
        }

        if (dto.nota() != null) {
            livro.setNota(dto.nota());
        }
    }
}
