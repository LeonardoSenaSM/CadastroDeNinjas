package dev.java10x.CadastroDeNinjas.Ninjas;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de Boas Vindas", description = "Essa rota da uma mensagem de boas vindas para o usuario")
    public String boasVindas(){
        return "Essa e minha rota de mensagem";
    }
    //Adicionar Ninjas(CREATE)
    @PostMapping("/create")
    @Operation(summary = "Cria um novo Ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400",description = "Erro na criação do ninja")
    })
    public ResponseEntity<String> criarNinja(
            @Parameter(description = "Usuario manda os dados no caminho da requisição de criação")
            @RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinjas(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso: " + novoNinja.getNome() + "(ID): " + novoNinja.getId());
    }

    //Mostrar todos os ninjas(READ)
    @GetMapping("/all")
    @Operation(summary = "Lista os Ninjas", description = "Rota lista os ninjas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Lista chamada com sucesso"),
            @ApiResponse(responseCode = "404",description = "Não foi possivel listar")
    })
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjaDTOList = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjaDTOList);
        }

    //Procurar ninja por ID(READ)
    @GetMapping("/all/{id}")
    @Operation(summary = "Lista o Ninja por ID", description = "Rota lista ninja por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Ninja não encontrado")
    })
    public ResponseEntity<?> listarNinjaPorID(
            @Parameter(description = "Usuario manda o id no caminho da requisição")
            @PathVariable Long id) {
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
    @Operation(summary = "Altera o Ninja por ID", description = "Rota altera ninja por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Ninja não encontrado, não foi possivel alterar")
    })
    public ResponseEntity<?> alterarNinjaPorID(
            @Parameter(description = "Usuario manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do ninja a ser atualizado no corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado)
    {
        try {
            NinjaDTO ninjaAlterado = ninjaService.atualizarNinja(id, ninjaAtualizado);
            return ResponseEntity.ok("Atualizado  " + ninjaAlterado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    //Deletar Ninjas(DELETE)
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Deleta o Ninja por ID", description = "Rota deleta um novo ninja por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Ninja não encontrado")
    })
    public ResponseEntity<String> deletarNinjaPorID(
            @Parameter(description = "Usuario manda o id no caminho da requisição de deleção")
            @PathVariable Long id) {
        try {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Id deletado com sucesso: ID(" + id + ")");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}