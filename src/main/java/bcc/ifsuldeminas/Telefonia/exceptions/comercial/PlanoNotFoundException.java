package bcc.ifsuldeminas.Telefonia.exceptions.comercial;

public class PlanoNotFoundException extends RuntimeException{
    public PlanoNotFoundException(Long id){
        super("Plano #" + id + " não encontrado!");
    }
}
