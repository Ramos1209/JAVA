/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_estado" ,sequenceName = "seq_estado_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_estado",strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(length = 50,nullable = false)
    private String nome;
    @Column(length = 2,nullable = false)
    private String uf;
    
    @ManyToOne
    @JoinColumn(name = "pais" ,referencedColumnName = "id", nullable = false)
    private Pais Pais;

    public Estado() {
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the Pais
     */
    public Pais getPais() {
        return Pais;
    }

    /**
     * @param Pais the Pais to set
     */
    public void setPais(Pais Pais) {
        this.Pais = Pais;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
