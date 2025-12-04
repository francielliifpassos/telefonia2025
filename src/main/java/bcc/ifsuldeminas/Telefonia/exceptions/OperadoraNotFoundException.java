package bcc.ifsuldeminas.Telefonia.exceptions;

public class OperadoraNotFoundException extends RuntimeException{
    public OperadoraNotFoundException(Long id){
        super("Operadora # " + id + " não encontrada.");
    }
}
