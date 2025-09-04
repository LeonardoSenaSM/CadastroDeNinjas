package dev.java10x.CadastroDeNinjas.Ninjas;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
        NinjaDTO ninjaLista = ninjaService.listarNinjasPorID(id);
        if (ninjaService.listarNinjasPorID(id) != null) {
            return ResponseEntity.ok(ninjaLista);
        }else {
            String erroNinja = "Este ninja não foi encontrado! ID:" + id;
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroNinja);
        }
        }

    //Alterar dados dos ninjas(UPDATE)
    @PutMapping("/change/{id}")
    public ResponseEntity<?> alterarNinjaPorID(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninjaAlterado = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninjaService.listarNinjasPorID(id) != null) {
            return ResponseEntity.ok("Atualizado  " + ninjaAlterado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ID " + ninjaAlterado.getId() + " não existe");
        }
    }

    //Deletar Ninjas(DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletarNinjaPorID(@PathVariable Long id) {
        if (ninjaService.listarNinjasPorID(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Id deletado com sucesso: ID(" + id + ")");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Esse ID não foi encontrado.");
            }
        }
    }