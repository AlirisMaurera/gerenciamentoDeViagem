package br.com.alirismaurera.gerenciamentoDeViagem.gerenciamentoDeViagem.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Viagens implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(nullable = false)
    private String destino;


    @Column(nullable = false)
    private String dataPartida;


    @Column(nullable = true)
    private String dataDeRetorno;

    @Column(nullable = true)
    private String acompanhantes;
}
