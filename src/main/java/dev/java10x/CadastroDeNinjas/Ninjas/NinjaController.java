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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinjas(ninja);
    }

    //Mostrar todos os ninjas(READ)
    @GetMapping("/all")
    public List<NinjaDTO> listarNinjas(){
        return ninjaService.listarNinjas();
        }

    //Procurar ninja por ID(READ)
    @GetMapping("/all/{id}")
    public NinjaDTO listarNinjaPorID(@PathVariable Long id) {
        return ninjaService.listarNinjasPorID(id);
        }

    //Alterar dados dos ninjas(UPDATE)
    @PutMapping("/change/{id}")
    public NinjaDTO alterarNinjaPorID(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
        }

    //Deletar Ninjas(DELETE)
    @DeleteMapping("/delete/{id}")
    public void deletarNinjaPorID(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
        }
    }