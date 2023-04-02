package modelo;

import java.io.Serializable;
import java.util.Date;
import modelo.enums.TipoFuncionario;

/**
 *
 * @author Maíra
 */
public class Veterinario extends Funcionario implements Serializable{
    
    private static final long serialVersionUID = 1L;  
    private Integer crmv;
    private String especialidade;

    public Veterinario(){
    }

    public Veterinario(Integer crmv, String especialidade, Integer codigoFunc, String cargo, String permissao, String nomeUsuario, String senha, Date dtAdmissao, Date dtLimiteLogin, TipoFuncionario tipoFuncionario, 
                       Endereco endereco, Contato contato, String rg, String cpf, String nome, Date dataNasc) {
        
        super(codigoFunc, cargo, permissao, nomeUsuario, senha, dtAdmissao, dtLimiteLogin, tipoFuncionario, endereco, contato, rg, cpf, nome, dataNasc);
        this.crmv = crmv;
        this.especialidade = especialidade;
    }

    public void setCrmv(Integer crmv) {
        this.crmv = crmv;
    }
    
    public Integer getCrmv() {
        return crmv;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }    

    @Override
    public String toString() {
        return "Veterinario{" + "crmv=" + crmv + ", especialidade=" + especialidade + '}';
    }
}