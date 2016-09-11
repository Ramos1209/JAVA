/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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

}
