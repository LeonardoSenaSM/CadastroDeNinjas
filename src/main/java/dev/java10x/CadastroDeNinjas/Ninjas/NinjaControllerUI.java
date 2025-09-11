package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesDTO;
import dev.java10x.CadastroDeNinjas.Missoes.MissoesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUI {

    private final NinjaService ninjaService;
    private final MissoesService missoesService;

    public NinjaControllerUI(NinjaService ninjaService, MissoesService missoesService) {
        this.ninjaService = ninjaService;
        this.missoesService = missoesService;
    }
    @GetMapping("/all")
    public String listarNinjas(Model model){
        List<NinjaDTO> ninja = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninja);
        return "listarNinjas";
        //Tem que retornar o nome que renderiza
    }
    @GetMapping("/all/{id}")
    public String listarNinjaPorID(@PathVariable Long id,Model model) {
        NinjaDTO ninja = ninjaService.listarNinjasPorID(id);
        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "detalhesNinja";
        }else {
            model.addAttribute("mensagem", "ninja não encontrado");
            return "redirect:/ninjas/ui/all";
        }
    }

    @GetMapping("/change/{id}")
    public String mostrarFormularioAlterarNinja(@PathVariable Long id, Model model) {
        NinjaDTO ninjaEncontrado = ninjaService.listarNinjasPorID(id);
        if (ninjaEncontrado != null) {
            model.addAttribute("ninja", ninjaEncontrado);
            List<MissoesDTO> missoes = missoesService.listarMissoes();
            model.addAttribute("missoes", missoes);
            return "alterarNinja";
        } else {
            return "redirect:/ninjas/ui/all";
        }
    }
    @PostMapping("/change/{id}")
    public String alterarNinjaPorID(@PathVariable Long id,NinjaDTO ninjaDTO, RedirectAttributes redirectAttributes) {
            ninjaService.atualizarNinja(ninjaDTO.getId() ,ninjaDTO);
            redirectAttributes.addFlashAttribute("Ninja alterado com sucesso!");
        return "redirect:/ninjas/ui/all";

    }

    @GetMapping("/delete/{id}")
    public String deletarNinjaPorID(@PathVariable Long id) {
      ninjaService.deletarNinjaPorId(id);
      return "redirect:/ninjas/ui/all";
    }
    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarNinja(Model model){
        model.addAttribute("ninja", new NinjaDTO());
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        model.addAttribute("missoes", missoes);
        return "adicionarNinja";
    }


    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.criarNinjas(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja cadastrado com sucesso!");
        return "redirect:/ninjas/ui/all";
    }

}
