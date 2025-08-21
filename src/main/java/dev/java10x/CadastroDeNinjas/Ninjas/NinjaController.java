package dev.java10x.CadastroDeNinjas.Ninjas;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "essa e minha primeira visita nessa rota";
    }
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
    @PutMapping("/chanceID")
    public String alterarNinjaPorID() {
        return "Ninjas criado";
        }

    //Deletar Ninjas(DELETE)
    @DeleteMapping("/deleteID")
    public String deletarNinjaPorID() {
        return "Ninja deletado por ID";
        }
    }