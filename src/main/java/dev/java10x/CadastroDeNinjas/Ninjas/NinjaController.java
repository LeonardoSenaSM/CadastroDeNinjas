package dev.java10x.CadastroDeNinjas.Ninjas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    //Adicionar Ninjas(CREATE)
    @PostMapping("/create")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinjas(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso: " + novoNinja.getNome() + "(ID): " + novoNinja.getId());
    }

    //Mostrar todos os ninjas(READ)
    @GetMapping("/all")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjaDTOList = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjaDTOList);
        }

    //Procurar ninja por ID(READ)
    @GetMapping("/all/{id}")
    public ResponseEntity<?> listarNinjaPorID(@PathVariable Long id) {
        NinjaDTO ninjaListaId = ninjaService.listarNinjasPorID(id);
        if (ninjaListaId != null) {
            return ResponseEntity.ok(ninjaListaId);
        }else {
            String erroNinja = "Este ninja não foi encontrado! ID:" + id;
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroNinja);
        }
    }

    //Alterar dados dos ninjas(UPDATE)
    @PutMapping("/change/{id}")
    public ResponseEntity<?> alterarNinjaPorID(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        try {
            NinjaDTO ninjaAlterado = ninjaService.atualizarNinja(id, ninjaAtualizado);
            return ResponseEntity.ok("Atualizado  " + ninjaAlterado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    //Deletar Ninjas(DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletarNinjaPorID(@PathVariable Long id) {
        try {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Id deletado com sucesso: ID(" + id + ")");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}