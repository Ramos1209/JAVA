

package br.com.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author paulo
 */

@Embeddable
public class CompraID implements Serializable{
    @NotNull(message="o numero da nota e obrigatorio")
    @Column(name = "numero_nota",nullable = false)
    private Integer NumeroNota;
    
    @NotNull(message="A pessoa juridica deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa_juridica",referencedColumnName = "id",nullable = false)
    private PessoaJuridica pessoaJuridica;

    public CompraID() {
    }
    
    

    public Integer getNumeroNota() {
        return NumeroNota;
    }

    public void setNumeroNota(Integer NumeroNota) {
        this.NumeroNota = NumeroNota;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.NumeroNota);
        hash = 97 * hash + Objects.hashCode(this.pessoaJuridica);
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
        final CompraID other = (CompraID) obj;
        if (!Objects.equals(this.NumeroNota, other.NumeroNota)) {
            return false;
        }
        if (!Objects.equals(this.pessoaJuridica, other.pessoaJuridica)) {
            return false;
        }
        return true;
    }
    
    
}
