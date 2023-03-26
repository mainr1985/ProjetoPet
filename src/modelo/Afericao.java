package modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Maíra
 */
public class Afericao implements Serializable{
    
   private static final long serialVersionUID = 1L;  
   private Integer codigo;
   private Double tempMin, tempMax, tempMomento;
   private Veterinario responsavel;
    
   public Afericao(Integer codigo, Double tempMin, Double tempMax, Double tempMomento, Veterinario responsavel) {
        this.codigo = codigo;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.tempMomento = tempMomento;
        this.responsavel = responsavel;
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

    public Double getTempMomento() {
        return tempMomento;
    }

    public void setTempMomento(Double tempMomento) {
        this.tempMomento = tempMomento;
    }

    public Veterinario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Veterinario responsavel) {
        this.responsavel = responsavel;
    }
    
    public void cadastrarMedicao(Afericao temperatura){
        
    }    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Afericao other = (Afericao) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }    

    @Override
    public String toString() {
        return "Afericao{" + "codigo=" + codigo + ", tempMin=" + tempMin + ", tempMax=" + tempMax + ", tempMomento=" + tempMomento + ", responsavel=" + responsavel + '}';
    }
}