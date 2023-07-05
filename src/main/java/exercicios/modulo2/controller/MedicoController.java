package exercicios.modulo2.controller;


import exercicios.modulo2.domain.Medico;
import exercicios.modulo2.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public Medico criarMedico(@RequestBody Medico medico) {
        return medicoService.salvarMedico(medico);
    }

    @GetMapping
    public List<Medico> listarMedicos() {
        return medicoService.listarMedicos();
    }

    @PutMapping("/{id}")
    public Medico atualizarMedico(@PathVariable Long id, @RequestBody Medico medico) {
        return medicoService.atualizarMedico(id, medico);
    }

    @DeleteMapping("/{id}")
    public void excluirMedico(@PathVariable Long id) {
        medicoService.deletarMedico(id);
    }
}

