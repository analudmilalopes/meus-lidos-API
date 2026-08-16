package meus_lidos_list.autor;

import lombok.RequiredArgsConstructor;
import meus_lidos_list.autor.dto.AutorRequestDTO;
import meus_lidos_list.autor.dto.AutorResponseDTO;
import meus_lidos_list.exception.ParametroNaoEncontrado;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;
    private final AutorMapper autorMapper;

    public AutorResponseDTO cadastrar(AutorRequestDTO autorDTO) {
        AutorModel autor = autorMapper.mapToEntity(autorDTO);
        autor =  autorRepository.save(autor);
        return autorMapper.mapToResponse(autor);
    }

    public List<AutorResponseDTO> listarAutores (){

        List<AutorModel> autores = autorRepository.findAll();
                    return autores.stream()
                            .map(autorMapper::mapToResponse)
                            .collect(Collectors.toList());
    }

    public AutorResponseDTO listaAutorPorId (@PathVariable Long id){

        AutorModel autor = autorRepository.findById(id)
                .orElseThrow(() -> new ParametroNaoEncontrado("Autor nao encontrado."));

                return autorMapper.mapToResponse(autor);
    }

    public AutorResponseDTO listarAutorPorNome (String nome) {

          AutorModel autor = autorRepository.findByNome(nome)
                .orElseThrow(() -> new ParametroNaoEncontrado("Autor nao encontrado."));
            autorRepository.findByNome(nome);

            return autorMapper.mapToResponse(autor);

    }

    public AutorResponseDTO alterarAutorPorId (@PathVariable Long id, AutorRequestDTO autorDTO) {

         autorRepository.findById(id)
                .orElseThrow(() -> new ParametroNaoEncontrado("Autor nao encontrado."));

            AutorModel autorAtualizado = autorMapper.mapToEntity(autorDTO);

            autorAtualizado = autorRepository.save(autorAtualizado);

            return autorMapper.mapToResponse(autorAtualizado);

    }
}
