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
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author paulo
 */
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_endereco",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(length = 50,nullable = false)
    private String nickname;
    
    @Column(length = 200,nullable = false)
    private String endereco;
    
    @Column(length = 10,nullable = false)
    private String numero;
    
    @Column(length = 10)
    private String cep;
    
    @Column(length = 40,nullable = false)
    private String bairro;
    
    @Column(length = 30)
    private String complemento;
    
    @Column(length = 50)
    private String referencia;
    
    @NotNull(message = "A pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa_id",referencedColumnName = "id",nullable = false)
    @ForeignKey(name = "fk_pessoa_id")
    private Pessoa pessoa;
     @NotNull(message = "O endereco deve ser informada")
    @ManyToOne
    @JoinColumn(name = "endereco_id",referencedColumnName = "id",nullable = false)
    @ForeignKey(name = "fk_endereco_id")
    private TipoEndereco tipoEndereco; 

    public Endereco() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }
    
}
