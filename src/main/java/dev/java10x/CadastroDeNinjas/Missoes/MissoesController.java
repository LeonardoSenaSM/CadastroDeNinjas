package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //POST -- Manda uma requisição para Criar as missões
    @PostMapping("/create")
    public ResponseEntity<String> criaMissoes(@RequestBody MissoesDTO missao) {
        MissoesDTO novaMissao = missoesService.criarMissoes(missao);
        return ResponseEntity.status(HttpStatus.CREATED).body("Missão Criada com sucesso: "+ missao.getNome() + "ID: " + missao.getId());
    }

    //GET - manda uma requisição para mostra as missoes
    @GetMapping("/all")
    public ResponseEntity<List<MissoesDTO>> todasAsMissoes() {
        List<MissoesDTO> missoesDTOList = missoesService.listarMissoes();
        return ResponseEntity.ok(missoesDTOList);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<?> todasMissoesID(@PathVariable Long id) {
        MissoesDTO missoesListarPorId = missoesService.listarMissoesPorID(id);
        if(missoesListarPorId != null) {
            return ResponseEntity.ok(missoesListarPorId);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma missao encontrada com este Id: " + id);
        }
    }

    //PUT - manda uma requisição para alterar as missoes
    @PutMapping("/change/{id}")
    public ResponseEntity<?> alteraMisoes(@PathVariable Long id, @RequestBody MissoesDTO missoesAtualizada){
        try{
            MissoesDTO missaoAlterada = missoesService.atualizadMissao(id, missoesAtualizada);
            return ResponseEntity.ok("Atualizada " +missoesAtualizada);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    //DELETE - manda uma requisição para Deletar as missoes
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletaMissoesID(@PathVariable Long id) {
        try{
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Id deletado com sucesso: ID: ("+id+")");
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}