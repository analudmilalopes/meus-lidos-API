package meus_lidos_list.livro.dto;

import meus_lidos_list.autor.dto.AutorRequestDTO;
import meus_lidos_list.enums.StatusLeitura;

public record LivroResponseDTO(
        Long id,
        String titulo,
        String isbn,
        Integer anoPublicacao,
        String genero,
        String editora,
        StatusLeitura statusLeitura,
        Integer nota,
        AutorRequestDTO autor
) {
}
