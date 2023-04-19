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
   private Veterinario responsavel;
   private String equipamento;
   private String observacoes;
   
   //crmv,nomevet??
   
   public Afericao(){}
    
   public Afericao(Integer codigo, Double tempMin, Double tempMax, Veterinario responsavel, String equipamento, String observacoes) {
        
        this.codigo = codigo;
        this.tempMin = tempMin;
        this.tempMax = tempMax;        
        this.responsavel = responsavel;
        this.equipamento = equipamento;
        this.observacoes = observacoes;
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

    public Veterinario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Veterinario responsavel) {
        this.responsavel = responsavel;
    }
    
    public String getEquipamento() {
        return equipamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    @Override
    public String toString() {
        return "Afericao{" + "codigo=" + codigo + ", tempMin=" + tempMin + ", tempMax=" + tempMax + ", responsavel=" + responsavel + 
                ", equipamento=" + equipamento + ", observacoes=" + observacoes + '}';
    }   
}