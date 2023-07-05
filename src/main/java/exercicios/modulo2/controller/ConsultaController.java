package exercicios.modulo2.controller;

import exercicios.modulo2.domain.Consulta;
import exercicios.modulo2.domain.DadosConsulta;
import exercicios.modulo2.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public Consulta criarConsulta(@RequestBody DadosConsulta dadosConsulta) {
        return consultaService.criarConsulta(dadosConsulta.medicoId(), dadosConsulta.pacienteId(), dadosConsulta.dataConsulta());
    }

}
