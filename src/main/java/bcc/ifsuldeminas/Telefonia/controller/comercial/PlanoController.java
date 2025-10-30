package bcc.ifsuldeminas.Telefonia.controller.comercial;

import bcc.ifsuldeminas.Telefonia.model.entities.comercial.Plano;
import bcc.ifsuldeminas.Telefonia.model.repositories.comercial.PlanoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public Plano get(@PathVariable Long id){
        //buscando um plano pelo id informado
        Plano plano = planoRepository.getById(id);
        //a implementar: tratamento de erros
        return plano;
    }

    @GetMapping
    public List<Plano> list(){
        //obtendo todos os planos cadastrados
        List<Plano> planos = planoRepository.findAll();
        return planos;
    }

    @PutMapping("/{id}")
    public Plano update(@PathVariable Long id, @RequestBody Plano plano){
        //obtendo o plano pelo id informado
        Plano planoCadastrado = planoRepository.getById(id);
        //atualizando os dados do plano
        planoCadastrado.setNome(plano.getNome());
        planoCadastrado.setValorPorMinuto(plano.getValorPorMinuto());
        //persistindo as alteracoes
        planoRepository.save(planoCadastrado);
        //a implementar: tratamento de erros
        return planoCadastrado;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        planoRepository.deleteById(id);
    }
}
