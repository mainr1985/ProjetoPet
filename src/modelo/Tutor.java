package modelo;

import java.io.Serializable;
import java.util.Date;
import modelo.enums.TipoPessoa;

/**
 *
 * @author Maíra
 */
public class Tutor extends PessoaFisica implements Serializable{
    
    private static final long serialVersionUID = 1L;  
    private Integer codTutor;
    private Date dtCadastro;
       
    public Tutor(){
        
    }

    public Tutor(Integer codTutor, Date dtCadastro, String rg, String cpf, String nome, Endereco endereco, Contato contato, TipoPessoa tipoPessoa) {
        super(rg, cpf, nome, endereco, contato, tipoPessoa);
        this.codTutor = codTutor;
        this.dtCadastro = dtCadastro;
    }

    public Integer getCodTutor() {
        return codTutor;
    }

    public void setCodTutor(Integer codTutor) {
        this.codTutor = codTutor;
    }   

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    @Override
    public String toString() {
        return "Tutor{" + "codTutor=" + codTutor + ", dtCadastro=" + dtCadastro + '}';
    }
}