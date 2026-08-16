package meus_lidos_list.livro.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import meus_lidos_list.enums.StatusLeitura;

public record LivroRequestDTO(
        String titulo,

        @NotNull(message = "Nao pode estar vazio!")
        @Min(value = 10, message = "O valor minimo e 10")
        Integer anoPublicacao,
        String isbn,
        String genero,
        String editora,
        Long autorId,
        Integer nota,
        StatusLeitura statusLeitura
) {
}
