package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    //POST -- Manda uma requisição para Criar as missões
    @PostMapping("/create")
    public String criaMissoes() {
        return "Missão Criada";
    }

    //GET - manda uma requisição para mostra as missoes
    @GetMapping("/all")
    public String todasAsMissoes() {
        return "Mostra todas as missões";
    }

    @GetMapping("/allID")
    public String todasMissoesID() {
        return "Mostra todas as missões";
    }

    //PUT - manda uma requisição para alterar as missoes
    @PutMapping("/changeID")
    public String alteraMisoes(){
        return "Missao alterada";
    }

    //DELETE - manda uma requisição para Deletar as missoes
    @DeleteMapping("/deleteID")
    public String deletaMissoesID() {
        return "Deleta as missões";
    }
}