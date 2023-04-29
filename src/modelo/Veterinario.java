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

    public void setCrmv(Integer crmv) {
        this.crmv = crmv;
    }
    
    public Integer getCrmv() {
        return crmv;
    }

    public Veterinario(Integer crmv, String especialidade, Integer codigoFunc, String permissao, String nomeUsuario, String senha, Date dtAdmissao, Date dtLimiteLogin, 
                       TipoFuncionario cargo, String rg, String cpf, String nome, Date dataNasc, String email, String endereco, String complemento, String bairro, 
                       String cidade, String telefone, String celular, Date dtCadastro) {
        
        super(codigoFunc, permissao, nomeUsuario, senha, dtAdmissao, dtLimiteLogin, cargo, rg, cpf, nome, dataNasc, 
              email, endereco, complemento, bairro, cidade, telefone, celular, dtCadastro);
        
        this.crmv = crmv;
        this.especialidade = especialidade;
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