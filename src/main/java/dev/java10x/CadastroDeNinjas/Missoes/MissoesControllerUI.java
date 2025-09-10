package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesControllerUI {
    private  final MissoesService missoesService;

    public MissoesControllerUI(MissoesService missoesService) {
        this.missoesService = missoesService;
    }
    @GetMapping("/all")
    public String todasAsMissoes(Model model) {
        List<MissoesDTO> missao = missoesService.listarMissoes();
        model.addAttribute("missoes", missao);
        return "listarMissoes";
    }
    @GetMapping("/all/{id}")
    public String todasMissoesID(@PathVariable Long id, Model model){
        MissoesDTO missao = missoesService.listarMissoesPorID(id);
        if(missao != null){
            model.addAttribute("missao", missao);
            return "detalhesMissoes";
        }else {
            model.addAttribute("mensagem", "missão não encontrada!");
            return "redirect:/missoes/ui/all";
        }
    }
    @PostMapping("/change/{id}")
    public String alterarMissoes(@PathVariable Long id, MissoesDTO missoesDTO, RedirectAttributes redirectAttributes){
        missoesService.atualizadMissao(missoesDTO.getId(),missoesDTO);
        redirectAttributes.addFlashAttribute("Missão alterada com sucesso!");
        return "redirect:/missoes/ui/all";
    }
    @GetMapping("/delete/{id}")
    public String deletarMissoesID(@PathVariable Long id){
        missoesService.deletarMissaoPorId(id);
        return "redirect:/missoes/ui/all";
    }
    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarMissao(Model model){
        model.addAttribute("ninja", new MissoesDTO());
        return "adicionarMissoes";
    }
    @PostMapping("/salvar")
    public String salvarMissao(@ModelAttribute MissoesDTO missao, RedirectAttributes redirectAttributes) {
        missoesService.criarMissoes(missao);
        redirectAttributes.addFlashAttribute("mensagem", "Missão cadastrada com sucesso!");
        return "redirect:/missoes/ui/all";
    }
}
