package dev.java10x.CadastroDeNinjas.Ninjas;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    //Adicionar Ninjas(CREATE)
    @PostMapping("/create")
    public String criarNinja(){
        return "Ninjas criado";
    }

    //Mostrar todos os ninjas(READ)
    @GetMapping("/all")
    public String mostrarNinja(){
        return "Mostrar Ninjas";
        }

    //Procurar ninja por ID(READ
    @GetMapping("/allID")
    public String mostrarNinjaPorID() {
        return "Mostrar Ninja por ID";
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