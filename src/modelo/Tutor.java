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
    private Date dtCadastro;
       
    public Tutor(){        
    }

    public Tutor(Integer codigoTutor, Date dtCadastro, String rg, String cpf, String nome, Date dataNasc, String email, String endereco, 
                 String complemento, String bairro, String cidade, String telefone) {
        
        super(rg, cpf, nome, dataNasc, email, endereco, complemento, bairro, cidade, telefone);
        this.codigoTutor = codigoTutor;
        this.dtCadastro = dtCadastro;
    }

    public Integer getCodigoTutor() {
        return codigoTutor;
    }

    public void setCodigoTutor(Integer codigoTutor) {
        this.codigoTutor = codigoTutor;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    @Override
    public String toString() {
        return "Tutor{" + "codigoTutor=" + codigoTutor + ", dtCadastro=" + dtCadastro + '}';
    }
}