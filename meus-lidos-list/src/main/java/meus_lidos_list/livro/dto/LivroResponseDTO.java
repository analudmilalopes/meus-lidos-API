package meus_lidos_list.livro.dto;

import meus_lidos_list.autor.dto.AutorResponseDTO;
import meus_lidos_list.enums.StatusLeitura;

public record LivroResponseDTO(
        String titulo,
        String isbn,
        Integer anoPublicacao,
        String genero,
        String editora,
        StatusLeitura statusLeitura,
        Integer nota
) {
}
