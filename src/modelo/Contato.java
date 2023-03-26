package modelo;

import java.io.Serializable;

/**
 *
 * @author Maíra
 */
public class Contato implements Serializable{
    
    private static final long serialVersionUID = 1L;  
    String ddd;
    String numero;
    String email;

    public Contato() {
    }

    public Contato(String ddd, String numero, String email) {
        this.ddd = ddd;
        this.numero = numero;
        this.email = email;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contato{" + "ddd=" + ddd + ", numero=" + numero + ", email=" + email + '}';
    }   
}