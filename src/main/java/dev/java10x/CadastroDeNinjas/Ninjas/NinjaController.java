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
    @PutMapping("/changeID")
    public String alterarNinjaPorID() {
        return "Ninjas criado";
        }

    //Deletar Ninjas(DELETE)
    @DeleteMapping("/deleteID")
    public String deletarNinjaPorID() {
        return "Ninja deletado por ID";
        }
    }