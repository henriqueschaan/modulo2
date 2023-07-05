package exercicios.modulo2.service;

import exercicios.modulo2.domain.Paciente;
import exercicios.modulo2.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente criarPaciente(Paciente paciente) {
        if (paciente.getNome() == null || paciente.getDataDeNascimento() == null ||
                paciente.getCpf() == null || paciente.getEmail() == null) {
            throw new RuntimeException("Todos os campos devem ser preenchidos");
        }

        if (!validarCPF(paciente.getCpf())) {
            throw new RuntimeException("CPF inválido");
        }

        if (!validarEmail(paciente.getEmail())) {
            throw new RuntimeException("Email inválido");
        }

        if (pacienteRepository.findByCpf(paciente.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já existente");
        }

        if (pacienteRepository.findByEmail(paciente.getEmail()).isPresent()) {
            throw new RuntimeException("Email já existente");
        }

        return pacienteRepository.save(paciente);
    }

    private boolean validarCPF(String cpf) {
        return cpf.matches("\\d{11}");
    }

    private boolean validarEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public Paciente atualizarPaciente(Long id, Paciente paciente) {

        if (pacienteRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Paciente não encontrado");
        }

        if (!validarCPF(paciente.getCpf())) {
            throw new RuntimeException("CPF inválido");
        }

        if (!validarEmail(paciente.getEmail())) {
            throw new RuntimeException("Email inválido");
        }

        if (pacienteRepository.findByCpf(paciente.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já existente");
        }

        if (pacienteRepository.findByEmail(paciente.getEmail()).isPresent()) {
            throw new RuntimeException("Email já existente");
        }

        if (paciente.getNome() != null) {
            paciente.setNome(paciente.getNome());
        }

        if (paciente.getDataDeNascimento() != null) {
            paciente.setDataDeNascimento(paciente.getDataDeNascimento());
        }

        if (paciente.getCpf() != null) {
            paciente.setCpf(paciente.getCpf());
        }

        if (paciente.getEmail() != null) {
            paciente.setEmail(paciente.getEmail());
        }

        return pacienteRepository.save(paciente);

    }

    public Paciente buscarPaciente(Long id) {
        return pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }

    public void deletarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

}
