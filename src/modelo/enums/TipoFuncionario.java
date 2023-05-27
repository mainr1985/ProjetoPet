package modelo.enums;
/**
 *
 * @author Maíra
 */
public enum TipoFuncionario {
    VETERINARIO ("Veterinario"),
    ADMINISTRADOR ("Administrador"),
    ASSISTENTE ("Assistente");
    
    public final String descricao;

    private TipoFuncionario(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}