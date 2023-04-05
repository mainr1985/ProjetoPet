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

    public Veterinario(Integer crmv, String especialidade, Integer codigoFunc, TipoFuncionario cargo, String permissao, String nomeUsuario, String senha, Date dtAdmissao, Date dtCadastro, Date dtLimiteLogin, TipoFuncionario tipoFuncionario, String rg, String cpf, String nome, Date dataNasc, String email, String endereco, String complemento, String bairro, String cidade, String telefone, String celular) {
        super(codigoFunc, cargo, permissao, nomeUsuario, senha, dtAdmissao, dtCadastro, dtLimiteLogin, tipoFuncionario, rg, cpf, nome, dataNasc, email, endereco, complemento, bairro, cidade, telefone, celular);
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