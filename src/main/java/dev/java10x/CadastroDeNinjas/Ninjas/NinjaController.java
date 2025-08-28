package dev.java10x.CadastroDeNinjas.Ninjas;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    //Adicionar Ninjas(CREATE)
    @PostMapping("/create")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinjas(ninja);
    }

    //Mostrar todos os ninjas(READ)
    @GetMapping("/all")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
        }

    //Procurar ninja por ID(READ
    @GetMapping("/all/{id}")
    public NinjaModel listarNinjaPorID(@PathVariable Long id) {
        return ninjaService.listarNinjasPorID(id);
        }

    //Alterar dados dos ninjas(UPDATE)
    @PutMapping("/change/{id}")
    public NinjaModel alterarNinjaPorID(@PathVariable Long id, @RequestBody NinjaModel ninjaAtualizado) {
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
        }

    //Deletar Ninjas(DELETE)
    @DeleteMapping("/delete/{id}")
    public void deletarNinjaPorID(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
        }
    }