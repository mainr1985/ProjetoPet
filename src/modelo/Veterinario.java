package modelo;

import java.io.Serializable;
import java.util.Date;
import modelo.enums.TipoPessoa;

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

    public Veterinario(Integer crmv, String especialidade, String cargo, String permissao, 
                       String nomeUsuario, String senha, Date dtAdmissao, Date dtDemissao, String rg, String cpf, 
                       String nome, Endereco endereco, Contato contato, TipoPessoa tipoPessoa) {
        
        super(cargo, permissao, nomeUsuario, senha, dtAdmissao, dtDemissao, rg, cpf, nome, endereco, contato, tipoPessoa);
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