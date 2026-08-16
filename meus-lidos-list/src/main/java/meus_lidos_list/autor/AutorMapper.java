package meus_lidos_list.autor;


import meus_lidos_list.autor.dto.AutorRequestDTO;
import meus_lidos_list.autor.dto.AutorResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class AutorMapper {

    public AutorModel mapToEntity(AutorRequestDTO autorDTO) {
        AutorModel autorModel = new AutorModel();
        autorModel.setNome(autorDTO.nome());
        autorModel.setIdade(autorDTO.idade());
        autorModel.setNacionalidade(autorDTO.nacionalidade());

        return autorModel;
    }

    public AutorResponseDTO mapToResponse(AutorModel autorModel) {
        return  new AutorResponseDTO(
                autorModel.getNome(),
                autorModel.getIdade(),
                autorModel.getNacionalidade()
                );
    }
}
