package modelo;

import java.io.Serializable;
import java.util.Date;
import modelo.enums.TipoFuncionario;

/**
 *
 * @author Maíra & Rafael
 */
public abstract class Funcionario extends Pessoa implements Serializable {
    
    private static final long serialVersionUID = 1L;  
    private Integer codigoFunc;
    private Date dtAdmissao;
    private TipoFuncionario cargo;
        
    public Funcionario (){}

    public Funcionario(Integer codigoFunc, Date dtAdmissao, TipoFuncionario cargo, String rg, String cpf, 
                       String nome, Date dataNasc, String email, String endereco, String complemento, 
                       String bairro, String cidade, String telefone, String celular, Date dtCadastro) {
        
        super(rg, cpf, nome, dataNasc, email, endereco, complemento, bairro, cidade, telefone, celular, dtCadastro);
        this.codigoFunc = codigoFunc;
        this.dtAdmissao = dtAdmissao;        
        this.cargo = cargo;
    }

    public TipoFuncionario getCargo() {
        return cargo;
    }

    public void setCargo(TipoFuncionario cargo) {
        this.cargo = cargo;
    }
    
    public Date getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(Date dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    public Integer getCodigoFunc() {
        return codigoFunc;
    }

    public void setCodigoFunc(Integer codigoFunc) {
        this.codigoFunc = codigoFunc;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "codigoFunc=" + codigoFunc + ", dtAdmissao=" + dtAdmissao + ", cargo=" + cargo + '}';
    }
}