package modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Maíra
 */
public class Tutor extends Pessoa implements Serializable{
    
    private static final long serialVersionUID = 1L;  
    private Integer codigoTutor;
           
    public Tutor(){        
    }

    public Tutor(Integer codigoTutor, String rg, String cpf, String nome, Date dataNasc, String email, String endereco, String complemento, 
                 String bairro, String cidade, String telefone, String celular, Date dtCadastro) {
        super(rg, cpf, nome, dataNasc, email, endereco, complemento, bairro, cidade, telefone, celular, dtCadastro);
        this.codigoTutor = codigoTutor;
    }
    public Integer getCodigoTutor() {
        return codigoTutor;
    }

    public void setCodigoTutor(Integer codigoTutor) {
        this.codigoTutor = codigoTutor;
    }

    @Override
    public String toString() {
        return "Tutor{" + "codigoTutor=" + codigoTutor + '}';
    }
}