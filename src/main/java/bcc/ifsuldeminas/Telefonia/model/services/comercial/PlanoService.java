package bcc.ifsuldeminas.Telefonia.model.services.comercial;

import bcc.ifsuldeminas.Telefonia.exceptions.comercial.PlanoNotFoundException;
import bcc.ifsuldeminas.Telefonia.model.entities.comercial.Plano;
import bcc.ifsuldeminas.Telefonia.model.repositories.comercial.PlanoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoService {
    private PlanoRepository planoRepository;

    public PlanoService(PlanoRepository planoRepository){
        this.planoRepository = planoRepository;
    }

    public Plano create(Plano plano){
        return planoRepository.save(plano);
    }

    public Plano get(Long id){
        Optional<Plano> opt = planoRepository.findById(id);
        //se a busca nao retornou um plano...
        if(!opt.isPresent()){
            throw new PlanoNotFoundException(id);
        }
        return opt.get();
    }

    public List<Plano> get(){
        return planoRepository.findAll();
    }

    public Plano update(Long id, Plano plano){
        //obtendo o plano pelo id informado
        Plano planoCadastrado = get(id);
        //atualizando os dados do plano
        planoCadastrado.setNome(plano.getNome());
        planoCadastrado.setValorPorMinuto(plano.getValorPorMinuto());
        //persistindo as alteracoes
        planoRepository.save(planoCadastrado);
        return planoCadastrado;
    }

    public void delete(Long id){
        //se nao encontrou um plano com o id informado...
        if(!planoRepository.existsById(id)){
            throw new PlanoNotFoundException(id);
        }
        planoRepository.deleteById(id);
    }
}
