/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author paulo
 */
@Entity
@Table(name = "orcamentos")
public class Orcamentos {
    @Id
    @SequenceGenerator(name = "seq_orcamento",sequenceName = "seq_orcamento_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_orcamento",strategy = GenerationType.SEQUENCE)
   private int id;
    @Column(nullable = false)
   private Date dataDoOrcamento;
    @Column(length = 2,nullable = false)
   private boolean aprovado;
    @Column(nullable = false)
   private Date dataAprovacao;
    @Column(length = 40)
   private Enum Tipo;
   
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id" )
    
   private Cliente cliente;
    
  

    public Orcamentos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataDoOrcamento() {
        return dataDoOrcamento;
    }

    public void setDataDoOrcamento(Date dataDoOrcamento) {
        this.dataDoOrcamento = dataDoOrcamento;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public Enum getTipo() {
        return Tipo;
    }

    public void setTipo(Enum Tipo) {
        this.Tipo = Tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
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
        final Orcamentos other = (Orcamentos) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
