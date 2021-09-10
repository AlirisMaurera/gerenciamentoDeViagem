package br.com.alirismaurera.gerenciamentoDeViagem.gerenciamentoDeViagem.entities;

import br.com.alirismaurera.gerenciamentoDeViagem.gerenciamentoDeViagem.constantes.TipoTelefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoTelefone tipo;

    @Column(nullable = false)
    private String numero;
}
