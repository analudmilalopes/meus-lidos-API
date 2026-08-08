package meus_lidos_list.livro;

import enums.StatusLeitura;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import meus_lidos_list.autor.AutorModel;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data


@Entity
@Table(name = "livros")
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "ano_publicacao", nullable = false)
    private Integer anoPublicacao;

    @Column(name = "isbn", nullable = false,  length = 13)
    private String isbn;

    @Column(name = "genero", nullable = false, length = 100)
    private String genero;

    @Column(name = "editora", nullable = true)
    private String editora;

    @Column(name = "status_leitura", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private StatusLeitura statusLeitura;

    @Column(name = "nota", nullable = true)
    private Integer nota;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    AutorModel autor;

}
