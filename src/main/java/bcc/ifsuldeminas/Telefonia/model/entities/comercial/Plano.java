package bcc.ifsuldeminas.Telefonia.model.entities.comercial;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private double valorPorMinuto;
    //Se fosse bidirecional o relacionamento Operadora-Plano:
    //@ManyToOne
    //private Operadora operadora;

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
}
