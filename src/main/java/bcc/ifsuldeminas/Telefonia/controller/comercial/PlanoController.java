package bcc.ifsuldeminas.Telefonia.controller.comercial;

import bcc.ifsuldeminas.Telefonia.model.entities.comercial.Plano;
import bcc.ifsuldeminas.Telefonia.model.repositories.comercial.PlanoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plano")
public class PlanoController {
    private PlanoRepository planoRepository;

    //delegando ao Spring a instanciacao de planoRepository
    public PlanoController(PlanoRepository planoRepository){
        this.planoRepository = planoRepository;
    }

    @PostMapping
    public Plano create(@RequestBody Plano plano){
        //persistindo os dados do plano no banco
        planoRepository.save(plano);
        return plano;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plano> get(@PathVariable Long id){
        //buscando um plano pelo id informado
        Plano plano = getById(id);
        if(plano == null){
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        //a implementar: tratamento de erros
        return new ResponseEntity<>(plano, HttpStatus.OK);
    }

    @GetMapping
    public List<Plano> list(){
        //obtendo todos os planos cadastrados
        List<Plano> planos = planoRepository.findAll();
        return planos;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plano> update(@PathVariable Long id, @RequestBody Plano plano){
        //obtendo o plano pelo id informado
        Plano planoCadastrado = getById(id);
        if(planoCadastrado == null){
            return new ResponseEntity<Plano>(HttpStatus.NOT_FOUND);
        }
        //atualizando os dados do plano
        planoCadastrado.setNome(plano.getNome());
        planoCadastrado.setValorPorMinuto(plano.getValorPorMinuto());
        //persistindo as alteracoes
        planoRepository.save(planoCadastrado);
        //a implementar: tratamento de erros
        return new ResponseEntity<Plano>(planoCadastrado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        if(!planoRepository.existsById(id)){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        planoRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    private Plano getById(long id){
        Optional<Plano> opt = planoRepository.findById(id);
        //se a busca nao retornou um plano...
        if(!opt.isPresent()){
            return null;
        }
        return opt.get();
    }
}
