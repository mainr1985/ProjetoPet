package modelo;

import java.io.Serializable;
import java.util.Date;
import modelo.enums.TipoEspecie;

/**
 *
 * @author Maíra
 */
public class Paciente implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    private Integer codigoPaciente;
    private String nome;
    private Integer idade;
    private Date dtNascimento;    
    private String raca;
    private Tutor tutor;
    private TipoEspecie especie;

    public Paciente() {
    }

    public Paciente(Integer codigoPaciente, String nome, Integer idade, Date dtNascimento, String raca, Tutor tutor, TipoEspecie especie) {
        this.codigoPaciente = codigoPaciente;
        this.nome = nome;
        this.idade = idade;
        this.dtNascimento = dtNascimento;
        this.raca = raca;
        this.tutor = tutor;
        this.especie = especie;
    }

    public Integer getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(Integer codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }
    
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
    
    public void setDtNascimento(Date dtNascimento)
    {
        this.dtNascimento = dtNascimento;
    }
    
    public Date getDtNascimento()
    {
        return this.dtNascimento;
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

    public TipoEspecie getEspecie() {
        return especie;
    }

    public void setEspecie(TipoEspecie especie) {
        this.especie = especie;
    }

    @Override
    public String toString() {
        return "Paciente{" + "codigoPaciente=" + codigoPaciente + ", nome=" + nome + ", idade=" + idade + 
                         ", dtNascimento=" + dtNascimento + ", raca=" + raca + ", tutor=" + tutor + ", especie=" + especie + '}';
    }
}