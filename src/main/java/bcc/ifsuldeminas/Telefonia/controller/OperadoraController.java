package bcc.ifsuldeminas.Telefonia.controller;

import bcc.ifsuldeminas.Telefonia.model.entities.Operadora;
import bcc.ifsuldeminas.Telefonia.model.services.OperadoraService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operadora")
public class OperadoraController {
    private OperadoraService operadoraService;

    public OperadoraController(OperadoraService operadoraService){
        this.operadoraService = operadoraService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid Operadora operadora){
        this.operadoraService.create(operadora);
        return new ResponseEntity(operadora, HttpStatus.CREATED);
    }
}
