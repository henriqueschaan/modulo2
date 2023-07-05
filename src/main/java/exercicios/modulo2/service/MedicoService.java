package exercicios.modulo2.service;

import exercicios.modulo2.domain.Medico;
import exercicios.modulo2.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico salvarMedico(Medico medico) {
        if (medico.getNome() == null) {
            throw new RuntimeException("O nome do médico deve ser preenchido");
        }
        
        return medicoRepository.save(medico);
    }
    
    public Medico buscarMedico(Long id) {
        return medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Medico não encontrado"));
    }
    
    public Medico atualizarMedico(Long id, Medico medico) {
        if (medico.getId() == null || medico.getNome() == null || medico.getEspecialidade() == null) {
            throw new RuntimeException("Todos os campos devem ser preenchidos");
        }

        return medicoRepository.save(medico);
    }
    
    public void deletarMedico(Long id) {
        medicoRepository.deleteById(id);
    }
    
    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }

}
