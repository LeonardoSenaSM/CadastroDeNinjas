package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }
    public NinjaDTO criarNinjas(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }
    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }
    //lista ninjas por id
    public NinjaDTO listarNinjasPorID(Long id){
        Optional<NinjaModel> ninjaPorID = ninjaRepository.findById(id);
        return ninjaPorID.map(ninjaMapper::map).orElse(null);
    }
    //altera ninjas na tabela SQL
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
            if (ninjaExistente.isPresent()){
                NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
                ninjaAtualizado.setId(id);
                NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
                return ninjaMapper.map(ninjaSalvo);
            }
        return null;
        }

    //Deleta ninjas
    public void deletarNinjaPorId(Long id){
        if(ninjaRepository.existsById(id)) {
            ninjaRepository.deleteById(id);
        }else {
            throw new IllegalArgumentException("Este item não existe!");
        }
    }

}