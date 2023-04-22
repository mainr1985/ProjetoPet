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
    private String apelido;
    private Integer idade;
    private String cor;
    private Date dtNascimento;    
    private String raca;
    private TipoEspecie especie;
    private String porte;
    private Boolean esterelizado;
    private Date dtCadastro;    
   
    private Tutor tutor;    

    public Paciente() {
    }

    public Paciente(Integer codigoPaciente, String nome, String apelido, Integer idade, Date dtNascimento, String cor, 
                    String raca, TipoEspecie especie, String porte, Boolean esterelizado, Tutor tutor, Date dtCadastro) {
        
        this.codigoPaciente = codigoPaciente;
        this.nome = nome;
        this.apelido = apelido;
        this.idade = idade;
        this.dtNascimento = dtNascimento;
        this.cor = cor;
        this.raca = raca;
        this.especie = especie;
        this.porte = porte;
        this.esterelizado = esterelizado;        
        this.dtCadastro = dtCadastro;
        this.tutor = tutor;
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

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public Boolean getEsterelizado() {
        return esterelizado;
    }

    public void setEsterelizado(Boolean esterelizado) {
        this.esterelizado = esterelizado;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    @Override
    public String toString() {
        return "Paciente{" + "codigoPaciente=" + codigoPaciente + ", nome=" + nome + ", apelido=" + apelido + ", idade=" + idade 
                           + ", cor=" + cor + ", dtNascimento=" + dtNascimento + ", raca=" + raca + ", especie=" + especie 
                           + ", porte=" + porte + ", esterelizado=" + esterelizado + ", dtCadastro=" + dtCadastro + ", tutor=" + tutor + '}';
    }
}