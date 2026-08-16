package meus_lidos_list.autor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<AutorModel, Long> {

    Optional<AutorModel> findByNome(String nome);
}
