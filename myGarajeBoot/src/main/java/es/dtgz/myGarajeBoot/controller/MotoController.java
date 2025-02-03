package es.dtgz.myGarajeBoot.controller;

import es.dtgz.myGarajeBoot.model.Moto;
import es.dtgz.myGarajeBoot.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/motos")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @GetMapping
    public String listMotos(Model model) {
        model.addAttribute("motos", motoService.getAllMotos());
        return "motos/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("moto", new Moto());
        return "motos/create";
    }

    @PostMapping
    public String saveMoto(@ModelAttribute Moto moto) {
        motoService.saveMoto(moto);
        return "redirect:/motos";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("moto", motoService.getMotoById(id).orElseThrow(() -> new IllegalArgumentException("Moto no encontrada")));
        return "motos/edit";
    }

    @PostMapping("/update/{id}")
    public String updateMoto(@PathVariable Long id, @ModelAttribute Moto moto) {
        moto.setId(id);
        motoService.saveMoto(moto);
        return "redirect:/motos";
    }

    @GetMapping("/delete/{id}")
    public String deleteMoto(@PathVariable Long id) {
        motoService.deleteMoto(id);
        return "redirect:/motos";
    }
}