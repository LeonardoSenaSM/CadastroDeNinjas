package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {
    public MissoesModel map (MissoesDTO missoesDTO){
        MissoesModel missoesModel = new MissoesModel();

        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setStatus(missoesDTO.getStatus());
        missoesModel.setNinjas(missoesDTO.getNinjas());

        return missoesModel;
    }

    public MissoesDTO map (MissoesModel missoesModel){

        MissoesDTO missoesDTO = new MissoesDTO();

        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());
        missoesDTO.setStatus(missoesModel.getStatus());
        missoesDTO.setNinjas(missoesModel.getNinjas());

        return missoesDTO;
    }
}