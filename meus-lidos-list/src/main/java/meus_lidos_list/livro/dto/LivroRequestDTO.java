package meus_lidos_list.livro.dto;

import meus_lidos_list.enums.StatusLeitura;

public record LivroRequestDTO(
        String titulo,
        Integer anoPublicacao,
        String isbn,
        String genero,
        String editora,
        Long autorId,
        Integer nota,
        StatusLeitura statusLeitura
) {
}
