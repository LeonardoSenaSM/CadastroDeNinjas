package dev.java10x.CadastroDeNinjas.Missoes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Cria uma nova missão", description = "Rota cria uma nova missão e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missão criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação da missão")
    })
    public ResponseEntity<MissoesDTO> criaMissoes(
            @Parameter(description = "Usuário manda os dados no corpo da requisição de criação")
            @RequestBody MissoesDTO missao) {
        MissoesDTO novaMissao = missoesService.criarMissoes(missao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMissao);
    }

    //GET - manda uma requisição para mostra as missoes
    @GetMapping("/all")
    @Operation(summary = "Lista as missões", description = "Rota lista as missões")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Lista chamada com sucesso"),
            @ApiResponse(responseCode = "404",description = "Não foi possivel listar")
    })
    public ResponseEntity<List<MissoesDTO>> todasAsMissoes() {
        List<MissoesDTO> missoesDTOList = missoesService.listarMissoes();
        return ResponseEntity.ok(missoesDTOList);
    }

    @GetMapping("/all/{id}")
    @Operation(summary = "Lista missão por ID", description = "Rota lista uma missão por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Missão encontrado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Missão não encontrado")
    })
    public ResponseEntity<?> todasMissoesID(
            @Parameter(description = "Usuario manda o id no caminho da requisição")
            @PathVariable Long id) {
        MissoesDTO missoesListarPorId = missoesService.listarMissoesPorID(id);
        if(missoesListarPorId != null) {
            return ResponseEntity.ok(missoesListarPorId);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma missao encontrada com este Id: " + id);
        }
    }

    //PUT - manda uma requisição para alterar as missoes
    @PutMapping("/change/{id}")
    @Operation(summary = "Altera a missão por ID", description = "Rota altera uma missão por id para alterar no Banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Missão alterado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Missão não encontrado, não foi possivel alterar")
    })
    public ResponseEntity<?> alteraMisoes(
            @Parameter(description = "Usuario manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados para ser alterado no corpo da requisição")
            @RequestBody MissoesDTO missoesAtualizada){
        try{
            MissoesDTO missaoAlterada = missoesService.atualizadMissao(id, missoesAtualizada);
            return ResponseEntity.ok("Atualizada " +missoesAtualizada);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    //DELETE - manda uma requisição para Deletar as missoes
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Deleta a missão por ID", description = "Rota deleta a missão por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Missão deletado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Missão não encontrado")
    })
    public ResponseEntity<String> deletaMissoesID(
            @Parameter(description = "Usuario manda o id no caminho da requisição de deleção")
            @PathVariable Long id) {
        try{
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Id deletado com sucesso: ID: ("+id+")");
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}