package bcc.ifsuldeminas.Telefonia.resource.comercial;

import bcc.ifsuldeminas.Telefonia.exceptions.comercial.PlanoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PlanoResourceAdvice {
    //metodo que trata excecoes PlanoNotFoundException
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PlanoNotFoundException.class)
    public String planoNotFoundHandler(PlanoNotFoundException pnfe){
        return pnfe.getMessage();
    }
}
