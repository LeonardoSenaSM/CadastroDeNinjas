package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    //POST -- Manda uma requisição para Criar as missões
    @PostMapping("/createMissions")
    public String criaMissoes() {
        return "Missão Criada";
    }

    //GET - manda uma requisição para mostra as missoes
    @GetMapping("/allMissions")
    public String todasAsMissoes() {
        return "Mostra todas as missões";
    }

    @GetMapping("/allMissionsID")
    public String todasMissoesID() {
        return "Mostra todas as missões";
    }

    //PUT - manda uma requisição para alterar as missoes
    @PutMapping("/changeID")
    public String alteraMisoes(){
        return "Missao alterada";
    }

    //DELETE - manda uma requisição para Deletar as missoes
    @DeleteMapping("/deleteMissionsID")
    public String deletaMissoesID() {
        return "Deleta as missões";
    }
}