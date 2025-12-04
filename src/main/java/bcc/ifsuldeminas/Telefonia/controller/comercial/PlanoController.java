package bcc.ifsuldeminas.Telefonia.controller.comercial;

import bcc.ifsuldeminas.Telefonia.exceptions.comercial.PlanoNotFoundException;
import bcc.ifsuldeminas.Telefonia.model.entities.Operadora;
import bcc.ifsuldeminas.Telefonia.model.entities.comercial.Plano;
import bcc.ifsuldeminas.Telefonia.model.services.comercial.PlanoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plano")
public class PlanoController {
    private PlanoService planoService;

    //delegando ao Spring a instanciacao de planoRepository
    public PlanoController(PlanoService planoService){
        this.planoService = planoService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid Plano plano, @RequestParam("operadoraId") Long operadoraId){
        plano = planoService.create(plano, operadoraId);
        return new ResponseEntity<Plano>(plano, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Long id){
        Plano plano = planoService.get(id);
        return new ResponseEntity(plano, HttpStatus.OK);
    }

    @GetMapping
    public List<Plano> list(){
        //obtendo todos os planos cadastrados
        List<Plano> planos = planoService.get();
        return planos;
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody @Valid Plano plano){
        Plano planoAtualizado = planoService.update(id, plano);
        return new ResponseEntity(planoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        planoService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
