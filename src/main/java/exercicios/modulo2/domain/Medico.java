package exercicios.modulo2.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String especialidade;
    
}
