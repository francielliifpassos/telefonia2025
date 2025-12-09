package bcc.ifsuldeminas.Telefonia.model.entities.comercial;

import bcc.ifsuldeminas.Telefonia.model.entities.Operadora;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //null e´ diferente de "" (string vazia)
    @NotNull
    @NotBlank
    private String nome;
    @NotNull
    @DecimalMin(value="1.49")
    private double valorPorMinuto;
    //Se fosse bidirecional o relacionamento Operadora-Plano:
    @NotNull
    @ManyToOne
    private Operadora operadora;

    //implementacao do construtor padrao e getters e setters
    //para utilizacao pelo Spring para instanciacao de objetos Plano
    public Plano(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorPorMinuto() {
        return valorPorMinuto;
    }

    public void setValorPorMinuto(double valorPorMinuto) {
        this.valorPorMinuto = valorPorMinuto;
    }

    public Operadora getOperadora() {
        return operadora;
    }

    public void setOperadora(Operadora operadora) {
        this.operadora = operadora;
    }
}
