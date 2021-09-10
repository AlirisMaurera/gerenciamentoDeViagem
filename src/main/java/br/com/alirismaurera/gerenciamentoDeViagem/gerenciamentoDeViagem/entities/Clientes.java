package br.com.alirismaurera.gerenciamentoDeViagem.gerenciamentoDeViagem.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "cpf")})
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobreNome;


    @CPF(message = "Cpf invalido")
    @Column(nullable = false, unique = true)
    private String cpf;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE})
    @Column(nullable = false)
    private List<Telefone> tlf;

    @Column(nullable = false)
    private Viagens viagens;
}
