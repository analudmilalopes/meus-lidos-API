package meus_lidos_list.autor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import meus_lidos_list.livro.LivroModel;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "autores")
public class AutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "idade", nullable = false)
    private Integer idade;

    @Column(name = "nacionalidade" , nullable = true, length = 15)
    private String nacionalidade;

    @OneToMany(mappedBy = "autor_id")

    @JsonIgnore
    private List<LivroModel> livros;


}
