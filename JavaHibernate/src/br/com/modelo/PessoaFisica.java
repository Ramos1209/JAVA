/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author paulo
 */
@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Pessoa implements Serializable {

    @Column(length = 15, nullable = false)
    private String rg;
    @CPF
    @Column(length = 14, nullable = false)
    private String cpf;
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento",nullable = false)
    private Calendar nascimento;
    @Column(length = 50, nullable = false)
    private String nomeUsuario;
    @Column(length = 40, nullable = false)
    private String senha;
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "desejos",joinColumns = @JoinColumn(name = "pessoa_fisica",referencedColumnName = "id",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "produto",referencedColumnName = "id",nullable = false),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"pessoa_fisica","produto"})})
    
    private List<Produto> desejos = new ArrayList<>();

    public PessoaFisica() {
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.rg);
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
        final PessoaFisica other = (PessoaFisica) obj;
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        return true;
    }

    public List<Produto> getDesejos() {
        return desejos;
    }

    public void setDesejos(List<Produto> desejos) {
        this.desejos = desejos;
    }

}
