package exercicios.modulo2.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="medico_id", nullable=false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name="paciente_id", nullable=false)
    private Paciente paciente;

    @Column(nullable = false)
    private Date dataDaConsulta;

    public Consulta(Medico medico, Paciente paciente, Date dataConsulta) {
        this.medico = medico;
        this.paciente = paciente;
        this.dataDaConsulta = dataConsulta;
    }
}
