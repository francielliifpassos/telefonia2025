package bcc.ifsuldeminas.Telefonia.model.services;

import bcc.ifsuldeminas.Telefonia.exceptions.OperadoraNotFoundException;
import bcc.ifsuldeminas.Telefonia.exceptions.comercial.PlanoNotFoundException;
import bcc.ifsuldeminas.Telefonia.model.entities.Operadora;
import bcc.ifsuldeminas.Telefonia.model.entities.comercial.Plano;
import bcc.ifsuldeminas.Telefonia.model.repositories.OperadoraRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OperadoraService {
    private OperadoraRepository operadoraRepository;

    public OperadoraService(OperadoraRepository operadoraRepository){
        this.operadoraRepository = operadoraRepository;
    }

    public Operadora create(Operadora operadora){
        operadoraRepository.save(operadora);
        return operadora;
    }

    public Operadora addPlano(Operadora operadora, Plano plano){
        operadora.getPlanos().add(plano);
        operadoraRepository.save(operadora);
        return operadora;
    }

    public Operadora get(Long id){
        Optional<Operadora> opt = operadoraRepository.findById(id);
        //se a busca nao retornou um plano...
        if(!opt.isPresent()){
            throw new OperadoraNotFoundException(id);
        }
        return opt.get();
    }
}
