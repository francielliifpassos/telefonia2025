package bcc.ifsuldeminas.Telefonia.model.entities;

import bcc.ifsuldeminas.Telefonia.model.entities.comercial.Celular;
import bcc.ifsuldeminas.Telefonia.model.entities.comercial.Plano;
import bcc.ifsuldeminas.Telefonia.model.entities.pessoal.Cliente;

import java.util.List;

public class Operadora {
    private String nome;
    private List<Cliente> clientes;
    private List<Celular> celulares;
    private List<Plano> planos;
}
