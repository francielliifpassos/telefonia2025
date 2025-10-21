package bcc.ifsuldeminas.Telefonia.model.entities.comercial;

import bcc.ifsuldeminas.Telefonia.model.entities.pessoal.Cliente;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "classe")
public class Celular {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long numero;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Plano plano;
    @OneToMany
    @JoinColumn(name = "celular_id")
    private List<Ligacao> ligacoes;
}
