package modelo.enums;
/**
 *
 * @author Maíra
 */
public enum TipoEspecie {
    CANINA ("Canina"),
    FELINA ("Felina");
    
    private final String descricao;

    private TipoEspecie(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString() {
        return descricao;
    }    
}