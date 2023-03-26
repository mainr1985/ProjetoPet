package modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Maíra
 */
public class Paciente implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    private String nome;
    private String raca;
    private Date nascimento;
    private Integer idade;
    private Tutor tutor;
    
    public void setNome (String nome)
    {
        this.nome = nome;
    }
    
    public String getNome ()
    {
        return this.nome;
    }
    
    public void setRaca(String raca)
    {
        this.raca = raca;
    }
    
    public String getRaca()
    {
        return this.raca;
    }
    
    public void setNascimento(Date nascimento)
    {
        this.nascimento = nascimento;
    }
    
    public Date getNascimento()
    {
        return this.nascimento;
    }
    
    public void setIdade(Integer idade)
    {
        this.idade = idade;
    }
    
    public Integer getIdade()
    {
        return this.idade;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }   

    @Override
    public String toString() {
        return "Paciente{" + "nome=" + nome + ", raca=" + raca + ", nascimento=" + nascimento + ", idade=" + idade + ", tutor=" + tutor + '}';
    }
}