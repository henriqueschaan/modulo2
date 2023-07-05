package exercicios.modulo2.domain;

import java.util.Date;

public record DadosConsulta(Long medicoId, Long pacienteId, Date dataConsulta) {
}
