package meus_lidos_list.autor;

import lombok.RequiredArgsConstructor;
import meus_lidos_list.autor.dto.AutorRequestDTO;
import meus_lidos_list.autor.dto.AutorResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;
    private final AutorMapper autorMapper;

    public AutorResponseDTO cadastrar(AutorRequestDTO autorDTO) {
        AutorModel autor = autorMapper.map(autorDTO);
        autor =  autorRepository.save(autor);
        return autorMapper.map(autor);
    }

    public List<AutorResponseDTO> listarAutores (){

        List<AutorModel> autores = autorRepository.findAll();
                    return autores.stream()
                            .map(autorMapper::map)
                            .collect(Collectors.toList());
    }
}
