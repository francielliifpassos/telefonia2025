package bcc.ifsuldeminas.Telefonia.model.entities;

import bcc.ifsuldeminas.Telefonia.model.entities.comercial.Celular;
import bcc.ifsuldeminas.Telefonia.model.entities.comercial.Plano;
import bcc.ifsuldeminas.Telefonia.model.entities.pessoal.Cliente;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Operadora {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    @OneToMany
    @JoinColumn(name = "operadora_id")
    private List<Cliente> clientes;
    @OneToMany
    @JoinColumn(name = "operadora_id")
    private List<Celular> celulares;
    @OneToMany
    @JoinColumn(name = "operadora_id")
    private List<Plano> planos;
}
