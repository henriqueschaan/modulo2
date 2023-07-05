package exercicios.modulo2.service;

import exercicios.modulo2.domain.Consulta;
import exercicios.modulo2.domain.Medico;
import exercicios.modulo2.domain.Paciente;
import exercicios.modulo2.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private PacienteService pacienteService;
    
    public Consulta criarConsulta(Long medicoId, Long pacienteId, Date dataConsulta) {
        
        if (medicoId == null) {
            throw new RuntimeException("Médico não informado");
        }
        
        if (pacienteId == null) {
            throw new RuntimeException("Paciente não informado");
        }

        if (dataConsulta == null) {
            throw new RuntimeException("Data da consulta não informada");
        }
        
        Medico medico = medicoService.buscarMedico(medicoId);
        if (medico == null) {
            throw new RuntimeException("Médico não encontrado");
        }

        Paciente paciente = pacienteService.buscarPaciente(pacienteId);
        if (paciente == null) {
            throw new RuntimeException("Paciente não encontrado");
        }
        
        if (dataConsulta.before(new Date())) {
            throw new RuntimeException("Data da consulta não pode ser anterior a data atual");
        }
        
        Consulta consulta = new Consulta(medico, paciente, dataConsulta);

        return consultaRepository.save(consulta);
        
    }

}
