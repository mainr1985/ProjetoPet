package modelo;

import java.io.Serializable;

/**
 *
 * @author Maíra
 */
public class Afericao implements Serializable{
    
   private static final long serialVersionUID = 1L;  
   private Integer codigo;
   private Double tempMin, tempMax;
   private Veterinario veterinario;
   private String equipamento;
   private String observacoes;
   private String dhAfericao;
   
   public Afericao(){}
    
   public Afericao(Integer codigo, Double tempMin, Double tempMax, Veterinario veterinario, String equipamento, String observacoes,String dhAfericao) {
        
        this.codigo = codigo;
        this.tempMin = tempMin;
        this.tempMax = tempMax;        
        this.veterinario = veterinario;
        this.equipamento = equipamento;
        this.observacoes = observacoes;
        this.dhAfericao = dhAfericao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getDhAfericao() {
        return dhAfericao;
    }

    public void setDhAfericao(String dhAfericao) {
        this.dhAfericao = dhAfericao;
    }
    
    
    @Override
    public String toString() {
        return "Afericao{" + "codigo=" + codigo + ", tempMin=" + tempMin + ", tempMax=" + tempMax + ", veterinario=" + veterinario + ", equipamento=" 
                + equipamento + ", observacoes=" + observacoes + ", dhAfericao=" + dhAfericao + '}';
    }
}